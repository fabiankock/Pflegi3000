package comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.search_listener;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.PatientNames;

public class SearchListOnItemClickListener implements AdapterView.OnItemClickListener{

    public SearchListOnItemClickListener(){

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        PatientNames tmp = (PatientNames) adapterView.getItemAtPosition(i);
        Log.d("Search", "clicked on item " + tmp.getPatientName());

        //Start show patient activity with an extra that can resolve the clicked patient
        /*Intent openPatientScreen = new Intent(view.getContext(), showPatientActivity.class);
        openPatientScreen.putExtra("ID",tmp.getPatientName().substring(0,1));
        view.getContext().startActivity(openPatientScreen);*/
    }
}
