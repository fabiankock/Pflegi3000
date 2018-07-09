package comfabiankockpflegi3000.github.pflegi3000.database;

import android.content.SharedPreferences;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.preference.PreferenceManager;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.database.tables.AppointmentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class DaoFactory extends android.app.Application {

    private SharedPreferences preferences;
    private DatabaseHelper databaseHelper = null;

    private Dao<PatientEntity, Integer> patientDAO = null;
    private Dao<InsuranceEntity, Integer> insuranceDAO = null;
    private Dao<AppointmentEntity, Integer> appointmentDAO = null;
    private Dao<MedikamentEntity, Integer> medikamentDAO = null;

    public DaoFactory(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        databaseHelper = new DatabaseHelper(this);
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public Dao<PatientEntity, Integer> getPatientDAO() throws SQLException {

        if (patientDAO == null) {
            patientDAO= databaseHelper.getDao(PatientEntity.class);
        }
        return patientDAO;
    }
    public Dao<InsuranceEntity, Integer> getInsuranceDAO() throws SQLException {

        if(insuranceDAO == null){
            insuranceDAO = databaseHelper.getDao(InsuranceEntity.class);
        }
        return insuranceDAO;
    }

    public Dao<MedikamentEntity, Integer> getMedikamentDAO() throws SQLException {

        if(medikamentDAO == null) {
            medikamentDAO = databaseHelper.getDao(MedikamentEntity.class);
        }
        return medikamentDAO;
    }

    public Dao<AppointmentEntity, Integer> getAppointmentDAO() throws SQLException {

        if (appointmentDAO == null) {
            appointmentDAO = databaseHelper.getDao(AppointmentEntity.class);
        }
        return appointmentDAO;
    }

    public void dropInsuranceTable() throws SQLException {

        TableUtils.dropTable(this.getInsuranceDAO(), true);
    }

    public void dropPatientTable() throws SQLException{

        TableUtils.dropTable(this.getPatientDAO(), true);
    }

    @Override
    public void onTerminate() {

        super.onTerminate();
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
