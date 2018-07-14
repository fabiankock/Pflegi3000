package comfabiankockpflegi3000.github.pflegi3000.activities.alter_tables_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.alter_tables_controller.ControllerAlterTablesActivity;

public class AlterTablesActivity extends AppCompatActivity {

    private Button backBtn, dropPatientTBtn, dropInsuranceTBtn, editInsuranceTBtn, dropAppointmentBtn;
    private ControllerAlterTablesActivity controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_tables);
        this.controller = new ControllerAlterTablesActivity(this);

        this.backBtn = (Button) findViewById(R.id.back_button_altertable);
        this.backBtn.setOnClickListener(this.controller.getBtnListener());

        this.dropPatientTBtn = (Button) findViewById(R.id.drop_patienttable_button);
        this.dropPatientTBtn.setOnClickListener(this.controller.getBtnListener());

        this.dropInsuranceTBtn = (Button) findViewById(R.id.drop_insurancetable_button);
        this.dropInsuranceTBtn.setOnClickListener(this.controller.getBtnListener());

        this.editInsuranceTBtn = (Button) findViewById(R.id.edit_insurancetable_button);
        this.editInsuranceTBtn.setOnClickListener(this.controller.getBtnListener());

        this.dropAppointmentBtn = (Button) findViewById(R.id.drop_appointmenttable_button);
        this.dropAppointmentBtn.setOnClickListener(this.controller.getBtnListener());
    }
}
