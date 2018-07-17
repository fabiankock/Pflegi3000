package comfabiankockpflegi3000.github.pflegi3000.controller.add_insurance_controller;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.activities.add_insurance_activity.AddInsuranceActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.InsuranceEntity;

public class ControllerAddInsuranceActivity {

    private AddInsuranceButtonListener btnListener;
    private AddInsuranceActivity theActivity;
    private DaoFactory daofactory;

    public ControllerAddInsuranceActivity(AddInsuranceActivity a){

        this.btnListener = new AddInsuranceButtonListener(this);
        this.theActivity = a;
    }

    public boolean processInput(){

        this.daofactory = (DaoFactory) theActivity.getApplication();

        try {

            Dao<InsuranceEntity, Integer> iDao = daofactory.getInsuranceDAO();

            if(!this.theActivity.getInsuranceNameValue().matches("") &&
                !this.theActivity.getInsuranceTypeValue().matches("")) {

                InsuranceEntity insuranceEntity = new InsuranceEntity(this.theActivity.getInsuranceNameValue(),
                        this.theActivity.getInsuranceTypeValue());

                iDao.create(insuranceEntity);
                //Send Database query to insert new Insurance
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public AddInsuranceButtonListener getBtnListener() {
        return btnListener;
    }
}
