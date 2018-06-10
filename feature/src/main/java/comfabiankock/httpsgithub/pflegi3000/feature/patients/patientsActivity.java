package comfabiankock.httpsgithub.pflegi3000.feature.patients;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comfabiankock.httpsgithub.pflegi3000.feature.R;
import comfabiankock.httpsgithub.pflegi3000.feature.database.database;
import comfabiankock.httpsgithub.pflegi3000.feature.main.backBtnListener;
import comfabiankock.httpsgithub.pflegi3000.feature.patients.search.listViewAdapter;
import comfabiankock.httpsgithub.pflegi3000.feature.patients.search.patientNames;
import comfabiankock.httpsgithub.pflegi3000.feature.patients.search.searchListViewListener;

public class patientsActivity extends Activity implements SearchView.OnQueryTextListener {

    private TextView screenNameText, outputFirstNameTxt, outputLastNameTxt, outputInsuranceNrTxt;
    private ListView list;
    private SearchView searchView;
    private listViewAdapter adapter;
    private Button backBtn, dropBtn;
    private database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Cursor patientCursor;

        this.db = new database(this.getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        Log.d("Search", "Start patients activity");

        this.screenNameText = (TextView) findViewById(R.id.screen_name);
        this.screenNameText.setText(R.string.patient_str);

        this.backBtn = (Button) findViewById(R.id.back_button);
        this.backBtn.setText(R.string.back_str);
        this.backBtn.setOnClickListener(new backBtnListener());

        this.dropBtn = (Button) findViewById(R.id.drop_button);
        this.dropBtn.setText(R.string.drop_str);
        this.dropBtn.setOnClickListener(new dropBtnListener());

        //get value of searchbox and display relevant search results in the ListView via adapter
        this.searchView = (SearchView) findViewById(R.id.search_box);
        CharSequence query = this.searchView.getQuery();

        this.list = (ListView) findViewById(R.id.listview);
        this.adapter = new listViewAdapter(this, this.getAllPatientNames());
        this.list.setAdapter(this.adapter);
        this.list.setOnItemClickListener(new searchListViewListener());

        this.searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        adapter.filter(newText);

        return false;
    }

    private ArrayList<patientNames> getAllPatientNames() {

        patientNames tmp;
        ArrayList<patientNames> list = new ArrayList<patientNames>();

        Cursor c = this.db.getAllPatients();
        if (c.getCount() > 0) {

            while (c.moveToNext()) {

                //save first and last name in tmp and add it to the arrayList
                tmp = new patientNames(c.getString(1) + " " + c.getString(2));
                list.add(tmp);
                Log.d("Search", "add " +tmp.getPatientName());
            }
        } else {
            Log.d("PatientDatabase", "Empty Data");
        }

        return list;
    }
}
