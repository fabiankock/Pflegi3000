package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "termin")
public class TerminEntity {

    @DatabaseField(columnName = "tId", generatedId = true) private int id;
    @DatabaseField private String TName;
    @DatabaseField private Date timestamp;
    @DatabaseField private String TDescription;
    @DatabaseField private String TAddress;

    public TerminEntity() {/*Default Constructor for ORMLite*/}

    public TerminEntity(String TName, Date timestamp, String TDescription, String TAddress) {

        this.TName = TName;
        this.timestamp = timestamp;
        this.TDescription = TDescription;
        this.TAddress= TAddress;
    }

    /*----------------Getter----------------*/
    public String getTName() {
        return this.TName;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getTDescription(){
        return this.TDescription;
    }

    public String getTAddress() {
        return this.TAddress;
    }

    /*----------------Setter----------------*/
    public void setFirstname(String name) {
        this.TName = name;
    }

    public void setTimestamp(Date time) {
        this.timestamp = time;
    }

    public void setTDescription(String description) {
        this.TDescription = description;
    }

    public void setTAddress(String address) {
        this.TAddress = address;
    }
}
