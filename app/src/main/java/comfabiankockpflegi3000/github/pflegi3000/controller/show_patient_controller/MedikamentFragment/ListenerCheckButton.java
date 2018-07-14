package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment;

import android.support.design.chip.ChipGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;

public class ListenerCheckButton implements CompoundButton.OnCheckedChangeListener {

    private MedikamentEntity m;
    private ControllerMedikamentFragment controller;

    public ListenerCheckButton (MedikamentEntity m, ControllerMedikamentFragment controller) {

        this.controller = controller;
        this.m = m;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        controller.checkGenommen(m, b);
    }
}
