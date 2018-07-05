package comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.R;

public class SearchPatientActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private Button backBtn, testShowPatientBtn;
    private SearchView searchView;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
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

        this.searchView = (SearchView) findViewById(R.id.search_bar_patients);
        this.searchView.setOnQueryTextListener(this);
        CharSequence query = this.searchView.getQuery();
        this.listView = (ListView) findViewById(R.id.listview);
        this.listViewAdapter = new ListViewAdapter(this, this.getAllPatientNames());
        this.listView.setAdapter(this.listViewAdapter);
    }

    private ArrayList<PatientNames> getAllPatientNames() {

        PatientNames tmp;
        ArrayList<PatientNames> list = new ArrayList<PatientNames>();

        //send query to database to get all patient names
        /*Cursor c = this.db.getAllPatients();
        if (c.getCount() > 0) {

            while (c.moveToNext()) {

                //save first and last name in tmp and add it to the arrayList
                tmp = new patientNames(c.getString(1) + " " + c.getString(2));
                list.add(tmp);
                Log.d("Search", "add " +tmp.getPatientName());
            }
        } else {
            Log.d("PatientDatabase", "Empty Data");
        }*/
        tmp = new PatientNames("Hans Peter");
        list.add(tmp);
        tmp = new PatientNames("Rafael Hingerl");
        list.add(tmp);
        tmp = new PatientNames("Fabian Kock");
        list.add(tmp);
        tmp = new PatientNames("Hans Peter2");
        list.add(tmp);

        return list;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        this.listViewAdapter.filter(s);

        return false;
    }
}
