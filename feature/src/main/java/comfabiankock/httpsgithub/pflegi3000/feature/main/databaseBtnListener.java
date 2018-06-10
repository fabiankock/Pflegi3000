package comfabiankock.httpsgithub.pflegi3000.feature.main;

import android.content.Intent;
import android.view.View;

import comfabiankock.httpsgithub.pflegi3000.feature.database.modifyDatabaseActivity.modifyDatabase;
import comfabiankock.httpsgithub.pflegi3000.feature.socialEvents.eventsActivity;

public class databaseBtnListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

        Intent openDatabaseScreen = new Intent(v.getContext(), modifyDatabase.class);
        v.getContext().startActivity(openDatabaseScreen);
    }
}
