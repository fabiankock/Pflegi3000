package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

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
                Log.i("appointments", "sel date: " + this.controller.getSelectedDate());
                if(this.controller.getSelectedDate() != null) {
                    if (this.controller != null)
                        this.controller.changeVisibility();
                }
                else{
                    Toast t = Toast.makeText(view.getContext(), "Bitte ein Datum auswählen", Toast.LENGTH_SHORT);
                    t.show();
                }
                break;

            case R.id.save_appointment_button:

                if(!this.controller.processInput()){
                    Toast t = Toast.makeText(view.getContext(), "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT);
                    t.show();
                }
                else{
                    if(this.controller != null)
                        this.controller.changeVisibility();
                    this.controller.repaintCalendar();
                }
                break;

            default:
                break;
        }
    }
}
