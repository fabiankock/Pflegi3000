package comfabiankockpflegi3000.github.pflegi3000.android_helper;

import android.content.Context;
import android.content.Intent;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AndroidHelper {

    public static final String PATIENT_POSITION_EXTRA="patient_pos";

    public static void startNewActivity(Context theContext, Class newActivity){

        Intent intent = new Intent(theContext, newActivity);
        theContext.startActivity(intent);
    }

    public static void startNewActivityWithExtras(Context theContext, Class newActivity, HashMap<String, String> extraMap){

        Intent intent = new Intent(theContext, newActivity);
        String tmp_key;
        Object[] keys = extraMap.keySet().toArray();
        for(int i = 0; i < extraMap.size(); i++){

            intent.putExtra(keys[i].toString(),extraMap.get(keys[i]));
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        theContext.startActivity(intent);
    }
}
