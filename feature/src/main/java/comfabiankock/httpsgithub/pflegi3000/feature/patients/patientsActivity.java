package comfabiankock.httpsgithub.pflegi3000.feature.patients;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import comfabiankock.httpsgithub.pflegi3000.feature.R;
import comfabiankock.httpsgithub.pflegi3000.feature.database.database;
import comfabiankock.httpsgithub.pflegi3000.feature.main.backBtnListener;

public class patientsActivity extends Activity {

    private TextView screenNameText, outputFirstNameTxt, outputLastNameTxt, outputInsuranceNrTxt;
    private Button backBtn, dropBtn;
    private database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Cursor patientCursor;
        int id;
        String idStr="", firstN="", lastN="", inNr="";

        this.db = new database(this.getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        this.screenNameText = (TextView) findViewById(R.id.screen_name);
        this.screenNameText.setText(R.string.patient_str);

        this.backBtn = (Button) findViewById(R.id.back_button);
        this.backBtn.setText(R.string.back_str);
        this.backBtn.setOnClickListener(new backBtnListener());

        this.dropBtn = (Button) findViewById(R.id.drop_button);
        this.dropBtn.setText(R.string.drop_str);
        this.dropBtn.setOnClickListener(new dropBtnListener());

        this.outputFirstNameTxt = (TextView) findViewById(R.id.output_first_name);
        this.outputLastNameTxt = (TextView) findViewById(R.id.output_last_name);
        this.outputInsuranceNrTxt = (TextView) findViewById(R.id.output_insurance_number);
        patientCursor = this.db.getAllPatients();
        //TODO Auswerten der Searchbox und anzeigen der relevantesten Ergebnisse
        if(patientCursor.getCount() > 0) {

            while(patientCursor.moveToNext()){

                firstN += (patientCursor.getString(1)+"\n");
                lastN += (patientCursor.getString(2)+"\n");
                inNr += (patientCursor.getString(3)+"\n");
            }
            this.outputFirstNameTxt.setText(firstN);
            this.outputLastNameTxt.setText(lastN);
            this.outputInsuranceNrTxt.setText(inNr);
        }
        else{
            Log.d("PatientDatabase","Empty Data");
        }
    }
}
