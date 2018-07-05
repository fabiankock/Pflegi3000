package comfabiankockpflegi3000.github.pflegi3000.controller;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Random;

import comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity.AddPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentTable;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientTable;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.TerminTable;

public class ControllerAddPatientActivity {

    private DaoFactory daofactory;

    private AddPatientActivity addPatientActivity;

    public ControllerAddPatientActivity(AddPatientActivity theActivity){

        this.addPatientActivity = theActivity;
    }

    public void processInput(String firstname, String lastname) {


        daofactory = (DaoFactory) addPatientActivity.getApplication();

        try {

            Dao<PatientTable, Integer> pDao = daofactory.getPatientDAO();

            MedikamentTable tpMedikament = new MedikamentTable();
            TerminTable tpTermin = new TerminTable();
            PatientTable tpPatient = new PatientTable();

            tpPatient.id = new Random().nextInt(100);
            tpPatient.setFirstname(firstname);
            tpPatient.setLastname(lastname);

            tpPatient.medi = tpMedikament;
            tpPatient.termi = tpTermin;

            pDao.create(tpPatient);
            //Send Database query to insert new Patient

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getFirstName(){

        return this.addPatientActivity.getFirstNameValue();
    }

    public String getLastName(){

        return this.addPatientActivity.getLastNameValue();
    }
}
