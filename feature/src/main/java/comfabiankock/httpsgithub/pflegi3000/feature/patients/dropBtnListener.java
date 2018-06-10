package comfabiankock.httpsgithub.pflegi3000.feature.patients;

import android.view.View;

import comfabiankock.httpsgithub.pflegi3000.feature.database.database;
import comfabiankock.httpsgithub.pflegi3000.feature.database.insuranceDatabase;

public class dropBtnListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

        database db = new database(v.getContext());
        db.dropTable();

        insuranceDatabase inDB = new insuranceDatabase(v.getContext());
        inDB.dropTable();
    }
}
