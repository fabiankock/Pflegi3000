package comfabiankock.httpsgithub.pflegi3000.feature.patients.addPatient;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public class insuranceSpinnerListener implements AdapterView.OnItemSelectedListener {

    private addPatientActivity addActivity;

    public insuranceSpinnerListener(addPatientActivity ac){
        this.addActivity = ac;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String selected = (String)parent.getItemAtPosition(position);
        Log.d("Insurance","selected Insurance "+selected);
        String insuranceIDstr = selected.substring(0,1);
        Log.d("Insurance", "id:" + insuranceIDstr);
        int iId = Integer.parseInt(insuranceIDstr);
        this.addActivity.setInsuranceID(iId);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
