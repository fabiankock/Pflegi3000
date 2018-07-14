package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "patient")
public class PatientEntity {
    @DatabaseField(columnName = "pId", generatedId = true) private int p_id;
    @DatabaseField(columnName = "FirstName") private String firstname;
    @DatabaseField(columnName = "LastName") private String lastname;
    @DatabaseField(columnName = "Gender") private char gender;
    @DatabaseField(columnName = "InsuranceNr") private int insuranceNumber;
    @DatabaseField(columnName = "InsuranceType", foreign = true) private InsuranceEntity insuranceEntity;

    public PatientEntity() {/*ORMLite needs a default Constructor*/};

    public PatientEntity(String firstname, String lastname,
                         char gender, int insuranceNumber, InsuranceEntity insuranceEntity) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.insuranceNumber = insuranceNumber;
        this.insuranceEntity = null;
    }

    /*----------------Getter----------------*/

    public int getP_id() { return this.p_id; }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public char getGender() { return this.gender; }

    public int getInsuranceNumber() { return insuranceNumber; }

    public InsuranceEntity getInsuranceEntity() { return insuranceEntity; }

    /*----------------Setter----------------*/
    public void setFirstname(String name) {
        this.firstname = name;
    }

    public void setLastname(String name) {
        this.lastname = name;
    }

    public void setGender(char gender) { this.gender = gender; }

    public void setInsuranceNumber(int insuranceNumber) { this.insuranceNumber = insuranceNumber; }

    public void setInsuranceEntity(InsuranceEntity insuranceEntity) { this.insuranceEntity = insuranceEntity; }
}
