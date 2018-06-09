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

    private TextView screenNameText, outputTxt;
    private Button backBtn;
    private database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Cursor patientCursor;
        int id;
        String firstN, lastN, inNr, outputData="";

        this.db = new database(this.getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        this.screenNameText = (TextView) findViewById(R.id.screen_name);
        this.screenNameText.setText(R.string.patient_str);

        this.backBtn = (Button) findViewById(R.id.back_button);
        this.backBtn.setText(R.string.back_str);
        this.backBtn.setOnClickListener(new backBtnListener());

        this.outputTxt = (TextView) findViewById(R.id.output);
        patientCursor = this.db.getAllPatients();
        if(patientCursor.getCount() > 0) {

            patientCursor.moveToFirst();
            while(patientCursor.moveToNext()){

                id = patientCursor.getInt(0);
                firstN = patientCursor.getString(1);
                lastN = patientCursor.getString(2);
                inNr = patientCursor.getString(3);
                outputData += ("ID: "+ id + " " + firstN + " " + lastN + " " + inNr + "\n");
            }
            this.outputTxt.setText(outputData);
        }
        else{
            Log.d("PatientDatabase","Empty Data");
        }
    }
}
