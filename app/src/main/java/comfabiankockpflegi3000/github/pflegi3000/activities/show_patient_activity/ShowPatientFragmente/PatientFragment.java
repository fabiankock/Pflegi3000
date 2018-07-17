package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment.ControllerPatientFragment;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class PatientFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private int patient_id;
    private PatientEntity the_patient;

    private ControllerPatientFragment controller;

    //Editierbare Felder
    private EditText firstNameText, lastNameText;
    private RadioGroup rgGender;
    private RadioButton maleBtn, femaleBtn;
    private EditText insuranceNrText;
    private Spinner insuranceTypeSpinner;
    private ConstraintLayout showLayout, editLayout;
    private Button deleteButton;
    private TextView datePicker;

    //Nicht editierbare Felder
    private TextView firstNameView, lastNameView;
    private TextView genderView, insuranceNrView, insuranceTypeView;
    private TextView birthday;
    private FloatingActionButton fButton;

    private View view;

    private ShowPatientActivity mainactivity;

    public PatientFragment() {}

    @SuppressLint("ValidFragment")
    public PatientFragment(int p_id, ControllerPatientFragment c, ShowPatientActivity mainactivity) {
        this.patient_id = p_id;
        this.controller = c;
        this.mainactivity = mainactivity;
    }

    public static PatientFragment newInstance(int p_id, ControllerPatientFragment c, ShowPatientActivity mainactivity) {

        PatientFragment fragment = new PatientFragment(p_id, c, mainactivity);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_patient, container, false);
        try {
            this.the_patient = this.controller.getPatientByID(this.patient_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(this.the_patient != null) {
            //editierbare Felder
            firstNameText = view.findViewById(R.id.text_firstname);
            firstNameText.setText(this.the_patient.getFirstname());

            lastNameText = view.findViewById(R.id.text_lastname);
            lastNameText.setText(this.the_patient.getLastname());

            rgGender = view.findViewById(R.id.radio_gender);
            maleBtn = view.findViewById(R.id.radio_male);
            femaleBtn = view.findViewById(R.id.radio_female);
            if(this.the_patient.getGender() == 'm'){
                maleBtn.setChecked(true);
            }
            else {
                femaleBtn.setChecked(true);
            }

            insuranceNrText = view.findViewById(R.id.text_insuranceNr);
            insuranceNrText.setText(Integer.toString(this.the_patient.getInsuranceNumber()));

            insuranceTypeSpinner = view.findViewById(R.id.spinner_insuranceType);
            List<InsuranceEntity> items = this.controller.getAllInsurances();
            if(items != null){

                String[] itemList = new String[items.size()];
                for(int i = 0; i < items.size(); i++){
                    itemList[i] = items.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, itemList);
                this.insuranceTypeSpinner.setAdapter(adapter);

                for(int i = 0; i < items.size(); i++){

                    if(this.the_patient.getInsuranceEntity().getId() == items.get(i).getId()){

                        this.insuranceTypeSpinner.setSelection(i);
                    }
                }
            }

            this.datePicker = (TextView) view.findViewById(R.id.date_picker);
            this.datePicker.setText(this.the_patient.getDay() + "." + this.the_patient.getMonth() + "." + this.the_patient.getYear());
            this.datePicker.setOnClickListener(this.controller.getBtnListener());

            this.deleteButton = (Button) view.findViewById(R.id.delete_button);
            this.deleteButton.setOnClickListener(this.controller.getBtnListener());

            //nicht editierbare Felder
            firstNameView = view.findViewById(R.id.view_firstname);
            firstNameView.setText(this.the_patient.getFirstname());

            lastNameView = view.findViewById(R.id.view_lastname);
            lastNameView.setText(this.the_patient.getLastname());

            this.birthday = view.findViewById(R.id.view_birthday);
            birthday.setText(this.the_patient.getDay() + "." + this.the_patient.getMonth() + "." + this.the_patient.getYear());

            genderView = view.findViewById(R.id.view_gender);
            if(this.the_patient.getGender() == 'm')
                genderView.setText("männlich");
            else
                genderView.setText("weiblich");

            insuranceNrView = view.findViewById(R.id.view_insuranceNr);
            insuranceNrView.setText(Integer.toString(this.the_patient.getInsuranceNumber()));

            insuranceTypeView = view.findViewById(R.id.view_insuranceType);
            try {
                insuranceTypeView.setText(this.controller.getInsuranceOfPatient(this.patient_id).getName()
                                            + "(" + this.controller.getInsuranceOfPatient(this.patient_id).getType() + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            this.fButton = view.findViewById(R.id.fabPatient);
            this.fButton.setOnClickListener(this.controller.getBtnListener());

            this.showLayout = view.findViewById(R.id.show_layout_patient);
            this.editLayout = view.findViewById(R.id.edit_layout_patient);

            this.showLayout.setVisibility(View.VISIBLE);
            this.editLayout.setVisibility(View.INVISIBLE);
        }
        return view;

    }

    public boolean isEditActive(){

        if(this.editLayout.getVisibility() == View.VISIBLE){
            return true;
        }
        else{
            return false;
        }
    }

    public ConstraintLayout getEditLayout() {
        return editLayout;
    }

    public ConstraintLayout getShowLayout() {
        return showLayout;
    }

    public RadioButton getFemaleBtn() {
        return femaleBtn;
    }

    public RadioButton getMaleBtn() {
        return maleBtn;
    }

    public int getInsuranceListPos() { return this.insuranceTypeSpinner.getSelectedItemPosition();}

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public void setDate(int day, int month, int year) {
        datePicker.setText(day + "." + month + "." + year);
    }

    public ShowPatientActivity getMainactivity() {
        return mainactivity;
    }

    /*----------getter----------*/

    //editierbare Felder
    public EditText getLastNameText() {
        return lastNameText;
    }
    public EditText getFirstNameText() {
        return firstNameText;
    }
    public TextView getDatePicker() {
        return datePicker;
    }
    public RadioGroup getRgGender() {
        return rgGender;
    }
    public EditText getInsuranceNrText() {
        return insuranceNrText;
    }
    public Spinner getInsuranceTypeSpinner() {
        return insuranceTypeSpinner;
    }

    //nicht editierbare Felder
    public TextView getLastNameView() {
        return lastNameView;
    }
    public TextView getFirstNameView() {
        return firstNameView;
    }
    public TextView getBirthday() {return birthday;}
    public TextView getGenderView() {
        return genderView;
    }
    public TextView getInsuranceNrView() {
        return insuranceNrView;
    }
    public TextView getInsuranceTypeView() {
        return insuranceTypeView;
    }

    public FloatingActionButton getfButton() {
        return fButton;
    }
}
