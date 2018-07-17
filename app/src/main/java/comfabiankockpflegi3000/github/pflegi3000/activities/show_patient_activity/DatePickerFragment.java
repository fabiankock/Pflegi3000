package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;

import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment.ControllerPatientFragment;

@SuppressLint("ValidFragment")
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private ControllerPatientFragment controller;

    @SuppressLint("ValidFragment")
    public DatePickerFragment (ControllerPatientFragment controller) {

        this.controller = controller;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        try {
            controller.setDate(day, month, year);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}