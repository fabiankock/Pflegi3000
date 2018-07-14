package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "medikament")
public class MedikamentEntity {

    @DatabaseField(columnName = "mId", generatedId = true) private int id;
    @DatabaseField private String MName;
    @DatabaseField private int MDose;
    @DatabaseField private int MStundenAbstand;
    @DatabaseField private boolean genommen = false;

    public MedikamentEntity() {/*Default Constructor*/}

    public MedikamentEntity(String MName, int MDose, int MStundenAbstand) {

        this.MName = MName;
        this.MDose = MDose;
        this.MStundenAbstand = MStundenAbstand;

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

    public int getMStundenAbstand() {
        return this.MStundenAbstand;
    }

    public boolean getGenommen() {
        return this.genommen;
    }

    /*----------------Setter----------------*/
    public void setMName(String name) {
        this.MName = name;
    }

    public void setMDose(int dose) {
        this.MDose = dose;
    }

    public void setMStundenAbstand (int abstand) {
        this.MStundenAbstand = abstand;
    }

    public void setGenommen (boolean geonmmen) {
        this.genommen = geonmmen;
    }
}


