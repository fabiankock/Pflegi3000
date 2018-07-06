package comfabiankockpflegi3000.github.pflegi3000.controller.alter_tables_controller;

import android.view.View;

import java.sql.SQLException;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.alter_tables_activity.add_insurance_activity.AddInsuranceActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.main_activity.MainActivity;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;

public class AlterTablesButtonListener implements View.OnClickListener{

    private DaoFactory daoFactory;

    public AlterTablesButtonListener(DaoFactory df){

        this.daoFactory = df;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.back_button_altertable:
                AndroidHelper.startNewActivity(view.getContext(), MainActivity.class);
                break;

            case R.id.drop_patienttable_button:
                try {
                    this.daoFactory.dropPatientTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.drop_insurancetable_button:
                try {
                    this.daoFactory.dropInsuranceTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.edit_insurancetable_button:
                AndroidHelper.startNewActivity(view.getContext(), AddInsuranceActivity.class);
                break;
        }
    }
}
