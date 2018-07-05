package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j256.ormlite.dao.Dao;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.ControllerShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;

public class ShowPatientActivity extends AppCompatActivity {

    private Button backBtn;
    private EditText firstNameText, lastNameText;
    private Toolbar theToolbar;
    private ShowPatientButtonListener btnListener;
    private ControllerShowPatientActivity controller;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.show_patient_bar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient);

        controller = new ControllerShowPatientActivity(this);

        this.btnListener = new ShowPatientButtonListener(controller);
        this.backBtn = (Button) findViewById(R.id.back_button_show_patientActivity);
        this.backBtn.setOnClickListener(this.btnListener);

        this.theToolbar = (Toolbar) findViewById(R.id.show_patient_toolbar);
        this.theToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        this.theToolbar.setTitleTextColor(Color.WHITE);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(this.theToolbar);

        firstNameText = (EditText) findViewById(R.id.text_firstname);
        firstNameText.setText("HansPeter");
        lastNameText = (EditText) findViewById(R.id.text_lastname);
        lastNameText.setText("Wurst");




    }

    public EditText getFirstNameText() {
        return firstNameText;
    }

    public EditText getLastNameText() {
        return lastNameText;
    }
}
