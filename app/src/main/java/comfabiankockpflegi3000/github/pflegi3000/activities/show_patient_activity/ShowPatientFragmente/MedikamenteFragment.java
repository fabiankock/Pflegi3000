package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment.ControllerMedikamentFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment.ListenerMedikamentFragment;

@SuppressLint("ValidFragment")
public class MedikamenteFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ListenerMedikamentFragment MFListener;
    private ControllerMedikamentFragment controller;
    private int patient_id;

    //Adding
    private EditText mName;
    private EditText mDosis;
    private EditText mStundenAbstand;
    private Button mCommit;

    //Liste für die Medikamente
    private ListView list;
    private FloatingActionButton fab;

    @SuppressLint("ValidFragment")
    public MedikamenteFragment(int p_id, ControllerMedikamentFragment c) {

        patient_id = p_id;
        this.controller = c;
        this.MFListener = new ListenerMedikamentFragment(controller);
    }

    public static MedikamenteFragment newInstance(int p_id, ControllerMedikamentFragment c) {

        MedikamenteFragment fragment = new MedikamenteFragment(p_id, c);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_medikamente, container, false);

        list = (ListView) view.findViewById(R.id.medikamente_list);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(MFListener);

        mName = (EditText) view.findViewById(R.id.add_mName);
        mDosis = (EditText) view.findViewById(R.id.add_mDosis);
        mStundenAbstand = (EditText) view.findViewById(R.id.add_mStundenAbstand);
        mCommit = (Button) view.findViewById(R.id.add_mCommit);
        mCommit.setOnClickListener(MFListener);

        return view;
    }

    /*----------getter----------*/

    public String getMNameValue() {
        return  mName.getText().toString();
    }

    public String getMDosisValue() {
        return  mDosis.getText().toString();
    }

    public String getMStundenAbstandValue() {
        return  mStundenAbstand.getText().toString();
    }

    public int getPatient_id() {
        return patient_id;
    }

    //keine ahnung was das is

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
}
