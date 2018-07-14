package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment;

import android.util.Log;
import android.view.View;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.PatientFragment;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class ControllerPatientFragment {

    private PatientFragment activity;
    private DaoFactory daoFactory;

    public ControllerPatientFragment(PatientFragment activity, ShowPatientActivity mainActivity) {

        this.activity = activity;
        this.daoFactory = (DaoFactory) mainActivity.getApplication();
    }

    public PatientEntity getPatientByID(int id) throws SQLException {

        Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();
        PatientEntity entity = pDao.queryForId(id);

        return entity;
    }

    public InsuranceEntity getInsuranceOfPatient(int id) throws SQLException {

        Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();
        PatientEntity patientEntity = pDao.queryForId(id);

        Dao<InsuranceEntity, Integer> iDao = this.daoFactory.getInsuranceDAO();
        List<InsuranceEntity> insuranceEntities = iDao.queryForAll();

        for(int i = 0; i < insuranceEntities.size(); i++){

            if(insuranceEntities.get(i).getId() == patientEntity.getInsuranceEntity().getId()){

                return insuranceEntities.get(i);
            }
        }

        return null;
    }

    public List<InsuranceEntity> getAllInsurances(){

        List<InsuranceEntity> insurances = null;

        try{
            Dao<InsuranceEntity, Integer> iDao = this.daoFactory.getInsuranceDAO();
            insurances = iDao.queryForAll();

            Log.d("insuranceDB", "size: "+insurances.size());
        }catch(SQLException e){
            e.printStackTrace();
        }

        return insurances;
    }

    public void switchView(){

        if(activity.getEditLayout().getVisibility() == View.VISIBLE){

            activity.getEditLayout().setVisibility(View.INVISIBLE);
            activity.getShowLayout().setVisibility(View.VISIBLE);
        }

        else{

            activity.getEditLayout().setVisibility(View.VISIBLE);
            activity.getShowLayout().setVisibility(View.INVISIBLE);
        }
    }
}
