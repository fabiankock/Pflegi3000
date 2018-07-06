package comfabiankockpflegi3000.github.pflegi3000.activities.alter_tables_activity.add_insurance_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.add_insurance_controller.ControllerAddInsuranceActivity;

public class AddInsuranceActivity extends AppCompatActivity {

    private EditText insuranceNameET, insuranceTypeET;
    private Button submitBtn, backBtn;
    private ControllerAddInsuranceActivity controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_insurance);
        this.controller = new ControllerAddInsuranceActivity();

        this.insuranceNameET = (EditText) findViewById(R.id.edittext_insuranceName);
        this.insuranceTypeET = (EditText) findViewById(R.id.edittext_insuranceType);

        this.submitBtn = (Button) findViewById(R.id.submit_button_add_insurance);
        this.submitBtn.setOnClickListener(this.controller.getBtnListener());
        this.backBtn = (Button) findViewById(R.id.back_button_add_insurance);
        this.backBtn.setOnClickListener(this.controller.getBtnListener());
    }

    public String getInsuranceNameValue(){
        return this.insuranceNameET.getText().toString();
    }
    public String getInsuranceTypeValue(){
        return this.insuranceTypeET.getText().toString();
    }
}
