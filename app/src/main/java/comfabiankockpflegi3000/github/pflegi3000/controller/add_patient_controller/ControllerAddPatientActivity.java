package comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller;

import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.AppointmentEntity;

public class ControllerAddPatientActivity {

    private DaoFactory daofactory;
    private AddPatientActivity addPatientActivity;
    private AddPatientButtonListener btnListener;

    public ControllerAddPatientActivity(AddPatientActivity theActivity){

        this.addPatientActivity = theActivity;
        this.btnListener = new AddPatientButtonListener(this);
        this.daofactory = (DaoFactory) addPatientActivity.getApplication();
    }

    public List<InsuranceEntity> getAllInsurances(){

        List<InsuranceEntity> insurances = null;

        try{
            Dao<InsuranceEntity, Integer> iDao = daofactory.getInsuranceDAO();
            insurances = iDao.queryForAll();

            Log.d("insuranceDB", "size: "+insurances.size());
        }catch(SQLException e){
            e.printStackTrace();
        }

        return insurances;
    }

    public void processInput() {

        int insNr = Integer.parseInt(this.addPatientActivity.getInsuranceNrValue());
        char gender = this.addPatientActivity.getGenderValue();

        try {

            Dao<PatientEntity, Integer> pDao = daofactory.getPatientDAO();
            Dao<InsuranceEntity, Integer> iDao = daofactory.getInsuranceDAO();

            //Get the insurance Data
            InsuranceEntity insuranceEntity = iDao.queryForAll().get(this.addPatientActivity.getInsuranceListPos());
            AppointmentEntity tpTermin = new AppointmentEntity();
            PatientEntity tpPatient = new PatientEntity(this.addPatientActivity.getFirstNameValue(), this.addPatientActivity.getLastNameValue(),
                                                        gender, insNr,
                                                        insuranceEntity);

            pDao.create(tpPatient);
            //Send Database query to insert new Patient

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public AddPatientButtonListener getButtonListener() {

        return btnListener;
    }
}
