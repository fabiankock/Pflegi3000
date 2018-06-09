package comfabiankock.httpsgithub.pflegi3000.feature.patients.addPatient;

import android.content.Intent;
import android.view.View;

import comfabiankock.httpsgithub.pflegi3000.feature.main.MainActivity;
import comfabiankock.httpsgithub.pflegi3000.feature.database.database;

public class submitBtnListener implements View.OnClickListener {

    private addPatientActivity addPatientAc;
    private String firstName, lastName;
    private int insuranceNr;

    public submitBtnListener(addPatientActivity theActivity){

        this.addPatientAc = theActivity;
    }

    @Override
    public void onClick(View v) {

        //TODO Safe new patient in database and show success/failure message
        this.firstName = this.addPatientAc.getFirstName();
        this.lastName = this.addPatientAc.getLastName();
        this.insuranceNr = Integer.parseInt(this.addPatientAc.getInsuranceNr());
        database db = new database(v.getContext());
        if(db.insertPatient(this.firstName, this.lastName, this.insuranceNr) == false){
            //failed
        }
        Intent openMainScreen = new Intent(v.getContext(), MainActivity.class);
        v.getContext().startActivity(openMainScreen);
    }
}
