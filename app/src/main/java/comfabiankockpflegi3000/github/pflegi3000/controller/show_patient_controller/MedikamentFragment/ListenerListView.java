package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment;

import android.view.View;

import java.sql.SQLException;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;

public class ListenerListView implements View.OnLongClickListener {

    private ControllerMedikamentFragment controller;
    private int medi_id;
    private List<MedikamentEntity> medication;

    public ListenerListView(ControllerMedikamentFragment controller, int id, List<MedikamentEntity> medication) {

        this.controller = controller;
        this.medi_id = id;
        this.medication = medication;
    }

    @Override
    public boolean onLongClick(View view) {

        MedikamentEntity medi;

        for (int i=0; i<medication.size(); i++) {
            if (medication.get(i).getId() == medi_id) {

                medi = medication.get(i);

                try {
                    controller.deleteMedication(medi);
                } catch (SQLException e) {
                    e.printStackTrace();
                    return true;
                }
                controller.refreshList();

            }
        }
        return false;
    }
}
