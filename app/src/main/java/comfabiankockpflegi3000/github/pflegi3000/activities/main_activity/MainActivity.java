package comfabiankockpflegi3000.github.pflegi3000.activities.main_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.main_activity_controller.ControllerMainActivity;
import comfabiankockpflegi3000.github.pflegi3000.controller.main_activity_controller.MainActivityButtonListener;

public class MainActivity extends AppCompatActivity {

    private Button patientsBtn, addPatientsBtn, alterTablesBtn;
    private ControllerMainActivity controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.controller = new ControllerMainActivity();

        this.patientsBtn = (Button) findViewById(R.id.patient_button);
        this.addPatientsBtn = (Button) findViewById(R.id.addpatient_button);
        this.alterTablesBtn = (Button) findViewById(R.id.edittables_button);

        this.patientsBtn.setOnClickListener(this.controller.getButtonListener());
        this.addPatientsBtn.setOnClickListener(this.controller.getButtonListener());
        this.alterTablesBtn.setOnClickListener(this.controller.getButtonListener());
    }
}
