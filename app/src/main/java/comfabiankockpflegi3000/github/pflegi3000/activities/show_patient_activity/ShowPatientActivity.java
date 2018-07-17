package comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.sql.SQLException;
import java.util.Date;

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.AppointmentFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.MedikamenteFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.PatientFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.CareFragment;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerCareFragment.ControllerCareFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.MedikamentFragment.ControllerMedikamentFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerAppointmentFragment.ControllerAppointmentFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment.ControllerPatientFragment;

public class ShowPatientActivity extends AppCompatActivity
        implements PatientFragment.OnFragmentInteractionListener, MedikamenteFragment.OnFragmentInteractionListener,
                    CareFragment.OnFragmentInteractionListener, AppointmentFragment.OnFragmentInteractionListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private int position;

    private ControllerPatientFragment controllerPatientFragment;
    private PatientFragment fPatient;

    private ControllerMedikamentFragment controllerMedikamentFragment;
    private MedikamenteFragment fMedikament;

    private ControllerAppointmentFragment controllerAppointmentFragment;
    private AppointmentFragment fAppointment;

    private ControllerCareFragment controllerCareFragment;
    private CareFragment fCare;

    private int patient_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient);

        String patient_id_str = getIntent().getStringExtra(AndroidHelper.PATIENT_POSITION_EXTRA);
        this.patient_id = Integer.parseInt(patient_id_str);
        Log.i("Show", "p_id: " + this.patient_id);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Controller für die einzelnen Fragmente!
        this.controllerPatientFragment = new ControllerPatientFragment(null, this, this.patient_id);
        this.controllerMedikamentFragment = new ControllerMedikamentFragment(null, this);
        this.controllerAppointmentFragment = new ControllerAppointmentFragment(this);
        this.controllerCareFragment = new ControllerCareFragment(this.patient_id, this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), this);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.show_patient_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.action_enable_editable:
                if (position == 0) {
                    try {
                        if(this.fPatient.isEditActive()){
                            this.controllerPatientFragment.updatePatient(this.patient_id);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    controllerPatientFragment.switchView();
                }


        }
        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void moveToDateAppointment(Date date){

        this.fAppointment.moveToDate(date);
    }

    public MedikamenteFragment getfMedikament() {
        return fMedikament;
    }
    public AppointmentFragment getfAppointment() {
        return fAppointment;
    }
    public CareFragment getfCare() { return fCare; }

    public PatientFragment getfPatient() {
        return fPatient;
    }

    public int getPatient_id() {
        return patient_id;
    }

    //verantwortlich für die einzelnen Fragmente bzw. Seiten
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private ShowPatientActivity sp_activity;

        public SectionsPagerAdapter(FragmentManager fm, ShowPatientActivity a) {
            super(fm);
            this.sp_activity = a;
        }

        // Gibt je nach Position (Leiste oben) das jeweilige Fragment zurück
        // erstellt einen neuen Controller mit den jeweiligen Frgamenten als parameter
        @Override
        public Fragment getItem(int position) {

            switch(position) {

                case 0:
                    fPatient = PatientFragment.newInstance(patient_id, controllerPatientFragment, sp_activity);
                    controllerPatientFragment = new ControllerPatientFragment(fPatient, this.sp_activity, patient_id);
                    return fPatient;

                case 1:
                    fMedikament = MedikamenteFragment.newInstance(patient_id, controllerMedikamentFragment);
                    controllerMedikamentFragment = new ControllerMedikamentFragment(fMedikament, this.sp_activity);
                    return fMedikament;

                case 2:
                    fCare = CareFragment.newInstance(patient_id, controllerCareFragment);
                    controllerCareFragment = new ControllerCareFragment(patient_id, this.sp_activity);
                    return fCare;

                case 3:
                    fAppointment = AppointmentFragment.newInstance(patient_id, controllerAppointmentFragment);
                    controllerAppointmentFragment = new ControllerAppointmentFragment(this.sp_activity);
                    return fAppointment;

            }
            return null;
        }

        //gibt Anzahl der Tabs zurück
        @Override
        public int getCount() {
            return 4;
        }

    }
}
