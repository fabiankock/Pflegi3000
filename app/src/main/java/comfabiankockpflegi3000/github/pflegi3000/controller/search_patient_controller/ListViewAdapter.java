package comfabiankockpflegi3000.github.pflegi3000.controller.search_patient_controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.PatientEntity;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<PatientEntity> patientNamesList = null;
    private ArrayList<PatientEntity> arraylist;

    public ListViewAdapter(Context context, List<PatientEntity> patientList) {
        mContext = context;
        this.patientNamesList = patientList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<PatientEntity>();
        this.arraylist.addAll(this.patientNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return this.patientNamesList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.patientNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(patientNamesList.get(position).getFirstname() + " " + patientNamesList.get(position).getLastname());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        this.patientNamesList.clear();
        //If search string is empty display all values
        if (charText.length() == 0) {
            this.patientNamesList.addAll(arraylist);
        } else {
            //Check if patient Names contains the search string
            for (PatientEntity wp : arraylist) {
                if (wp.getLastname().toLowerCase(Locale.getDefault()).contains(charText) || wp.getFirstname().toLowerCase(Locale.getDefault()).contains(charText)) {
                    this.patientNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
