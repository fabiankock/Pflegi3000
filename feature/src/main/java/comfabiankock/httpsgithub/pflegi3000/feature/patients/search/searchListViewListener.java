package comfabiankock.httpsgithub.pflegi3000.feature.patients.search;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import comfabiankock.httpsgithub.pflegi3000.feature.main.MainActivity;

public class searchListViewListener implements AdapterView.OnItemClickListener{

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        patientNames tmp = (patientNames) parent.getItemAtPosition(position);
        Log.d("Search", "clicked on item " + tmp.getPatientName());

        //Intent openPatientScreen = new Intent(view.getContext(), MainActivity.class);
        //v.getContext().startActivity(openPatientScreen);
    }
}
