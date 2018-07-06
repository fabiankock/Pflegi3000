package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "patient")
public class PatientEntity {
    @DatabaseField(id = true, generatedId = false) public int id;
    @DatabaseField String firstname;
    @DatabaseField String lastname;
    public MedikamentEntity medi;
    public TerminEntity termi;
    public PatientEntity() {/*ORMLite needs a default Constructor*/};

    public PatientEntity(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /*----------------Getter----------------*/
    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    /*----------------Setter----------------*/
    public void setFirstname(String name) {
        this.firstname = name;
    }

    public void setLastname(String name) {
        this.lastname = name;
    }

}
