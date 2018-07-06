package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "medikament")
public class MedikamentEntity {

    @DatabaseField(columnName = "mId", generatedId = true) private int id;
    @DatabaseField private String MName;
    @DatabaseField private int MDose;
    @DatabaseField private String MDescription;

    public MedikamentEntity() {/*Default Constructor*/}

    public MedikamentEntity(String MName, int MDose, String MDescription) {

        this.MName = MName;
        this.MDose = MDose;
        this.MDescription = MDescription;
    }

    /*----------------Getter----------------*/
    public String getMName() {
        return this.MName;
    }

    public int getMDose() {
        return this.MDose;
    }

    public String getMDescription() {
        return this.MDescription;
    }

    /*----------------Setter----------------*/
    public void setMName(String name) {
        this.MName = name;
    }

    public void setMDose(int dose) {
        this.MDose = dose;
    }

    public void setMDescription (String description) {
        this.MDescription = description;
    }
}


