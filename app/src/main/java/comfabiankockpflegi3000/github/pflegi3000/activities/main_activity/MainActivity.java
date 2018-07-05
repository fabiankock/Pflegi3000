package comfabiankockpflegi3000.github.pflegi3000.activities.main_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class MainActivity extends AppCompatActivity {

    private Button patientsBtn, addPatientsBtn;
    private View.OnClickListener btnListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.patientsBtn = (Button) findViewById(R.id.patient_button);
        this.addPatientsBtn = (Button) findViewById(R.id.addpatient_button);

        this.btnListener = new MainActivityButtonListener();
        System.out.println(this.btnListener.toString());
        this.patientsBtn.setOnClickListener(this.btnListener);
        this.addPatientsBtn.setOnClickListener(this.btnListener);
    }
}
