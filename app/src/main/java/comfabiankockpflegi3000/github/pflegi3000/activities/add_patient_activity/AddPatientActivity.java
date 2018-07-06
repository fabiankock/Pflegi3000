package comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller.AddPatientButtonListener;
import comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller.ControllerAddPatientActivity;

public class AddPatientActivity extends AppCompatActivity {

    private Button backBtn;
    private Button submitBtn;
    private EditText firstNameEditText, lastNameEditText;
    private ControllerAddPatientActivity controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        this.controller = new ControllerAddPatientActivity(this);

        this.backBtn = (Button) findViewById(R.id.back_button_addPatientActivity);
        this.backBtn.setOnClickListener(this.controller.getButtonListener());

        this.submitBtn = (Button) findViewById(R.id.submit_button_addPatientActivity);
        this.submitBtn.setOnClickListener(this.controller.getButtonListener());

        this.firstNameEditText = (EditText) findViewById(R.id.edittext_firstname);
        this.lastNameEditText = (EditText) findViewById(R.id.edittext_lastname);
    }

    public String getFirstNameValue(){

        return this.firstNameEditText.getText().toString();
    }

    public String getLastNameValue() {

        return this.lastNameEditText.getText().toString();
    }
}
