package comfabiankock.httpsgithub.pflegi3000.feature.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;

public class database {

    private SQLiteDatabase db;
    private String databaseName = "patients.db";

    public database(Context theContext){

        this.db = theContext.openOrCreateDatabase(theContext.getDatabasePath(this.databaseName).getPath(), theContext.MODE_PRIVATE, null);

        this.db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Patients(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName VARCHAR," +
                "lastName VARCHAR, " +
                "insuranceNr INTEGER);");
    }

    public boolean insertPatient(String firstName,String lastName, int insuranceNr){

        ContentValues values = new ContentValues();

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

    public Cursor doSearch(String query){

        String selectQuery = "SELECT * FROM Patients " +
                             "WHERE firstName=\""+query+" OR lastName=\""+query+"\" OR insuranceNr=\""+query+"\";";

        Cursor c = this.db.rawQuery(selectQuery,null);
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
