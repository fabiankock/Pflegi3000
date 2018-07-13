package comfabiankockpflegi3000.github.pflegi3000.database.tables;

import com.j256.ormlite.field.DatabaseField;


public class PatientMedikamentConnection {
    @DatabaseField (columnName = "id", generatedId = true) private int id;
    @DatabaseField (columnName = "pID", foreign = true) private PatientEntity p_ID;
    @DatabaseField (columnName = "mID", foreign = true) private MedikamentEntity m_ID;

    public PatientMedikamentConnection(){};
    public PatientMedikamentConnection(PatientEntity p_ID, MedikamentEntity m_ID) {
        this.p_ID = p_ID;
        this.m_ID = m_ID;
    }


    /*----------getter----------*/


    public MedikamentEntity getM_ID() {
        return m_ID;
    }

    public PatientEntity getP_ID() {
        return p_ID;
    }

    /*----------setter----------*/

    public void setM_ID(MedikamentEntity m_ID) {
        this.m_ID = m_ID;
    }

    public void setP_ID(PatientEntity p_ID) {
        this.p_ID = p_ID;
    }
}
