package comfabiankock.httpsgithub.pflegi3000.feature.socialEvents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import comfabiankock.httpsgithub.pflegi3000.feature.R;
import comfabiankock.httpsgithub.pflegi3000.feature.main.backBtnListener;

public class eventsActivity extends Activity {

    private TextView screenNameText;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        this.screenNameText = (TextView) findViewById(R.id.screen_name);
        this.screenNameText.setText(R.string.event_str);

        this.backBtn = (Button) findViewById(R.id.back_button);
        this.backBtn.setText(R.string.back_str);
        this.backBtn.setOnClickListener(new backBtnListener());
    }
}
