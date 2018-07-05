package comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller;

import android.widget.SearchView;

import java.util.ArrayList;

import comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity.SearchPatientActivity;

public class ControllerSearchPatientActivity implements SearchView.OnQueryTextListener{

    private ListViewAdapter listViewAdapter;

    public ControllerSearchPatientActivity(SearchPatientActivity a){

        this.listViewAdapter = new ListViewAdapter(a.getApplicationContext(), this.getAllPatientNames());
    }

    public void processInput(String s){

    }

    public ArrayList<PatientNames> getAllPatientNames() {

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

    public ListViewAdapter getListViewAdapter() {

        return this.listViewAdapter;
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
