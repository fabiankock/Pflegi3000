package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class CareFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private TextView defecationView, mealView, washingView;
    private View view;

    public CareFragment() {}

    public static CareFragment newInstance() {
        CareFragment fragment = new CareFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_care, container, false);

        this.defecationView = (TextView) view.findViewById(R.id.last_defecation);
        this.defecationView.setText("Letzte Darmentleerung: ");

        this.mealView = (TextView) view.findViewById(R.id.last_meal);
        this.mealView.setText("Letzte Mahlzeit: ");

        this.washingView = (TextView) view.findViewById(R.id.last_washing);
        this.washingView.setText("Letzte Waschung: ");

        return this.view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
