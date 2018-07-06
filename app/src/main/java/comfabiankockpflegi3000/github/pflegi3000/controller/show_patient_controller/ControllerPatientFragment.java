package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller;

import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.PatientFragment;

public class ControllerPatientFragment {

    private PatientFragment activity;

    public ControllerPatientFragment(PatientFragment activity) {

        this.activity = activity;
    }

    public void changeTextState() {
        if (activity.getFirstNameView().getVisibility() == View.VISIBLE) {
            ViewToEdit();
        } else {
            EditToView();
        }
    }

    public void ViewToEdit() {

        activity.getFirstNameText().setVisibility(View.VISIBLE);
        activity.getLastNameText().setVisibility(View.VISIBLE);
        activity.getRgGender().setVisibility(View.VISIBLE);
        activity.getInsuranceNrText().setVisibility(View.VISIBLE);
        activity.getInsuranceTypeSpinner().setVisibility(View.VISIBLE);

        activity.getFirstNameView().setVisibility(View.INVISIBLE);
        activity.getLastNameView().setVisibility(View.INVISIBLE);
        activity.getGenderView().setVisibility(View.INVISIBLE);
        activity.getInsuranceNrView().setVisibility(View.INVISIBLE);
        activity.getInsuranceTypeView().setVisibility(View.INVISIBLE);
    }

    public void EditToView() {

        activity.getFirstNameText().setVisibility(View.INVISIBLE);
        activity.getLastNameText().setVisibility(View.INVISIBLE);
        activity.getRgGender().setVisibility(View.INVISIBLE);
        activity.getInsuranceNrText().setVisibility(View.INVISIBLE);
        activity.getInsuranceTypeSpinner().setVisibility(View.INVISIBLE);

        activity.getFirstNameView().setVisibility(View.VISIBLE);
        activity.getLastNameView().setVisibility(View.VISIBLE);
        activity.getGenderView().setVisibility(View.VISIBLE);
        activity.getInsuranceNrView().setVisibility(View.VISIBLE);
        activity.getInsuranceTypeView().setVisibility(View.VISIBLE);
    }
}
