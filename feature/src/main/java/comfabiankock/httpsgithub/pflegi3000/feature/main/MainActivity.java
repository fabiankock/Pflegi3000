package comfabiankock.httpsgithub.pflegi3000.feature.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import comfabiankock.httpsgithub.pflegi3000.feature.R;


public class MainActivity extends Activity {

    private Button patientBtn, eventBtn;
    private TextView appNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.appNameText = (TextView) findViewById(R.id.appNameTV);
        this.appNameText.setText(R.string.app_name);

        this.patientBtn = (Button) findViewById(R.id.patientButton);
        this.patientBtn.setText(R.string.patient_str);
        this.patientBtn.setOnClickListener(new patientBtnListener());

        this.eventBtn = (Button) findViewById(R.id.eventButton);
        this.eventBtn.setText(R.string.event_str);
        this.eventBtn.setOnClickListener(new eventBtnListener());
    }
}
