package comfabiankock.httpsgithub.pflegi3000.feature.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import comfabiankock.httpsgithub.pflegi3000.feature.R;


public class MainActivity extends Activity {

    private Button patientBtn, eventBtn, addBtn, databaseBtn;
    private TextView appNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.appNameText = (TextView) findViewById(R.id.app_name_tv);
        this.appNameText.setText(R.string.app_name);

        this.patientBtn = (Button) findViewById(R.id.patient_button);
        this.patientBtn.setText(R.string.patient_str);
        this.patientBtn.setOnClickListener(new patientBtnListener());

        this.eventBtn = (Button) findViewById(R.id.event_button);
        this.eventBtn.setText(R.string.event_str);
        this.eventBtn.setOnClickListener(new eventBtnListener());

        this.addBtn = (Button) findViewById(R.id.add_button);
        this.addBtn.setText(R.string.add_str);
        this.addBtn.setOnClickListener(new addBtnListener());

        this.databaseBtn = (Button) findViewById(R.id.database_button);
        this.databaseBtn.setText(R.string.modify_database_str);
        this.databaseBtn.setOnClickListener(new databaseBtnListener());
    }
}
