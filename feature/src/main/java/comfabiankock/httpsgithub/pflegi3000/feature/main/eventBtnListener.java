package comfabiankock.httpsgithub.pflegi3000.feature.main;

import android.content.Intent;
import android.view.View;

import comfabiankock.httpsgithub.pflegi3000.feature.socialEvents.eventsActivity;

public class eventBtnListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

        Intent openEventScreen = new Intent(v.getContext(), eventsActivity.class);
        v.getContext().startActivity(openEventScreen);
    }
}
