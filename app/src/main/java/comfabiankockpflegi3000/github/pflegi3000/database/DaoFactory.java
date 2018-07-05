package comfabiankockpflegi3000.github.pflegi3000.database;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientTable;

public class DaoFactory extends Application {

    private SharedPreferences preferences;
    private DatabaseHelper databaseHelper = null;

    private Dao<PatientTable, Integer> patientDAO = null;

    @Override
    public void onCreate() {
        super.onCreate();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        databaseHelper = new DatabaseHelper(this);
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public Dao<PatientTable, Integer> getPatientDAO() throws SQLException {

        if (patientDAO == null) {
            patientDAO= databaseHelper.getDao(PatientTable.class);
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
