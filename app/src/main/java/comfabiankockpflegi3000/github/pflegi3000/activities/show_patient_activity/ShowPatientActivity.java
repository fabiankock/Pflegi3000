package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.controller.ControllerShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;

import static android.view.View.VISIBLE;

public class ShowPatientActivity extends AppCompatActivity {

    private Button backBtn;
    private EditText firstNameText, lastNameText;
    private TextView firstNameView, lastNameView;
    private Toolbar theToolbar;
    private ShowPatientButtonListener btnListener;
    private ControllerShowPatientActivity controller;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.show_patient_bar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient);

        controller = new ControllerShowPatientActivity(this);

        this.btnListener = new ShowPatientButtonListener();
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


        firstNameView = (TextView) findViewById(R.id.view_firstname);
        firstNameView.setText("HansPeter");
        lastNameView = (TextView) findViewById(R.id.view_lastname);
        lastNameView.setText("Wurst");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.action_enable_editable:
                Log.d("Test", "this is a test");
                if (firstNameView.getVisibility() == View.VISIBLE) {
                    controller.ViewToEdit();
                } else {
                    controller.EditToView();
                }
                return true;
        }
        return false;
    }

    /*---------getter---------*/
    public EditText getFirstNameText() {
        return firstNameText;
    }
    public EditText getLastNameText() {
        return lastNameText;
    }
    public TextView getFirstNameView() {
        return firstNameView;
    }
    public TextView getLastNameView() {
        return lastNameView;
    }
}
