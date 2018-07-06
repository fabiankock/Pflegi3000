package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class PatientFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText firstNameText, lastNameText;
    private TextView firstNameView, lastNameView;
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

        firstNameText = view.findViewById(R.id.text_firstname);
        firstNameText.setText("Hans");
        lastNameText = view.findViewById(R.id.text_lastname);
        lastNameText.setText("Peter");

        firstNameView = view.findViewById(R.id.view_firstname);
        firstNameView.setText("Hans");
        lastNameView = view.findViewById(R.id.view_lastname);
        lastNameView.setText("Peter");

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

    public EditText getLastNameText() {
        return lastNameText;
    }
    public EditText getFirstNameText() {
        return firstNameText;
    }
    public TextView getLastNameView() {
        return lastNameView;
    }
    public TextView getFirstNameView() {
        return firstNameView;
    }
}
