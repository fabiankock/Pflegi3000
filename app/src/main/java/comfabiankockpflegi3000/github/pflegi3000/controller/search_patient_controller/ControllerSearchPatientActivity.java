package comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller;

import android.util.Log;
import android.widget.SearchView;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity.SearchPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.search_listener.SearchPatientButtonListener;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class ControllerSearchPatientActivity implements SearchView.OnQueryTextListener{

    private ListViewAdapter listViewAdapter;
    private SearchPatientButtonListener btnListener;
    private DaoFactory daofactory;

    public ControllerSearchPatientActivity(SearchPatientActivity a){

        this.daofactory = (DaoFactory) a.getApplication();
        this.listViewAdapter = new ListViewAdapter(a.getApplicationContext(), this.getAllPatientNames());
        this.btnListener = new SearchPatientButtonListener();
    }

    public ArrayList<PatientNames> getAllPatientNames() {

        PatientNames tmp;
        ArrayList<PatientNames> list = new ArrayList<PatientNames>();

        try{
            Dao<PatientEntity, Integer> pDao = daofactory.getPatientDAO();

            List<PatientEntity> allPatientEntities = pDao.queryForAll();
            for(int i = 0; i < allPatientEntities.size(); i++){

                tmp = new PatientNames(allPatientEntities.get(i).getFirstname() + " " + allPatientEntities.get(i).getLastname());
                list.add(tmp);
                Log.d("Search", "add " +tmp.getPatientName());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public ListViewAdapter getListViewAdapter() {

        return this.listViewAdapter;
    }

    public SearchPatientButtonListener getButtonListener() {

        return btnListener;
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
