package comfabiankock.httpsgithub.pflegi3000.feature.patients.showPatient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import comfabiankock.httpsgithub.pflegi3000.feature.R;
import comfabiankock.httpsgithub.pflegi3000.feature.database.database;
import comfabiankock.httpsgithub.pflegi3000.feature.database.insuranceDatabase;

public class showPatientActivity extends AppCompatActivity {

    private TextView nameTxt, insuranceTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient);

        database db = new database(this);
        insuranceDatabase insuranceDB = new insuranceDatabase(this);

        String idStr = getIntent().getStringExtra("ID");
        int id = Integer.parseInt(idStr);
        String insurance = insuranceDB.getInsuranceOfPatientById(id);

        this.nameTxt = (TextView) findViewById(R.id.patient_name);
        this.nameTxt.setText("Name: " + db.getPatientNameById(id));
        this.insuranceTxt = (TextView) findViewById(R.id.patient_insurance);
        this.insuranceTxt.setText("Versicherung: " + insurance);
    }
}
