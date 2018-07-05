package comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity;

import android.content.Intent;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.main_activity.MainActivity;

public class AddPatientButtonListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        Intent intent;

        switch(view.getId()) {

            case R.id.back_button_addPatientActivity:
                intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
                break;

            default:
                break;
        }
    }
}