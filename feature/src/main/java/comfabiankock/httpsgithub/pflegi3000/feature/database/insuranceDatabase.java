package comfabiankock.httpsgithub.pflegi3000.feature.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class insuranceDatabase {

    private SQLiteDatabase db;
    private String databaseName = "patients.db";

    public insuranceDatabase(Context theContext){

        this.db = theContext.openOrCreateDatabase(theContext.getDatabasePath(this.databaseName).getPath(), theContext.MODE_PRIVATE, null);

        this.db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Insurance(iId INTEGER CONSTRAINT pk_insurance PRIMARY KEY AUTOINCREMENT, " +
                "type VARCHAR," +
                "name VARCHAR);");
    }

    public boolean insertInsurance(String type, String name){

        ContentValues values = new ContentValues();

        values.put("type",type);
        values.put("name",name);
        if(this.db.insertOrThrow("Insurance", null, values) == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public String getInsuranceOfPatientById(int id){

        String selectQuery = "SELECT p.lastName, i.type, i.name FROM " +
                             "Patients p, Insurance i WHERE p.iId=i.iId AND p.pId="+id+";";
        Cursor c = this.db.rawQuery(selectQuery, null);

        c.moveToFirst();
        String name = c.getString(0);
        String iType = c.getString(1);
        String iName = c.getString(2);

        return (name + " " + iType + ": " + iName + "\n");
    }

    public ArrayList<String> getAllInsurances(){

        ArrayList<String> lst = new ArrayList<>();

        String selectQuery = "SELECT * FROM Insurance;";
        Cursor c = this.db.rawQuery(selectQuery, null);

        if(c.getCount() > 0) {
            c.moveToFirst();
            lst.add(c.getString(0) + " " + c.getString(1) + " " + c.getString(2));
            while (c.moveToNext()) {
                lst.add(c.getString(0) + " " + c.getString(1) + " " + c.getString(2));
            }
        }
        return lst;
    }
    public void dropTable(){

        this.db.execSQL("DROP TABLE Insurance");
        this.db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Insurance(iId INTEGER CONSTRAINT pk_insurance PRIMARY KEY AUTOINCREMENT, " +
                "type VARCHAR," +
                "name VARCHAR);");
    }

}
