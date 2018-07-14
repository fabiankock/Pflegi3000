package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.MedikamentEntity;


public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<MedikamentEntity> medication;

    public ListViewAdapter (Context c, List<MedikamentEntity> mediaction) {
        this.context = c;
        this.medication = mediaction;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_medication, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.box = (CheckBox) view.findViewById(R.id.box);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(medication.get(position).getMName() + "\n" + "Dosierung: " + medication.get(position).getMDose() + "mg");
        if (medication.get(position).getGenommen() == true) {
            holder.box.setChecked(true);
        } else {
            holder.box.setChecked(false);
        }

        Log.i("medicationinView",medication.get(position).getMName() + "\n" + "Dosierung: " + medication.get(position).getMDose() + "mg");

        return view;
    }

    public class ViewHolder {
        TextView name;
        CheckBox box;
    }


    @Override
    public int getCount() {
        return this.medication.size();
    }

    @Override
    public Object getItem(int i) {
        return this.medication.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
