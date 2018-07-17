package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment;

import android.annotation.SuppressLint;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.PatientFragment;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.CareEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class ControllerPatientFragment {

    private PatientFragment activity;
    private ShowPatientActivity mainactivity;
    private DaoFactory daoFactory;
    private PatientFragmentButtonListener btnListener;

    private int day, month, year;


    public ControllerPatientFragment(PatientFragment activity, ShowPatientActivity mainActivity, int id) {

        this.mainactivity = mainActivity;
        this.activity = activity;
        this.daoFactory = (DaoFactory) mainActivity.getApplication();
        this.btnListener = new PatientFragmentButtonListener(this, id, mainActivity);
    }

    public void updatePatient(int id) throws SQLException {


        Dao<InsuranceEntity, Integer> iDao = daoFactory.getInsuranceDAO();
        //Get the insurance Data
        InsuranceEntity insuranceEntity = iDao.queryForAll().get(this.mainactivity.getfPatient().getInsuranceListPos());

        Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();
        PatientEntity entity = pDao.queryForId(id);

        entity.setFirstname(this.mainactivity.getfPatient().getFirstNameText().getText().toString());
        entity.setLastname(this.mainactivity.getfPatient().getLastNameText().getText().toString());
        if(this.mainactivity.getfPatient().getFemaleBtn().isChecked()){
            entity.setGender('w');
        }
        else{
            entity.setGender('m');
        }
        int num = Integer.parseInt(this.mainactivity.getfPatient().getInsuranceNrText().getText().toString());
        entity.setInsuranceNumber(num);
        entity.setInsuranceEntity(insuranceEntity);

        pDao.update(entity);
        this.realodViews(entity);
    }

    public PatientEntity getPatientByID(int id) throws SQLException {

        Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();
        PatientEntity entity = pDao.queryForId(id);

        return entity;
    }

    public InsuranceEntity getInsuranceOfPatient(int id) throws SQLException {

        Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();
        PatientEntity patientEntity = pDao.queryForId(id);

        Dao<InsuranceEntity, Integer> iDao = this.daoFactory.getInsuranceDAO();
        List<InsuranceEntity> insuranceEntities = iDao.queryForAll();

        for(int i = 0; i < insuranceEntities.size(); i++){

            if(insuranceEntities.get(i).getId() == patientEntity.getInsuranceEntity().getId()){

                return insuranceEntities.get(i);
            }
        }

        return null;
    }

    public void deletePatientById(int id) throws SQLException {

        Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();
        Dao<CareEntity, Integer> cDao = this.daoFactory.getCareDAO();
        PatientEntity entity = pDao.queryForId(id);
        CareEntity careEntity = cDao.queryForId(id);

        pDao.delete(entity);
        cDao.delete(careEntity);
    }

    public List<InsuranceEntity> getAllInsurances(){

        List<InsuranceEntity> insurances = null;

        try{
            Dao<InsuranceEntity, Integer> iDao = this.daoFactory.getInsuranceDAO();
            insurances = iDao.queryForAll();

            Log.d("insuranceDB", "size: "+insurances.size());
        }catch(SQLException e){
            e.printStackTrace();
        }

        return insurances;
    }

    @SuppressLint("RestrictedApi")
    public void switchView()throws SQLException{

        if(mainactivity.getfPatient().getEditLayout().getVisibility() == View.VISIBLE){

            mainactivity.getfPatient().getEditLayout().setVisibility(View.INVISIBLE);
            mainactivity.getfPatient().getShowLayout().setVisibility(View.VISIBLE);
            this.updatePatient(mainactivity.getPatient_id());
        }

        else{

            mainactivity.getfPatient().getEditLayout().setVisibility(View.VISIBLE);
            mainactivity.getfPatient().getShowLayout().setVisibility(View.INVISIBLE);
        }
    }

    public void realodViews(PatientEntity theEntity){

        this.activity = mainactivity.getfPatient();
        //nicht editierbare felder
        this.activity.getFirstNameView().setText(theEntity.getFirstname());
        this.activity.getLastNameView().setText(theEntity.getLastname());
        this.activity.getBirthday().setText(theEntity.getDay() + "." + theEntity.getMonth()+ "." + theEntity.getYear());
        if(theEntity.getGender() == 'w'){
            this.activity.getGenderView().setText("weiblich");
        }
        else {
            this.activity.getGenderView().setText("männlich");
        }

        this.activity.getInsuranceNrView().setText(Integer.toString(theEntity.getInsuranceNumber()));
        this.activity.getInsuranceTypeView().setText(theEntity.getInsuranceEntity().getName() + " ("+theEntity.getInsuranceEntity().getType()+")");

        //editierbare Felder
        this.activity.getFirstNameText().setText(theEntity.getFirstname());
        this.activity.getLastNameText().setText(theEntity.getLastname());
        this.activity.getDatePicker().setText(theEntity.getDay() + "." + theEntity.getMonth()+ "." + theEntity.getYear());
        if(theEntity.getGender() == 'w'){
            this.activity.getFemaleBtn().setChecked(true);
            this.activity.getMaleBtn().setChecked(false);
        }
        else{
            this.activity.getFemaleBtn().setChecked(false);
            this.activity.getMaleBtn().setChecked(true);
        }
        this.activity.getInsuranceNrText().setText(Integer.toString(theEntity.getInsuranceNumber()));

        List<InsuranceEntity> items = this.getAllInsurances();
        if(items != null){

            String[] itemList = new String[items.size()];
            for(int i = 0; i < items.size(); i++){
                itemList[i] = items.get(i).getName();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.activity.getContext(), android.R.layout.simple_spinner_dropdown_item, itemList);
            this.activity.getInsuranceTypeSpinner().setAdapter(adapter);
            for(int i = 0; i < items.size(); i++){

                if(theEntity.getInsuranceEntity().getId() == items.get(i).getId()){

                    this.activity.getInsuranceTypeSpinner().setSelection(i);
                }
            }
        }
    }

    public void setDate(int day, int month, int year) throws SQLException {
        this.day = day;
        this.month = month+1;
        this.year = year;

        mainactivity.getfPatient().setDate(this.day, this.month, this.year);

        Dao<PatientEntity, Integer> pDao = daoFactory.getPatientDAO();
        PatientEntity temp = pDao.queryForId(mainactivity.getPatient_id());
        temp.setBirthdate(this.day, this.month, this.year);
        pDao.update(temp);

    }

    public PatientFragmentButtonListener getBtnListener() {
        return btnListener;
    }
}
