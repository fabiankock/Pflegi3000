package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity.SearchPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.controller.ControllerShowPatientActivity;

public class ShowPatientButtonListener implements View.OnClickListener{

    private ControllerShowPatientActivity controller;

    public ShowPatientButtonListener(ControllerShowPatientActivity controller){

        this.controller = controller;
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

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_enable_editable:

                controller.setEditable();
                return true;
        }

        return false;
    }
}
