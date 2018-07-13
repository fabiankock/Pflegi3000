package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller;

import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.MedikamenteFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.PatientNames;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.AppointmentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class ControllerMedikamentFragment  {

    public MedikamenteFragment activity;
    public DaoFactory daofactory;

    public ControllerMedikamentFragment(MedikamenteFragment activity, ShowPatientActivity mainactivity) {
        this.activity = activity;
        this.daofactory = (DaoFactory) mainactivity.getApplication();

    }

    //Liste mit allen Medikamenten füllen
    // TODO muss noch nach Patient gefiltert werden
    public ArrayList<MedikamentEntity> getAllMedicals() {

        PatientNames tmp;
        ArrayList<MedikamentEntity> list = new ArrayList<>();

        try{
            Dao<MedikamentEntity, Integer> aDao = daofactory.getMedikamentDAO();

            List<MedikamentEntity> allMedikamentEntities = aDao.queryForAll();
            for(int i = 0; i < allMedikamentEntities.size(); i++){

                list.add(allMedikamentEntities.get(i));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
