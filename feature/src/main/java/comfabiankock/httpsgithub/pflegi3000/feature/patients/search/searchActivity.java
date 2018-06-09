package comfabiankock.httpsgithub.pflegi3000.feature.patients.search;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import comfabiankock.httpsgithub.pflegi3000.feature.R;
import comfabiankock.httpsgithub.pflegi3000.feature.database.database;

public class searchActivity extends ListActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        this.tv = findViewById(R.id.test);
        //this.tv.setText(R.string.insurance_nr_str);

        Log.d("Search","starting Search Activity ");
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            this.doSearch(query);
        }

    }

    private void doSearch(String queryString){

        database db = new database(getApplicationContext());
        Cursor patientCursor = db.doSearch(queryString);
        Log.d("Search","Execute query "+queryString);
        if(patientCursor.getCount() > 0) {

            while(patientCursor.moveToNext()){

                Log.d("Search","Found something by search: " +
                        patientCursor.getString(1)+
                        "\n"+patientCursor.getString(2)+
                        "\n"+patientCursor.getString(3)+
                        "\n");
            }

        }
    }
}
