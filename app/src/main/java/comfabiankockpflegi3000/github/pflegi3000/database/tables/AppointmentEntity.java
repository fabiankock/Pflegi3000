package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "termin")
public class AppointmentEntity {

    @DatabaseField(columnName = "tId", generatedId = true) private int id;
    @DatabaseField(columnName = "AName") private String AName;
    @DatabaseField(columnName = "Date") private long timestamp;
    @DatabaseField(columnName = "Description") private String TDescription;
    @DatabaseField(columnName = "Address") private String TAddress;
    @DatabaseField(columnName = "Patient", foreign = true) private PatientEntity patient;

    public AppointmentEntity() {/*Default Constructor for ORMLite*/}

    public AppointmentEntity(String TName, long timestamp, String TDescription, String TAddress, PatientEntity patient) {

        this.AName = TName;
        this.timestamp = timestamp;
        this.TDescription = TDescription;
        this.TAddress= TAddress;
        this.patient = patient;
    }

    /*----------------Getter----------------*/
    public String getTName() {
        return this.AName;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTDescription(){
        return this.TDescription;
    }

    public String getTAddress() {
        return this.TAddress;
    }

    public PatientEntity getPatient() { return patient; }

    /*----------------Setter----------------*/
    public void setFirstname(String name) {
        this.AName = name;
    }

    public void setTimestamp(long time) {
        this.timestamp = time;
    }

    public void setTDescription(String description) {
        this.TDescription = description;
    }

    public void setTAddress(String address) {
        this.TAddress = address;
    }

    public void setPatient(PatientEntity patient) { this.patient = patient; }
}
