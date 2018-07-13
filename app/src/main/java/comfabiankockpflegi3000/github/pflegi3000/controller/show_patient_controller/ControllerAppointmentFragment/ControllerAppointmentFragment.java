package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment;

import android.support.constraint.ConstraintLayout;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.AppointmentFragment;

public class ControllerAppointmentFragment {

    private AppointmentFragmentButtonListener btnListener;
    private ShowPatientActivity activity;

    public ControllerAppointmentFragment(ShowPatientActivity mainActivity){

        this.btnListener = new AppointmentFragmentButtonListener(this);
        this.activity = mainActivity;
    }

    public AppointmentFragmentButtonListener getBtnListener() {
        return this.btnListener;
    }

    public void changeVisibility(){

        ConstraintLayout edit_layout = this.activity.findViewById(R.id.fragment_appointment_add);
        ConstraintLayout show_layout = this.activity.findViewById(R.id.fragment_appointment_show);

        if(edit_layout.getVisibility() == View.VISIBLE){

            edit_layout.setVisibility(View.INVISIBLE);
            show_layout.setVisibility(View.VISIBLE);
        }
        else{

            edit_layout.setVisibility(View.VISIBLE);
            show_layout.setVisibility(View.INVISIBLE);
        }
    }
}
