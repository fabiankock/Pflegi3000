package comfabiankockpflegi3000.github.pflegi3000.activities.main_activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity.SearchPatientActivity;

public class MainActivityButtonListener implements View.OnClickListener {

    public MainActivityButtonListener(){
        super();
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch(view.getId()) {

            case R.id.addpatient_button:
                intent = new Intent(view.getContext(), AddPatientActivity.class);
                view.getContext().startActivity(intent);
                break;

            case R.id.patient_button:
                intent = new Intent(view.getContext(), SearchPatientActivity.class);
                view.getContext().startActivity(intent);
                break;

            default:
                break;
        }
    }
}
