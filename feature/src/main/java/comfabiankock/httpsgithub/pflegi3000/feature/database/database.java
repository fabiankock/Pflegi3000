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
                "Patients(pId INTEGER CONSTRAINT pk_patient PRIMARY KEY AUTOINCREMENT, " +
                "firstName VARCHAR," +
                "lastName VARCHAR, " +
                "age INTEGER," +
                "birthday DATE,"+
                "gender VARCHAR," +
                "insuranceNr INTEGER," +
                "iId INTEGER CONSTRAINT fk_insurance REFERENCES Insurance(iId));");
    }

    public boolean insertPatient(String firstName,String lastName,int age, String birthday, String gender, int insuranceNr, int fk_InsuranceId){

        ContentValues values = new ContentValues();

        values.put("firstName",firstName);
        values.put("lastName",lastName);
        values.put("age",age);
        values.put("birthday", birthday);
        values.put("gender",gender);
        values.put("insuranceNr",insuranceNr);
        values.put("iId", fk_InsuranceId);
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
                "Patients(pId INTEGER CONSTRAINT pk_patient PRIMARY KEY AUTOINCREMENT, " +
                "firstName VARCHAR," +
                "lastName VARCHAR, " +
                "age INTEGER," +
                "birthday DATE,"+
                "gender VARCHAR," +
                "insuranceNr INTEGER," +
                "iId INTEGER CONSTRAINT fk_insurance REFERENCES Insurance(iId));");
    }

    public int getPatientCount(){

        String selectQuery = "SELECT * FROM Patients;";

        Cursor c = this.db.rawQuery(selectQuery, null);
        return c.getCount();
    }
}
