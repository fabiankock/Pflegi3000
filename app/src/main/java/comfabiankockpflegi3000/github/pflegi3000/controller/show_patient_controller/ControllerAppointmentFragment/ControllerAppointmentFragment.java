package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment;

import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import com.j256.ormlite.dao.Dao;
import com.roomorama.caldroid.CaldroidFragment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    public boolean insertAppointment(){

        AppointmentFragment fragment = this.activity.getfAppointment();

        try{

            Dao<AppointmentEntity, Integer> aDao = this.daoFactory.getAppointmentDAO();
            Dao<PatientEntity, Integer> pDao = this.daoFactory.getPatientDAO();

            if(!fragment.getDescription().matches("") &&
                !fragment.getName().matches("") &&
                this.selectedDate.getTime() > 0) {

                PatientEntity patient = pDao.queryForId(this.activity.getPatient_id());

                AppointmentEntity appointmentEntity = new AppointmentEntity(fragment.getName(), this.selectedDate.getTime(), fragment.getDescription(), fragment.getAddress(), patient);
                aDao.create(appointmentEntity);
                Log.i("appointments", "Appointment created");

                return true;
            }
            else{
                return false;
            }

        }catch(SQLException e){
            e.printStackTrace();

            return false;
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

    private void paintDateBlack(Date date){

        this.activity.getfAppointment().getCaldroidFragment().setTextColorForDate(R.color.caldroid_black, date);
    }

    public void deleteAppointment(Date date) throws SQLException {

        Dao<AppointmentEntity, Integer> aDao = this.daoFactory.getAppointmentDAO();
        List<AppointmentEntity> allAppointments = this.getAllAppointments();
        for(int i = 0; i < allAppointments.size(); i++){

            if(allAppointments.get(i).getTimestamp() == date.getTime()){

                aDao.delete(allAppointments.get(i));
            }
        }
        this.paintDateBlack(date);
    }

    public void repaintCalendar(){

        List<AppointmentEntity> aEntities = getAllAppointments();
        Date tempDate;

        for(int i = 0; i < aEntities.size(); i++){

            Log.i("appointments", aEntities.get(i).getTName() + " "
                    + aEntities.get(i).getTimestamp() + " "
                    + aEntities.get(i).getTDescription() + " "
                    + aEntities.get(i).getTAddress());
            tempDate = new Date(aEntities.get(i).getTimestamp());
            this.activity.getfAppointment().getCaldroidFragment().setTextColorForDate(R.color.red, tempDate);
        }
        this.activity.getfAppointment().getCaldroidFragment().refreshView();
        if(this.checkForAppointment(this.selectedDate) == true){

            Log.i("appointments", "there is appointment");
            this.setAppointmentInfoText(this.selectedDate);
        }
        else{
            this.setAppointmentInfoTextEmpty();
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
