package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment;

import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.AppointmentFragment;

public class AppointmentFragmentButtonListener implements View.OnClickListener {

    private ControllerAppointmentFragment controller;

    public AppointmentFragmentButtonListener(ControllerAppointmentFragment c){

        this.controller = c;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.add_appointment_button:
                if(this.controller != null)
                    this.controller.changeVisibility();
                break;

            case R.id.save_appointment_button:
                if(this.controller != null)
                    this.controller.changeVisibility();
                break;

            default:
                break;
        }
    }
}
