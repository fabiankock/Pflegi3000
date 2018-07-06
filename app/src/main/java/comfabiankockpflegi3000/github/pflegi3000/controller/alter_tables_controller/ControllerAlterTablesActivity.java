package comfabiankockpflegi3000.github.pflegi3000.controller.alter_tables_controller;

import comfabiankockpflegi3000.github.pflegi3000.activities.alter_tables_activity.AlterTablesActivity;
import comfabiankockpflegi3000.github.pflegi3000.controller.main_activity_controller.ControllerMainActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;

public class ControllerAlterTablesActivity {

    private AlterTablesButtonListener btnListener;
    private DaoFactory daoFactory;

    public ControllerAlterTablesActivity(AlterTablesActivity activity){

        this.daoFactory = (DaoFactory) activity.getApplication();
        this.btnListener = new AlterTablesButtonListener(this.daoFactory);
    }

    public AlterTablesButtonListener getBtnListener() { return this.btnListener; }
}
