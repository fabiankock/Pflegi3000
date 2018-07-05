package comfabiankockpflegi3000.github.pflegi3000.controller;

import android.text.InputType;

import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;

public class ControllerShowPatientActivity {

    private ShowPatientActivity showPatientActivity;

    public ControllerShowPatientActivity(ShowPatientActivity theActivity) {

        this.showPatientActivity = theActivity;
    }

    public void setEditable() {


        if (showPatientActivity.getFirstNameText().getInputType() == InputType.TYPE_NULL) {
            showPatientActivity.getLastNameText().setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            showPatientActivity.getLastNameText().setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }
}
