package comfabiankock.httpsgithub.pflegi3000.feature.database.modifyDatabaseActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import comfabiankock.httpsgithub.pflegi3000.feature.database.database;
import comfabiankock.httpsgithub.pflegi3000.feature.database.insuranceDatabase;
import comfabiankock.httpsgithub.pflegi3000.feature.main.MainActivity;
import comfabiankock.httpsgithub.pflegi3000.feature.patients.addPatient.addPatientActivity;

public class submitBtnListener implements View.OnClickListener{

    private modifyDatabase modifyDatabaseAc;
    private String iType, iName;

    public submitBtnListener(modifyDatabase theActivity){

        this.modifyDatabaseAc = theActivity;
    }

    @Override
    public void onClick(View v) {

        this.iType = this.modifyDatabaseAc.getIType();
        this.iName = this.modifyDatabaseAc.getIName();

        insuranceDatabase insuranceDB = new insuranceDatabase(v.getContext());

        if(insuranceDB.insertInsurance(this.iType,this.iName) == false){
            //failed
        }

        Intent openMainScreen = new Intent(v.getContext(), MainActivity.class);
        v.getContext().startActivity(openMainScreen);
    }
}
