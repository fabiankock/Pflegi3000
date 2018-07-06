package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class PatientFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    //Editierbare Felder
    private EditText firstNameText, lastNameText;
    private RadioGroup rgGender;
    private EditText insuranceNrText;
    private Spinner insuranceTypeSpinner;

    //Nicht editierbare Felder
    private TextView firstNameView, lastNameView;
    private TextView genderView, insuranceNrView, insuranceTypeView;

    private View view;

    public PatientFragment() {}

    public static PatientFragment newInstance() {
        PatientFragment fragment = new PatientFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_patient, container, false);

        //editierbare Felder
        firstNameText = view.findViewById(R.id.text_firstname);
        firstNameText.setText("Hans");

        lastNameText = view.findViewById(R.id.text_lastname);
        lastNameText.setText("Peter");

        rgGender = view.findViewById(R.id.radio_gender);

        insuranceNrText = view.findViewById(R.id.text_insuranceNr);
        insuranceNrText.setText("12345678");

        insuranceTypeSpinner = view.findViewById(R.id.spinner_insuranceType);

        //nicht editierbare Felder
        firstNameView = view.findViewById(R.id.view_firstname);
        firstNameView.setText("Hans");

        lastNameView = view.findViewById(R.id.view_lastname);
        lastNameView.setText("Peter");

        genderView = view.findViewById(R.id.view_gender);
        genderView.setText("Männlich");

        insuranceNrView = view.findViewById(R.id.view_insuranceNr);
        insuranceNrView.setText("12345678");

        insuranceTypeView = view.findViewById(R.id.view_insuranceType);
        insuranceTypeView.setText("AOK");

        return view;

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
