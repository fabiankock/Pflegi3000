package comfabiankock.httpsgithub.pflegi3000.feature.database.modifyDatabaseActivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import comfabiankock.httpsgithub.pflegi3000.feature.R;
import comfabiankock.httpsgithub.pflegi3000.feature.database.insuranceDatabase;

public class modifyDatabase extends Activity {

    private EditText iTypeTxt, iNameTxt;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_database);

        this.iTypeTxt = (EditText) findViewById(R.id.iType_edit_text);
        this.iNameTxt = (EditText) findViewById(R.id.iName_edit_text);
        this.submitBtn = (Button) findViewById(R.id.submit_button);
        this.submitBtn.setText("Speichern");
        this.submitBtn.setOnClickListener(new submitBtnListener(this));
    }

    public String getIType(){

        return this.iTypeTxt.getText().toString();
    }

    public String getIName(){

        return this.iNameTxt.getText().toString();
    }
}
