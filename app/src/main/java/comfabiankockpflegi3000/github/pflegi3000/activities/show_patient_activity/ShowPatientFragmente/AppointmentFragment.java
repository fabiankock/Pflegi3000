package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.Date;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment.ControllerAppointmentFragment;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.AppointmentEntity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AppointmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AppointmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressLint("ValidFragment")
public class AppointmentFragment extends Fragment {

    private int patient_id;
    private String mParam2;

    private FloatingActionButton add_button;
    private Button save_button;
    private CalendarView calendarView;
    private EditText name,description,address;
    private ConstraintLayout edit_layout, show_layout;

    private View view;
    private ControllerAppointmentFragment controller;

    private OnFragmentInteractionListener mListener;

    @SuppressLint("ValidFragment")
    public AppointmentFragment(int p_id, ControllerAppointmentFragment c) {
        // Required empty public constructor
        this.patient_id = p_id;
        this.controller = c;
    }

    public static AppointmentFragment newInstance(int p_id, ControllerAppointmentFragment c) {

        AppointmentFragment fragment = new AppointmentFragment(p_id, c);
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
        view = inflater.inflate(R.layout.fragment_appointment, container, false);

        this.add_button = (FloatingActionButton) view.findViewById(R.id.add_appointment_button);
        this.save_button = (Button) view.findViewById(R.id.save_appointment_button);

        this.add_button.setOnClickListener(this.controller.getBtnListener());
        this.save_button.setOnClickListener(this.controller.getBtnListener());

        this.calendarView = (CalendarView) view.findViewById(R.id.calendar_view);
        this.calendarView.setOnDateChangeListener(this.controller.getCalendarListener());

        this.edit_layout = (ConstraintLayout) view.findViewById(R.id.fragment_appointment_add);
        this.show_layout = (ConstraintLayout) view.findViewById(R.id.fragment_appointment_show);

        this.name = view.findViewById(R.id.edittext_appointment_name);
        this.description = view.findViewById(R.id.edittext_appointment_description);
        this.address = view.findViewById(R.id.edittext_appointment_address);

        this.edit_layout.setVisibility(View.INVISIBLE);
        this.show_layout.setVisibility(View.VISIBLE);

        List<AppointmentEntity> aEntities = this.controller.getAllAppointments();

        for(int i = 0; i < aEntities.size(); i++){

            Log.i("appointments", aEntities.get(i).getTName() + " "
                                        + aEntities.get(i).getTimestamp() + " "
                                        + aEntities.get(i).getTDescription() + " "
                                        + aEntities.get(i).getTAddress());
        }

        return view;
    }

    public String getName(){
        return this.name.getText().toString();
    }
    public String getDescription(){
        return this.description.getText().toString();
    }
    public String getAddress(){
        return this.address.getText().toString();
    }

    public long getDate(){
        return this.calendarView.getDate();
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
