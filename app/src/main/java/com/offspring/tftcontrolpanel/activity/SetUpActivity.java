package com.offspring.tftcontrolpanel.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.offspring.tftcontrolpanel.R;
import com.offspring.tftcontrolpanel.fragment.SelectChannelColorFragment;
import com.offspring.tftcontrolpanel.fragment.SelectChannelCountFragment;
import com.offspring.tftcontrolpanel.fragment.SelectGroupIndividualFragment;
import com.offspring.tftcontrolpanel.fragment.SelectLightOtherFragment;
import com.offspring.tftcontrolpanel.fragment.SetTimeDateFragment;
import com.offspring.tftcontrolpanel.persistence.Preferences;

public class SetUpActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private View previousPageBtn, nextPageBtn;
    private TextView mSetUpTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mSetUpTitle.setText(getResources().getString(R.string.string_select_channel_color));
                        break;
                    case 1:
                        mSetUpTitle.setText(getResources().getString(R.string.string_select_date_time));
                        break;
                    case 2:
                        mSetUpTitle.setText(getResources().getString(R.string.string_select_light_other));
                        break;
                    case 3:
                        mSetUpTitle.setText(getResources().getString(R.string.string_select_channel_count));
                        break;
                    case 4:
                        mSetUpTitle.setText(getResources().getString(R.string.string_select_group_individual));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mSetUpTitle = (TextView) findViewById(R.id.tv_set_up_title);
        previousPageBtn = findViewById(R.id.btn_previous_page);
        nextPageBtn = findViewById(R.id.btn_next_page);
        previousPageBtn.setOnClickListener(this);
        nextPageBtn.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_previous_page:
                if (mViewPager.getCurrentItem() > 0) {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
                }
                break;
            case R.id.btn_next_page:
                if (mViewPager.getCurrentItem() < mSectionsPagerAdapter.getCount() - 1) {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                } else if (mViewPager.getCurrentItem() == mSectionsPagerAdapter.getCount() - 1) {
                    Preferences preferences = Preferences.getInstance(SetUpActivity.this);
                    preferences.setHasSetUp(true);
                    Intent intent = new Intent(SetUpActivity.this, TabTFTActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_set_up, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return SelectChannelColorFragment.newInstance("", "");
                case 1:
                    return SetTimeDateFragment.newInstance("", "");
                case 2:
                    return SelectLightOtherFragment.newInstance("", "");
                case 3:
                    return SelectChannelCountFragment.newInstance("", "");
                case 4:
                    return SelectGroupIndividualFragment.newInstance("", "");
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
