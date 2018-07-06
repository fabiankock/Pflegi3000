package comfabiankockpflegi3000.github.pflegi3000.controller.add_insurance_controller;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.activities.alter_tables_activity.add_insurance_activity.AddInsuranceActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.TerminEntity;

public class ControllerAddInsuranceActivity {

    private AddInsuranceButtonListener btnListener;
    private AddInsuranceActivity theActivity;
    private DaoFactory daofactory;

    public ControllerAddInsuranceActivity(AddInsuranceActivity a){

        this.btnListener = new AddInsuranceButtonListener(this);
        this.theActivity = a;
    }

    public void processInput(){

        this.daofactory = (DaoFactory) theActivity.getApplication();

        try {

            Dao<InsuranceEntity, Integer> iDao = daofactory.getInsuranceDAO();

            InsuranceEntity insuranceEntity = new InsuranceEntity(this.theActivity.getInsuranceNameValue(),
                                                                  this.theActivity.getInsuranceTypeValue());

            iDao.create(insuranceEntity);
            //Send Database query to insert new Insurance

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public AddInsuranceButtonListener getBtnListener() {
        return btnListener;
    }
}
