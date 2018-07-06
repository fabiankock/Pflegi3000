package comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller;

import android.content.Intent;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.activities.main_activity.MainActivity;
import comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller.ControllerAddPatientActivity;

public class AddPatientButtonListener implements View.OnClickListener {

    private ControllerAddPatientActivity controller;

    public AddPatientButtonListener(ControllerAddPatientActivity c){

        this.controller = c;
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch(view.getId()) {

            case R.id.back_button_addPatientActivity:
                AndroidHelper.startNewActivity(view.getContext(), MainActivity.class);
                break;

            case R.id.submit_button_addPatientActivity:
                this.controller.processInput(this.controller.getFirstName(),
                                             this.controller.getLastName());
                AndroidHelper.startNewActivity(view.getContext(), MainActivity.class);
                break;

            default:
                break;
        }
    }
}