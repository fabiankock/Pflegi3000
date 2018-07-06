package comfabiankockpflegi3000.github.pflegi3000.controller.add_insurance_controller;

import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.alter_tables_activity.AlterTablesActivity;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;

public class AddInsuranceButtonListener implements View.OnClickListener {

    private ControllerAddInsuranceActivity theController;

    public AddInsuranceButtonListener(ControllerAddInsuranceActivity a){
        this.theController = a;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.back_button_add_insurance:
                AndroidHelper.startNewActivity(view.getContext(), AlterTablesActivity.class);
                break;

            case R.id.submit_button_add_insurance:
                this.theController.processInput();
                AndroidHelper.startNewActivity(view.getContext(), AlterTablesActivity.class);
                break;
        }
    }
}
