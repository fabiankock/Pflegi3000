package comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class SearchPatientActivity extends AppCompatActivity {

    private Button backBtn;
    private Button testShowPatientBtn;
    private SearchPatientButtonListener btnListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);

        this.btnListener = new SearchPatientButtonListener();
        this.backBtn = (Button) findViewById(R.id.back_button_search_patient);
        this.backBtn.setOnClickListener(this.btnListener);

        this.testShowPatientBtn = (Button) findViewById(R.id.open_showpatients_button);
        this.testShowPatientBtn.setOnClickListener(this.btnListener);

    }
}
