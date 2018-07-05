package comfabiankockpflegi3000.github.pflegi3000.controller;

import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;

public class ControllerAddPatientActivity {

    private AddPatientActivity addPatientActivity;

    public ControllerAddPatientActivity(AddPatientActivity theActivity){

        this.addPatientActivity = theActivity;
    }

    public void processInput(String firstname, String lastname) {

        //Send Database query to insert new Patient
    }

    public String getFirstName(){

        return this.addPatientActivity.getFirstNameValue();
    }

    public String getLastName(){

        return this.addPatientActivity.getLastNameValue();
    }
}
