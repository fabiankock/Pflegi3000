package comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Random;

import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.TerminEntity;

public class ControllerAddPatientActivity {

    private DaoFactory daofactory;
    private AddPatientActivity addPatientActivity;
    private AddPatientButtonListener btnListener;

    public ControllerAddPatientActivity(AddPatientActivity theActivity){

        this.addPatientActivity = theActivity;
        this.btnListener = new AddPatientButtonListener(this);
    }

    public void processInput() {


        daofactory = (DaoFactory) addPatientActivity.getApplication();

        int insNr = Integer.parseInt(this.addPatientActivity.getInsuranceNrValue());
        char gender = this.addPatientActivity.getGenderValue().toCharArray()[0];

        try {

            Dao<PatientEntity, Integer> pDao = daofactory.getPatientDAO();

            MedikamentEntity tpMedikament = new MedikamentEntity();
            TerminEntity tpTermin = new TerminEntity();
            PatientEntity tpPatient = new PatientEntity(this.addPatientActivity.getFirstNameValue(), this.addPatientActivity.getLastNameValue(),
                                                        gender, insNr,
                                                        /*insurance*/null,
                                                        /*medications*/null, /*appointments*/null);

            /*tpPatient.id = new Random().nextInt(100);
            tpPatient.setFirstname(firstname);
            tpPatient.setLastname(lastname);

            tpPatient.medi = tpMedikament;
            tpPatient.termi = tpTermin;*/

            pDao.create(tpPatient);
            //Send Database query to insert new Patient

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public AddPatientButtonListener getButtonListener() {

        return btnListener;
    }
}
