package comfabiankock.httpsgithub.pflegi3000.feature.patients.search;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import comfabiankock.httpsgithub.pflegi3000.feature.main.MainActivity;
import comfabiankock.httpsgithub.pflegi3000.feature.patients.showPatient.showPatientActivity;

public class searchListViewListener implements AdapterView.OnItemClickListener{

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        patientNames tmp = (patientNames) parent.getItemAtPosition(position);
        Log.d("Search", "clicked on item " + tmp.getPatientName());

        Intent openPatientScreen = new Intent(view.getContext(), showPatientActivity.class);
        openPatientScreen.putExtra("ID",tmp.getPatientName().substring(0,1));
        view.getContext().startActivity(openPatientScreen);
    }
}
