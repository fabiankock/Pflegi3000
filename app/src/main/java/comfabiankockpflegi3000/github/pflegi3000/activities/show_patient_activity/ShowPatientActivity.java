package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class ShowPatientActivity extends AppCompatActivity {

    private Button backBtn;
    private ShowPatientButtonListener btnListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient);

        this.btnListener = new ShowPatientButtonListener();
        this.backBtn = (Button) findViewById(R.id.back_button_show_patientActivity);
        this.backBtn.setOnClickListener(this.btnListener);
    }
}
