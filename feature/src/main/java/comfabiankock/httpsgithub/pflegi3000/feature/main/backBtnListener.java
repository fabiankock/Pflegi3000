package comfabiankock.httpsgithub.pflegi3000.feature.main;

import android.content.Intent;
import android.view.View;

public class backBtnListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

        Intent openMainScreen = new Intent(v.getContext(), MainActivity.class);
        v.getContext().startActivity(openMainScreen);
    }
}
