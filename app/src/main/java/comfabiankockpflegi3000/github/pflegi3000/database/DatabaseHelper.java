package comfabiankockpflegi3000.github.pflegi3000.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentTable;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientTable;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.TerminTable;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "db_pflegi.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, PatientTable.class);
            TableUtils.createTable(connectionSource, MedikamentTable.class);
            TableUtils.createTable(connectionSource, TerminTable.class);
        } catch (java.sql.SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.dropTable(connectionSource, PatientTable.class, true);
            TableUtils.dropTable(connectionSource, MedikamentTable.class, true);
            TableUtils.dropTable(connectionSource, TerminTable.class, true);
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
