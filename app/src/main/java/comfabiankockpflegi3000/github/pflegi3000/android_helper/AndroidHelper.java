package comfabiankockpflegi3000.github.pflegi3000.android_helper;

import android.content.Context;
import android.content.Intent;

public class AndroidHelper {

    public static void startNewActivity(Context theContext, Class newActivity){

        Intent intent = new Intent(theContext, newActivity);
        theContext.startActivity(intent);
    }
}
