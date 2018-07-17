package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import android.text.format.DateFormat;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "medikament")
public class MedikamentEntity {

    @DatabaseField(columnName = "mId", generatedId = true) private int id;
    @DatabaseField private String MName;
    @DatabaseField private int MDose;
    @DatabaseField private int hour;
    @DatabaseField private int minute;
    @DatabaseField private boolean genommen = false;
    @DatabaseField private int daycounter;

    public MedikamentEntity() {/*Default Constructor*/}

    public MedikamentEntity(String MName, int MDose, int hour, int minute) {

        this.MName = MName;
        this.MDose = MDose;
        this.hour = hour;
        this.minute = minute;

        Date date = new Date();
        this.daycounter = Integer.parseInt((String) DateFormat.format("dd", date));

    }

    /*----------------Getter----------------*/

    public int getId() {
        return this.id;
    }

    public String getMName() {
        return this.MName;
    }

    public int getMDose() {
        return this.MDose;
    }

    public boolean getGenommen() {
        return this.genommen;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getDaycounter() {
        return this.daycounter;
    }


    /*----------------Setter----------------*/
    public void setMName(String name) {
        this.MName = name;
    }

    public void setMDose(int dose) {
        this.MDose = dose;
    }

    public void setGenommen (boolean geonmmen) {
        this.genommen = geonmmen;
    }

    public void setDaycounter (int day) {
        this.daycounter = day;
    }

}


