package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "care")
public class CareEntity {

    @DatabaseField(columnName = "cId", generatedId = true) private int id;
    @DatabaseField(columnName = "lMeal") private long l_meal;
    @DatabaseField(columnName = "lDefecation") private long l_defecation;
    @DatabaseField(columnName = "lWashed") private long l_washed;
    @DatabaseField(columnName = "Patient", foreign = true) private PatientEntity patient;

    public CareEntity() {/*Default Constructor for ORMLite*/}

    public CareEntity(long meal, long defecation, long washed, PatientEntity patient) {

        this.l_meal= meal;
        this.l_defecation = defecation;
        this.l_washed = washed;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public long getL_defecation() {
        return l_defecation;
    }

    public long getL_meal() {
        return l_meal;
    }

    public long getL_washed() {
        return l_washed;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setL_defecation(long l_defecation) {
        this.l_defecation = l_defecation;
    }

    public void setL_meal(long l_meal) {
        this.l_meal = l_meal;
    }

    public void setL_washed(long l_washed) {
        this.l_washed = l_washed;
    }
}
