package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.R;
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
    private EditText insuranceNrText;
    private Spinner insuranceTypeSpinner;
    private ConstraintLayout showLayout, editLayout;

    //Nicht editierbare Felder
    private TextView firstNameView, lastNameView;
    private TextView genderView, insuranceNrView, insuranceTypeView;

    private View view;

    public PatientFragment() {}

    @SuppressLint("ValidFragment")
    public PatientFragment(int p_id, ControllerPatientFragment c) {
        this.patient_id = p_id;
        this.controller = c;
    }

    public static PatientFragment newInstance(int p_id, ControllerPatientFragment c) {

        PatientFragment fragment = new PatientFragment(p_id, c);

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
            }

            //nicht editierbare Felder
            firstNameView = view.findViewById(R.id.view_firstname);
            firstNameView.setText("Vorname: " + this.the_patient.getFirstname());

            lastNameView = view.findViewById(R.id.view_lastname);
            lastNameView.setText("Nachname: " + this.the_patient.getLastname());

            genderView = view.findViewById(R.id.view_gender);
            if(this.the_patient.getGender() == 'm')
                genderView.setText("Geschlecht: männlich");
            else
                genderView.setText("Geschlecht: weiblich");

            insuranceNrView = view.findViewById(R.id.view_insuranceNr);
            insuranceNrView.setText("Versicherungsnummer: " + Integer.toString(this.the_patient.getInsuranceNumber()));

            insuranceTypeView = view.findViewById(R.id.view_insuranceType);
            try {
                insuranceTypeView.setText("Versicherung: " + this.controller.getInsuranceOfPatient(this.patient_id).getName()
                                            + "(" + this.controller.getInsuranceOfPatient(this.patient_id).getType() + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            this.showLayout = view.findViewById(R.id.show_layout_patient);
            this.editLayout = view.findViewById(R.id.edit_layout_patient);

            this.showLayout.setVisibility(View.VISIBLE);
            this.editLayout.setVisibility(View.INVISIBLE);
        }
        return view;

    }

    public ConstraintLayout getEditLayout() {
        return editLayout;
    }

    public ConstraintLayout getShowLayout() {
        return showLayout;
    }

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

    /*----------getter----------*/

    //nicht editierbare Felder
    public EditText getLastNameText() {
        return lastNameText;
    }
    public EditText getFirstNameText() {
        return firstNameText;
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

    //editierbare Felder
    public TextView getLastNameView() {
        return lastNameView;
    }
    public TextView getFirstNameView() {
        return firstNameView;
    }
    public TextView getGenderView() {
        return genderView;
    }
    public TextView getInsuranceNrView() {
        return insuranceNrView;
    }
    public TextView getInsuranceTypeView() {
        return insuranceTypeView;
    }
}
