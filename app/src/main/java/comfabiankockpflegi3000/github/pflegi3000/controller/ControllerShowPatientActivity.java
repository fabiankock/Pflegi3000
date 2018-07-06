package comfabiankockpflegi3000.github.pflegi3000.controller;

import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;

public class ControllerShowPatientActivity {

    private ShowPatientActivity showPatientActivity;

    public ControllerShowPatientActivity(ShowPatientActivity theActivity) {

        this.showPatientActivity = theActivity;
    }

    public void ViewToEdit() {
        //TextView unsichtbar machen
        showPatientActivity.getFirstNameView().setVisibility(View.INVISIBLE);
        showPatientActivity.getLastNameView().setVisibility(View.INVISIBLE);
        //EditText sichtbar machen
        showPatientActivity.getFirstNameText().setVisibility(View.VISIBLE);
        showPatientActivity.getLastNameText().setVisibility(View.VISIBLE);
    }

    public void EditToView() {
        //TextView sichtbar machen
        showPatientActivity.getFirstNameView().setVisibility(View.VISIBLE);
        showPatientActivity.getLastNameView().setVisibility(View.VISIBLE);
        //EditText unsichtbar machen
        showPatientActivity.getFirstNameText().setVisibility(View.INVISIBLE);
        showPatientActivity.getLastNameText().setVisibility(View.INVISIBLE);

    }
}
