package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "medikament")
public class MedikamentEntity {

    @DatabaseField(columnName = "mId", generatedId = true) private int id;
    @DatabaseField private String MName;
    @DatabaseField private int MDose;
    @DatabaseField private int hour;
    @DatabaseField private int minute;
    @DatabaseField private boolean genommen = false;

    public MedikamentEntity() {/*Default Constructor*/}

    public MedikamentEntity(String MName, int MDose, int hour, int minute) {

        this.MName = MName;
        this.MDose = MDose;
        this.hour = hour;
        this.minute = minute;

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
}


