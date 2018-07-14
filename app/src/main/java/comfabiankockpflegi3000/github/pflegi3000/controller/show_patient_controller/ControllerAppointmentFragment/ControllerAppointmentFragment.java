package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment;

import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.AppointmentFragment;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.AppointmentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class ControllerAppointmentFragment {

    private AppointmentFragmentButtonListener btnListener;
    private CalendarListener calendarListener;
    private ShowPatientActivity activity;
    private DaoFactory daoFactory;
    private Date selectedDate;

    public ControllerAppointmentFragment(ShowPatientActivity mainActivity){

        this.btnListener = new AppointmentFragmentButtonListener(this);
        this.calendarListener = new CalendarListener(this);
        this.activity = mainActivity;
        this.daoFactory = (DaoFactory) this.activity.getApplication();
    }

    public AppointmentFragmentButtonListener getBtnListener() {
        return this.btnListener;
    }

    public List<AppointmentEntity> getAllAppointments(){

        //PatientNames tmp;
        ArrayList<AppointmentEntity> list = new ArrayList<AppointmentEntity>();

        try{
            Dao<AppointmentEntity, Integer> aDao = this.daoFactory.getAppointmentDAO();
            Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();

            List<AppointmentEntity> allAppointmentEntities = aDao.queryForAll();
            PatientEntity patient = pDao.queryForId(this.activity.getPatient_id());

            for(int i = 0; i < allAppointmentEntities.size(); i++){

                if(allAppointmentEntities.get(i).getPatient().getP_id() == patient.getP_id()){

                    list.add(allAppointmentEntities.get(i));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public void insertAppointment(){

        AppointmentFragment fragment = this.activity.getfAppointment();

        try{

            Dao<AppointmentEntity, Integer> aDao = this.daoFactory.getAppointmentDAO();
            Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();

            PatientEntity patient = pDao.queryForId(this.activity.getPatient_id());

            AppointmentEntity appointmentEntity = new AppointmentEntity(fragment.getName(), this.selectedDate.getTime(), fragment.getDescription(), fragment.getAddress(), patient);
            aDao.create(appointmentEntity);
            Log.i("appointments", "Appointment created");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void changeVisibility(){

        ConstraintLayout edit_layout = this.activity.findViewById(R.id.fragment_appointment_add);
        ConstraintLayout show_layout = this.activity.findViewById(R.id.fragment_appointment_show);

        if(edit_layout.getVisibility() == View.VISIBLE){

            edit_layout.setVisibility(View.INVISIBLE);
            show_layout.setVisibility(View.VISIBLE);
        }
        else{

            edit_layout.setVisibility(View.VISIBLE);
            show_layout.setVisibility(View.INVISIBLE);
        }
    }

    public void moveToDate(Date date){

        this.activity.moveToDateAppointment(date);
    }

    public boolean checkForAppointment(Date date){

        List<AppointmentEntity> allAppointments = this.getAllAppointments();
        for(int i = 0; i < allAppointments.size(); i++){

            if(allAppointments.get(i).getTimestamp() == date.getTime()){
                return true;
            }
        }
        return false;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setAppointmentInfoText(Date date){

        List<AppointmentEntity> allAppointments = this.getAllAppointments();
        for(int i = 0; i < allAppointments.size(); i++){

            if(allAppointments.get(i).getTimestamp() == date.getTime()){

                AppointmentEntity entity = allAppointments.get(i);
                this.activity.getfAppointment().setInfoText("Name: " + entity.getTName() + "\nDescription: " + entity.getTDescription()
                                                            + "\nAddresse: " + entity.getTAddress());
            }
        }
    }

    public void setAppointmentInfoTextEmpty(){
        this.activity.getfAppointment().setInfoText("");
    }

    public CalendarListener getCalendarListener() {
        return calendarListener;
    }
}
