package comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller;


import android.support.v4.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddDatePickerFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.DatePickerFragment;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.activities.main_activity.MainActivity;
import comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller.ControllerAddPatientActivity;

public class AddPatientButtonListener implements View.OnClickListener {

    private ControllerAddPatientActivity controller;
    private AddPatientActivity activity;

    public AddPatientButtonListener(AddPatientActivity activity, ControllerAddPatientActivity c){

        this.controller = c;
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch(view.getId()) {

            case R.id.back_button_addPatientActivity:
                AndroidHelper.startNewActivity(view.getContext(), MainActivity.class);
                break;

            case R.id.submit_button_addPatientActivity:
                this.controller.processInput();
                AndroidHelper.startNewActivity(view.getContext(), MainActivity.class);
                break;

            case R.id.add_datePicker:
                DialogFragment dateFragment = new AddDatePickerFragment(controller);
                dateFragment.show(activity.getSupportFragmentManager(), "datePicker");

            default:
                break;
        }
    }


}