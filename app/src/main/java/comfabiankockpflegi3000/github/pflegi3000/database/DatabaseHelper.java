package comfabiankockpflegi3000.github.pflegi3000.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.AppointmentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientMedikamentConnection;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "db_pflegi3000.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTableIfNotExists(connectionSource, InsuranceEntity.class);
            TableUtils.createTableIfNotExists(connectionSource, MedikamentEntity.class);
            TableUtils.createTableIfNotExists(connectionSource, PatientEntity.class);
            TableUtils.createTableIfNotExists(connectionSource, AppointmentEntity.class);
            TableUtils.createTableIfNotExists(connectionSource, PatientMedikamentConnection.class);
        } catch (java.sql.SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.dropTable(connectionSource, PatientEntity.class, true);
            TableUtils.dropTable(connectionSource, InsuranceEntity.class, true);
            TableUtils.dropTable(connectionSource, MedikamentEntity.class, true);
            TableUtils.dropTable(connectionSource, AppointmentEntity.class, true);
            TableUtils.dropTable(connectionSource, PatientMedikamentConnection.class, true);
            onCreate(db,connectionSource);
        } catch (java.sql.SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
