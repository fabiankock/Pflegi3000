package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment;

import android.view.View;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.activities.main_activity.MainActivity;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;

public class PatientFragmentButtonListener implements View.OnClickListener{

    private ControllerPatientFragment controller;
    private int patient_id;

    public PatientFragmentButtonListener(ControllerPatientFragment c, int id){

        this.controller = c;
        this.patient_id = id;
    }

    @Override
    public void onClick(View view) {

        try {
            this.controller.deletePatientById(this.patient_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AndroidHelper.startNewActivity(view.getContext(), MainActivity.class);
    }
}
