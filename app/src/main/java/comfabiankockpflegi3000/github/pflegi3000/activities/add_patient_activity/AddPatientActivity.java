package comfabiankockpflegi3000.github.pflegi3000.activities.add_patient_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class AddPatientActivity extends AppCompatActivity {

    private Button backBtn;
    private AddPatientButtonListener btnListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        this.btnListener = new AddPatientButtonListener();
        this.backBtn = (Button) findViewById(R.id.back_button_addPatientActivity);
        this.backBtn.setOnClickListener(this.btnListener);
    }
}
