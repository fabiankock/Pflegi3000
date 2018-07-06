package comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller;

import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.TerminEntity;

public class ControllerAddPatientActivity {

    private DaoFactory daofactory;
    private AddPatientActivity addPatientActivity;
    private AddPatientButtonListener btnListener;

    public ControllerAddPatientActivity(AddPatientActivity theActivity){

        this.addPatientActivity = theActivity;
        this.btnListener = new AddPatientButtonListener(this);
        this.daofactory = (DaoFactory) addPatientActivity.getApplication();
    }

    public String[] getAllInsurances(){

        String[] ret = null;

        try{
            Dao<InsuranceEntity, Integer> iDao = daofactory.getInsuranceDAO();
            List<InsuranceEntity> insurances = iDao.queryForAll();

            Log.d("insuranceDB", "size: "+insurances.size());
            ret = new String[insurances.size()];
            for(int i = 0; i < insurances.size(); i++){
                ret[i] = insurances.get(i).getName() + " " + insurances.get(i).getType();
                Log.d("insuranceDB", ret[i]);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return ret;
    }

    public void processInput() {

        int insNr = Integer.parseInt(this.addPatientActivity.getInsuranceNrValue());
        char gender = this.addPatientActivity.getGenderValue().toCharArray()[0];

        try {

            Dao<PatientEntity, Integer> pDao = daofactory.getPatientDAO();
            Dao<InsuranceEntity, Integer> iDao = daofactory.getInsuranceDAO();

            MedikamentEntity tpMedikament = new MedikamentEntity();
            //Get the insurance Data
            //InsuranceEntity insuranceEntity = iDao.queryForId()
            TerminEntity tpTermin = new TerminEntity();
            PatientEntity tpPatient = new PatientEntity(this.addPatientActivity.getFirstNameValue(), this.addPatientActivity.getLastNameValue(),
                                                        gender, insNr,
                                                        /*insurance*/null,
                                                        /*medications*/null, /*appointments*/null);

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
