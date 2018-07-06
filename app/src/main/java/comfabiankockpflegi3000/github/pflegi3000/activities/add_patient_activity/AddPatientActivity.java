package comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller.AddPatientButtonListener;
import comfabiankockpflegi3000.github.pflegi3000.controller.add_patient_controller.ControllerAddPatientActivity;

public class AddPatientActivity extends AppCompatActivity {

    private Button backBtn;
    private Button submitBtn;
    private EditText firstNameEditText, lastNameEditText, genderEditText, insuranceNrEditText;
    private Spinner insuranceSpinner;
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
        this.genderEditText = (EditText) findViewById(R.id.edittext_gender);
        this.insuranceNrEditText = (EditText) findViewById(R.id.edittext_insuranceNr);

        this.insuranceSpinner = (Spinner) findViewById(R.id.insurance_spinner);
        String[] items = this.controller.getAllInsurances();
        if(items != null){
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
            this.insuranceSpinner.setAdapter(adapter);
        }

    }

    public String getFirstNameValue(){ return this.firstNameEditText.getText().toString(); }

    public String getLastNameValue() { return this.lastNameEditText.getText().toString(); }

    public String getGenderValue() { return this.genderEditText.getText().toString(); }

    public String getInsuranceNrValue() { return this.insuranceNrEditText.getText().toString(); }
}
