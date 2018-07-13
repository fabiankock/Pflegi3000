package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment;

import android.support.constraint.ConstraintLayout;
import android.view.View;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class ListenerMedikamentFragment implements View.OnClickListener{

    private ControllerMedikamentFragment controller;

    public ListenerMedikamentFragment (ControllerMedikamentFragment controller) {

        this.controller = controller;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fab:

                controller.switchAddShow();
                break;

            case R.id.add_mCommit:

                controller.processInput();
                controller.switchAddShow();
                break;
        }
    }
}
