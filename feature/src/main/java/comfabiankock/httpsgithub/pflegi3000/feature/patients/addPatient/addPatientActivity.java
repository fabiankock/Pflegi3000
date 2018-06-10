package comfabiankock.httpsgithub.pflegi3000.feature.patients.addPatient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import comfabiankock.httpsgithub.pflegi3000.feature.R;
import comfabiankock.httpsgithub.pflegi3000.feature.database.insuranceDatabase;

public class addPatientActivity extends Activity {

    private EditText firstnameTxt, lastnameTxt, insuranceNrTxt;
    private int insuranceID;
    private TextView headLine;
    private Button submitBtn;
    private Spinner insuranceTypeDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        this.headLine = (TextView) findViewById(R.id.add_patient_headline);
        this.headLine.setText(R.string.add_patient_str);

        this.firstnameTxt = (EditText) findViewById(R.id.firstname_edit_text);

        this.lastnameTxt = (EditText) findViewById(R.id.lastname_edit_text);

        this.insuranceNrTxt = (EditText) findViewById(R.id.insuranceNr_edit_text);

        this.submitBtn = (Button) findViewById(R.id.submit_button);
        this.submitBtn.setText(R.string.submit_str);
        this.submitBtn.setOnClickListener(new submitBtnListener(this));

        this.insuranceTypeDropdown = (Spinner) findViewById(R.id.insurance_type_spinner);
        insuranceDatabase iDB = new insuranceDatabase(this);
        ArrayList<String> values = iDB.getAllInsurances();
        if(values.size() > 0) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, values);
            //set the spinners adapter to the previously created one.
            this.insuranceTypeDropdown.setAdapter(adapter);
            this.insuranceTypeDropdown.setOnItemSelectedListener(new insuranceSpinnerListener(this));
        }

    }

    public String getFirstName(){

        return this.firstnameTxt.getText().toString();
    }

    public String getLastName(){

        return this.lastnameTxt.getText().toString();
    }

    public String getInsuranceNr(){

        return this.insuranceNrTxt.getText().toString();
    }

    public void setInsuranceID(int val){
        this.insuranceID = val;
    }

    public int getInsuranceID(){

        return this.insuranceID;
    }
}
