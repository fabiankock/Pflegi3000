package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerCareFragment;

import android.view.View;

import java.sql.SQLException;
import java.util.Date;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class CareFragmentButtonListener implements View.OnClickListener {

    private ControllerCareFragment controller;

    public CareFragmentButtonListener(ControllerCareFragment c){

        this.controller = c;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.now_button_defecation:
                try {
                    this.controller.now_Defecation();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.now_button_meal:
                try {
                    this.controller.now_Meal();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.now_button_washed:
                try {
                    this.controller.now_Washed();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
}
