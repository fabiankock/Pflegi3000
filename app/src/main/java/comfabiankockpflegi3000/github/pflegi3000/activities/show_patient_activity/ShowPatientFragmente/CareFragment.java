package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerCareFragment.ControllerCareFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment.ControllerPatientFragment;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.CareEntity;

public class CareFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private TextView defecationView, mealView, washingView;
    private Button now_defecBtn, now_mealBtn, now_washingBtn;
    private int patient_id;
    private ControllerCareFragment controller;
    private View view;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM HH:mm:ss");

    @SuppressLint("ValidFragment")
    public CareFragment(int p_id, ControllerCareFragment c) {
        this.patient_id = p_id;
        this.controller = c;
    }

    public CareFragment() {}

    public static CareFragment newInstance(int p_id, ControllerCareFragment c) {
        CareFragment fragment = new CareFragment(p_id, c);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CareEntity entity = null;
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_care, container, false);

        this.now_defecBtn = (Button) view.findViewById(R.id.now_button_defecation);
        this.now_defecBtn.setOnClickListener(this.controller.getBtnListener());

        this.now_mealBtn = (Button) view.findViewById(R.id.now_button_meal);
        this.now_mealBtn.setOnClickListener(this.controller.getBtnListener());

        this.now_washingBtn = (Button) view.findViewById(R.id.now_button_washed);
        this.now_washingBtn.setOnClickListener(this.controller.getBtnListener());

        try {
            entity = this.controller.getCareDataForPatient();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(entity != null) {

            Date tmp;
            this.defecationView = (TextView) view.findViewById(R.id.last_defecation);
            tmp = new Date(entity.getL_defecation());
            this.defecationView.setText(sdf.format(tmp));

            this.mealView = (TextView) view.findViewById(R.id.last_meal);
            tmp = new Date(entity.getL_meal());
            this.mealView.setText(sdf.format(tmp));

            this.washingView = (TextView) view.findViewById(R.id.last_washed);
            tmp = new Date(entity.getL_washed());
            this.washingView.setText(sdf.format(tmp));
        }

        return this.view;
    }

    public TextView getDefecationView() {
        return defecationView;
    }

    public TextView getMealView() {
        return mealView;
    }

    public TextView getWashingView() {
        return washingView;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
