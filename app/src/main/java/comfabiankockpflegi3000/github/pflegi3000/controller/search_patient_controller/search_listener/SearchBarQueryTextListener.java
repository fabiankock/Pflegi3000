package comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.search_listener;

import android.widget.SearchView;

import comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller.ListViewAdapter;

public class SearchBarQueryTextListener implements SearchView.OnQueryTextListener {

    private ListViewAdapter listViewAdapter;

    public SearchBarQueryTextListener(ListViewAdapter lva){

        this.listViewAdapter = lva;
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
