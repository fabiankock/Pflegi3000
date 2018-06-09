package comfabiankock.httpsgithub.pflegi3000.feature.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;

public class database {

    private SQLiteDatabase db;
    private String name;

    public database(Context theContext){

        this.name = "patients.db";
        this.db = theContext.openOrCreateDatabase(theContext.getDatabasePath(this.name).getPath(), theContext.MODE_PRIVATE, null);
    }

    public boolean insertPatient(String firstName,String lastName, int insuranceNr){

        ContentValues values = new ContentValues();

        this.db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Patients(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName VARCHAR," +
                "lastName VARCHAR, " +
                "insuranceNr INTEGER);");

        values.put("firstName",firstName);
        values.put("lastName",lastName);
        values.put("insuranceNr",insuranceNr);
        if(this.db.insertOrThrow("Patients", null, values) == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllPatients(){

        String selectQuery = "SELECT * FROM Patients;";

        Cursor c = this.db.rawQuery(selectQuery, null);
        return c;
    }

    public void dropTable(){

        this.db.execSQL("DROP TABLE Patients");
        this.db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Patients(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName VARCHAR," +
                "lastName VARCHAR, " +
                "insuranceNr INTEGER);");
    }
}
