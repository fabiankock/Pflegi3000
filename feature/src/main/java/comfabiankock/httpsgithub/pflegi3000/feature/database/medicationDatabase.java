package comfabiankock.httpsgithub.pflegi3000.feature.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class medicationDatabase {

    private SQLiteDatabase db;
    private String databaseName = "patients.db";

    public medicationDatabase(Context theContext){

        this.db = theContext.openOrCreateDatabase(theContext.getDatabasePath(this.databaseName).getPath(), theContext.MODE_PRIVATE, null);

        this.db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Medication(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name VARCHAR," +
                "Description VARCHAR);");
    }
}
