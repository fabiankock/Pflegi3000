package comfabiankock.httpsgithub.pflegi3000.feature.patients;

import android.view.View;

import comfabiankock.httpsgithub.pflegi3000.feature.database.database;

public class dropBtnListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

        database db = new database(v.getContext());
        db.dropTable();
    }
}
