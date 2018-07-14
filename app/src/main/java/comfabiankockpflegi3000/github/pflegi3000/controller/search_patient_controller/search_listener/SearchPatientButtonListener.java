package comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.search_listener;

import android.content.Intent;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.activities.main_activity.MainActivity;

public class SearchPatientButtonListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        Intent intent;

        switch(view.getId()){

            case R.id.back_button_search_patient:
                AndroidHelper.startNewActivity(view.getContext(), MainActivity.class);
                break;

            default:
                break;
        }
    }
}
