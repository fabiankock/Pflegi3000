package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment;

import android.support.v4.app.DialogFragment;
import android.view.View;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.main_activity.MainActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.DatePickerFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.PatientFragment;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;

public class PatientFragmentButtonListener implements View.OnClickListener{

    private ControllerPatientFragment controller;
    private int patient_id;
    private PatientFragment activity;
    private ShowPatientActivity mainactivity;

    public PatientFragmentButtonListener(ControllerPatientFragment c, int id, ShowPatientActivity activity){

        this.controller = c;
        this.patient_id = id;
        this.mainactivity = activity;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.date_picker:

                DialogFragment dateFragment = new DatePickerFragment(controller);
                dateFragment.show(this.mainactivity.getfPatient().getFragmentManager(), "Geburtsdatum");

                break;

            case R.id.delete_button:
                try {
                    this.controller.deletePatientById(this.patient_id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                AndroidHelper.startNewActivity(view.getContext(), MainActivity.class);
                break;

            case R.id.fabPatient:
                try {
                    controller.switchView();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
