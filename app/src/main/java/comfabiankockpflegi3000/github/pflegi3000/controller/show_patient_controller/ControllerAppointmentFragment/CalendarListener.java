package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment;

import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.sql.SQLException;
import java.util.Date;

public class CalendarListener extends CaldroidListener {

    ControllerAppointmentFragment controller;

    public CalendarListener(ControllerAppointmentFragment c){

        this.controller = c;
    }

    @Override
    public void onSelectDate(Date date, View view) {

        Log.i("appointments", "sel date: " + date.getTime());
        this.controller.moveToDate(date);
        if(this.controller.checkForAppointment(date) == true){

            Log.i("appointments", "there is appointment");
            this.controller.setAppointmentInfoText(date);
        }
        else{
            this.controller.setAppointmentInfoTextEmpty();
        }
    }

    @Override
    public void onLongClickDate(Date date, View view) {

        if(this.controller.checkForAppointment(date) == true){

            try {
                this.controller.deleteAppointment(date);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.controller.repaintCalendar();
        }
    }
}
