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

import comfabiankockpflegi3000.github.pflegi3000.R;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.MedikamenteFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.PatientFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.PflegeFragment;
import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientFragmente.TerminFragment;
import comfabiankockpflegi3000.github.pflegi3000.android_helper.AndroidHelper;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerMedikamentFragment;
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment;

public class ShowPatientActivity extends AppCompatActivity
        implements PatientFragment.OnFragmentInteractionListener, MedikamenteFragment.OnFragmentInteractionListener,
                    PflegeFragment.OnFragmentInteractionListener, TerminFragment.OnFragmentInteractionListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private int position;

    private ControllerPatientFragment controllerPatientFragment;
    private PatientFragment fPatient;

    private ControllerMedikamentFragment controllerMedikamentFragment;
    private MedikamenteFragment fMedikament;

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
        this.controllerPatientFragment = new ControllerPatientFragment(null, this);
        this.controllerMedikamentFragment = new ControllerMedikamentFragment(null, this);

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
                    controllerPatientFragment.changeTextState();
                }


        }
        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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
                    fPatient = PatientFragment.newInstance(patient_id, controllerPatientFragment);
                    controllerPatientFragment = new ControllerPatientFragment(fPatient, this.sp_activity);
                    return fPatient;

                case 1:
                    fMedikament = MedikamenteFragment.newInstance(patient_id, controllerMedikamentFragment);
                    controllerMedikamentFragment = new ControllerMedikamentFragment(fMedikament, this.sp_activity);
                    return fMedikament;

                case 2:
                    return PflegeFragment.newInstance();

                case 3:
                    return TerminFragment.newInstance("","");

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
