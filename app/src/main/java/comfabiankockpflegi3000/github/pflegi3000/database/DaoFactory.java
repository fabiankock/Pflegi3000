package comfabiankockpflegi3000.github.pflegi3000.database;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class DaoFactory extends android.app.Application {

    private SharedPreferences preferences;
    private DatabaseHelper databaseHelper = null;

    private Dao<PatientEntity, Integer> patientDAO = null;
    private Dao<PatientEntity, Integer> terminDAO = null;
    private Dao<PatientEntity, Integer> medikamentDAO = null;

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

    @Override
    public void onTerminate() {

        super.onTerminate();
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
