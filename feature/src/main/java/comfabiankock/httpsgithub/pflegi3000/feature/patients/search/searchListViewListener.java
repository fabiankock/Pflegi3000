package comfabiankock.httpsgithub.pflegi3000.feature.patients.search;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public class searchListViewListener implements AdapterView.OnItemClickListener{

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        patientNames tmp = (patientNames) parent.getItemAtPosition(position);
        Log.d("Search", "clicked on item " + tmp.getPatientName());
    }
}
