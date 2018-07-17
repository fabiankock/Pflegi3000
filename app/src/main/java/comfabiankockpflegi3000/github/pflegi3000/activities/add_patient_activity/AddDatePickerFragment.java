package comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.ResourceBundle;

import comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller.ControllerAddPatientActivity;

@SuppressLint("ValidFragment")
public class AddDatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private ControllerAddPatientActivity controller;

    @SuppressLint("ValidFragment")
    public AddDatePickerFragment (ControllerAddPatientActivity controller) {

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

        controller.setDate(day, month, year);
    }
}