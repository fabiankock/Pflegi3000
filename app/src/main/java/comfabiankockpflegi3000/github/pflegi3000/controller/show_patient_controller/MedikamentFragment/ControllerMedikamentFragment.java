package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment;

import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.MedikamenteFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.PatientNames;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.AppointmentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class ControllerMedikamentFragment  {

    private MedikamenteFragment activity;
    private ShowPatientActivity mainactivity;
    private DaoFactory daofactory;

    public ControllerMedikamentFragment(MedikamenteFragment activity, ShowPatientActivity mainactivity) {
        this.activity = activity;
        this.mainactivity = mainactivity;
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


    //funktion zum sichtbar und unsichtbar machen von add und show
    public void switchAddShow() {

        ConstraintLayout show = this.mainactivity.findViewById(R.id.show_medikament);
        ConstraintLayout add = this.mainactivity.findViewById(R.id.add_medikament);

        if (add.getVisibility() == View.INVISIBLE) {
            show.setVisibility(View.INVISIBLE);
            add.setVisibility(View.VISIBLE);
        } else {
            add.setVisibility(View.INVISIBLE);
            show.setVisibility(View.VISIBLE);
        }
    }
}
