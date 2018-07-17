package comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller;

import android.util.Log;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.CareEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.AppointmentEntity;

public class ControllerAddPatientActivity {

    private DaoFactory daofactory;
    private AddPatientActivity addPatientActivity;
    private AddPatientButtonListener btnListener;

    private int day = 0,month = 0, year = 0;

    public ControllerAddPatientActivity(AddPatientActivity theActivity){

        this.addPatientActivity = theActivity;
        this.btnListener = new AddPatientButtonListener(addPatientActivity, this);
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

    public boolean processInput() {

        try {

            if(!this.addPatientActivity.getInsuranceNrValue().matches("") &&
                !this.addPatientActivity.getFirstNameValue().matches("") &&
                !this.addPatientActivity.getLastNameValue().matches("") &&
                day != 0 && month != 0 && year != 0 ) {

                int insNr = Integer.parseInt(this.addPatientActivity.getInsuranceNrValue());
                char gender = this.addPatientActivity.getGenderValue();

                Dao<PatientEntity, Integer> pDao = daofactory.getPatientDAO();
                Dao<InsuranceEntity, Integer> iDao = daofactory.getInsuranceDAO();
                Dao<CareEntity, Integer> cDao = daofactory.getCareDAO();

                if(this.addPatientActivity.getInsuranceListPos() > -1) {
                    //Get the insurance Data
                    InsuranceEntity insuranceEntity = iDao.queryForAll().get(this.addPatientActivity.getInsuranceListPos());
                    AppointmentEntity tpTermin = new AppointmentEntity();
                    PatientEntity tpPatient = new PatientEntity(this.addPatientActivity.getFirstNameValue(), this.addPatientActivity.getLastNameValue(),
                            gender, insNr,
                            insuranceEntity);
                    tpPatient.setBirthdate(day, month, year);

                    CareEntity careEntity = new CareEntity(0, 0, 0, tpPatient);
                    cDao.create(careEntity);
                    pDao.create(tpPatient);
                    //Send Database query to insert new Patient
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public AddPatientButtonListener getButtonListener() {

        return btnListener;
    }

    public void setDate(int day, int month, int year) {

        this.day = day;
        this.month = month+1;
        this.year = year;

        addPatientActivity.setBirthdate(this.day, this.month, this.year);
    }
}
