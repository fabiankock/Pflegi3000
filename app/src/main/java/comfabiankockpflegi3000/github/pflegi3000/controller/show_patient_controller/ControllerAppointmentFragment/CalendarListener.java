package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment;

import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.widget.CalendarView;

import java.util.Date;

public class CalendarListener implements CalendarView.OnDateChangeListener {

    ControllerAppointmentFragment controller;

    public CalendarListener(ControllerAppointmentFragment c){

        this.controller = c;
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {

        //add code here
        Date theDate = new Date(calendarView.getDate());

        this.controller.setSelectedDate(theDate);
    }
}
