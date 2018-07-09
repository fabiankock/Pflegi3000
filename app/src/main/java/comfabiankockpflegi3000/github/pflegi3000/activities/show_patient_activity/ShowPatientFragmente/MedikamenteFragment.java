package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerMedikamentFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment;

@SuppressLint("ValidFragment")
public class MedikamenteFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ControllerMedikamentFragment controller;
    private int patient_id;

    //Liste für die Medikamente
    private ListView list;

    @SuppressLint("ValidFragment")
    public MedikamenteFragment(int p_id, ControllerMedikamentFragment c) {

        patient_id = p_id;
        this.controller = c;
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
}
