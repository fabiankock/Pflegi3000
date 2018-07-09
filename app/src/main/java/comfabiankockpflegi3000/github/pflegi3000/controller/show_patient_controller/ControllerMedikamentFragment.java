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
    public ArrayList<AppointmentEntity> getAllMedicals() {

        PatientNames tmp;
        ArrayList<AppointmentEntity> list = new ArrayList<>();

        try{
            Dao<AppointmentEntity, Integer> aDao = daofactory.getAppointmentDAO();

            List<AppointmentEntity> allAppointmentEntities = aDao.queryForAll();
            for(int i = 0; i < allAppointmentEntities.size(); i++){

                list.add(allAppointmentEntities.get(i));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
