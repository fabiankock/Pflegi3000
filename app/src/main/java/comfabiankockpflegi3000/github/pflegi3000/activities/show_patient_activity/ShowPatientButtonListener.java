package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity;

import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity.SearchPatientActivity;

public class ShowPatientButtonListener implements View.OnClickListener{

    public ShowPatientButtonListener(){

    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.back_button_show_patientActivity:
                AndroidHelper.startNewActivity(view.getContext(), SearchPatientActivity.class);
                break;

            default:
                break;
        }
    }
}
