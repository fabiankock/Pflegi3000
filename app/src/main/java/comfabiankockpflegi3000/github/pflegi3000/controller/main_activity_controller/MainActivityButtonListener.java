package comfabiankockpflegi3000.github.pflegi3000.controller.main_activity_controller;

import android.content.Intent;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity.SearchPatientActivity;

public class MainActivityButtonListener implements View.OnClickListener {

    public MainActivityButtonListener(){
        super();
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch(view.getId()) {

            case R.id.addpatient_button:
                AndroidHelper.startNewActivity(view.getContext(), AddPatientActivity.class);
                break;

            case R.id.patient_button:
                AndroidHelper.startNewActivity(view.getContext(), SearchPatientActivity.class);
                break;

            default:
                break;
        }
    }
}
