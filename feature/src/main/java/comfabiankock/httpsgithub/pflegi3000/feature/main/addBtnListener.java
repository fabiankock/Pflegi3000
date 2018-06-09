package comfabiankock.httpsgithub.pflegi3000.feature.main;

import android.content.Intent;
import android.view.View;

import comfabiankock.httpsgithub.pflegi3000.feature.patients.addPatient.addPatientActivity;

public class addBtnListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

        Intent openAddPatientScreen = new Intent(v.getContext(), addPatientActivity.class);
        v.getContext().startActivity(openAddPatientScreen);
    }
}
