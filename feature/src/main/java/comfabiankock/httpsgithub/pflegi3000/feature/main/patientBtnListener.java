package comfabiankock.httpsgithub.pflegi3000.feature.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.app.Activity;
import comfabiankock.httpsgithub.pflegi3000.feature.patients.*;

public class patientBtnListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        Intent openPatientScreen = new Intent(v.getContext(), patientsActivity.class);
        v.getContext().startActivity(openPatientScreen);
    }
}
