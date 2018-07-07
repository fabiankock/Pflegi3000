package comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.search_listener;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.HashMap;

import comfabiankockpflegi3000.github.pflegi3000.activities.search_patient_activity.SearchPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;

public class ListViewOnItemClickListener implements AdapterView.OnItemClickListener {

    private SearchPatientActivity theActivity;

    public ListViewOnItemClickListener(SearchPatientActivity activity){

        this.theActivity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        HashMap<String, String> extras = new HashMap<>();
        extras.put(AndroidHelper.PATIENT_POSITION_EXTRA, String.valueOf(i));
        Log.i("Show", "position: " + i);
        AndroidHelper.startNewActivityWithExtras(view.getContext(), ShowPatientActivity.class, extras);
    }
}
