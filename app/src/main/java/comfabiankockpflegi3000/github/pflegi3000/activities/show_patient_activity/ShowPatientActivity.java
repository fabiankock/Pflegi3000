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
import comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerPatientFragment;

public class ShowPatientActivity extends AppCompatActivity
        implements PatientFragment.OnFragmentInteractionListener, MedikamenteFragment.OnFragmentInteractionListener,
                    PflegeFragment.OnFragmentInteractionListener, TerminFragment.OnFragmentInteractionListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private int position;
    private ControllerPatientFragment controllerPatientFragment;
    private PatientFragment fPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient);

        String patient_pos = getIntent().getStringExtra(AndroidHelper.PATIENT_POSITION_EXTRA);
        Log.i("Show", "p_id: " + patient_pos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

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


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // Gibt je nach Position (Leiste oben) das jeweilige Fragment zurück
        @Override
        public Fragment getItem(int position) {

            switch(position) {

                case 0:
                    fPatient = PatientFragment.newInstance();
                    controllerPatientFragment = new ControllerPatientFragment(fPatient);
                    return fPatient;

                case 1:
                    return MedikamenteFragment.newInstance("","");

                case 2:
                    return PflegeFragment.newInstance();

                case 3:
                    return TerminFragment.newInstance("","");

            }
            return null;
        }

        //Anzahl der Tabs
        @Override
        public int getCount() {
            return 4;
        }
    }
}
