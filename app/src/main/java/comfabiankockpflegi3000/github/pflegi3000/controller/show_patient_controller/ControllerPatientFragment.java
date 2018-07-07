package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller;

import android.view.View;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.PatientFragment;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class ControllerPatientFragment {

    private PatientFragment activity;
    private DaoFactory daoFactory;

    public ControllerPatientFragment(PatientFragment activity, ShowPatientActivity mainActivity) {

        this.activity = activity;
        this.daoFactory = (DaoFactory) mainActivity.getApplication();
    }

    public PatientEntity getPatientByID(int id) throws SQLException {

        Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();
        PatientEntity entity = pDao.queryForId(id);

        return entity;
    }

    public void changeTextState() {
        if (activity.getFirstNameView().getVisibility() == View.VISIBLE) {
            ViewToEdit();
        } else {
            EditToView();
        }
    }

    public void ViewToEdit() {

        activity.getFirstNameText().setVisibility(View.VISIBLE);
        activity.getLastNameText().setVisibility(View.VISIBLE);
        activity.getRgGender().setVisibility(View.VISIBLE);
        activity.getInsuranceNrText().setVisibility(View.VISIBLE);
        activity.getInsuranceTypeSpinner().setVisibility(View.VISIBLE);

        activity.getFirstNameView().setVisibility(View.INVISIBLE);
        activity.getLastNameView().setVisibility(View.INVISIBLE);
        activity.getGenderView().setVisibility(View.INVISIBLE);
        activity.getInsuranceNrView().setVisibility(View.INVISIBLE);
        activity.getInsuranceTypeView().setVisibility(View.INVISIBLE);
    }

    public void EditToView() {

        activity.getFirstNameText().setVisibility(View.INVISIBLE);
        activity.getLastNameText().setVisibility(View.INVISIBLE);
        activity.getRgGender().setVisibility(View.INVISIBLE);
        activity.getInsuranceNrText().setVisibility(View.INVISIBLE);
        activity.getInsuranceTypeSpinner().setVisibility(View.INVISIBLE);

        activity.getFirstNameView().setVisibility(View.VISIBLE);
        activity.getLastNameView().setVisibility(View.VISIBLE);
        activity.getGenderView().setVisibility(View.VISIBLE);
        activity.getInsuranceNrView().setVisibility(View.VISIBLE);
        activity.getInsuranceTypeView().setVisibility(View.VISIBLE);
    }
}
