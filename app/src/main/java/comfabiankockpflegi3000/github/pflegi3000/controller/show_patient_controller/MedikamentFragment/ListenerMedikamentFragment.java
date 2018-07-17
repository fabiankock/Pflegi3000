package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.DatePickerFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.MedikamenteFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.TimePickerFragment;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;

public class ListenerMedikamentFragment implements View.OnClickListener{

    private ControllerMedikamentFragment controller;
    private MedikamenteFragment activity;
    private int medi;

    public ListenerMedikamentFragment (ControllerMedikamentFragment controller, MedikamenteFragment activity) {

        this.controller = controller;
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fab:

                controller.switchAddShow();
                break;

            case R.id.add_mCommit:

                controller.processInput();
                controller.refreshList();
                controller.switchAddShow();
                break;

            case R.id.add_time:

                DialogFragment timeFragment = new TimePickerFragment(controller);
                timeFragment.show(activity.getFragmentManager(), "Uhrzeit");
                break;


        }
    }
}
