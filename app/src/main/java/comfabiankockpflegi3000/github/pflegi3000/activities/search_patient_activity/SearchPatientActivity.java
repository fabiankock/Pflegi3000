package comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.ControllerSearchPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.search_listener.SearchPatientButtonListener;

public class SearchPatientActivity extends AppCompatActivity{

    private Button backBtn, testShowPatientBtn;
    private SearchView searchView;
    private ListView listView;
    private ControllerSearchPatientActivity controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);
        this.controller = new ControllerSearchPatientActivity(this);

        this.backBtn = (Button) findViewById(R.id.back_button_search_patient);
        this.backBtn.setOnClickListener(this.controller.getButtonListener());

        //this.testShowPatientBtn = (Button) findViewById(R.id.open_showpatients_button);
        //this.testShowPatientBtn.setOnClickListener(this.controller.getButtonListener());

        this.searchView = (SearchView) findViewById(R.id.search_bar_patients);
        this.searchView.setOnQueryTextListener(this.controller.getOnQueryTextListener());

        this.listView = (ListView) findViewById(R.id.listview);
        this.listView.setAdapter(this.controller.getListViewAdapter());
        this.listView.setOnItemClickListener(this.controller.getOnItemClickListener());
    }
}
