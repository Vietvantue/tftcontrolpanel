package com.offspring.tftcontrolpanel.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.offspring.tftcontrolpanel.R;
import com.offspring.tftcontrolpanel.fragment.DimmerFragment;
import com.offspring.tftcontrolpanel.fragment.PresetFragment;
import com.offspring.tftcontrolpanel.fragment.SettingFragment;
import com.offspring.tftcontrolpanel.fragment.TimerFragment;

import java.util.ArrayList;

public class TabTFTActivity extends AppCompatActivity implements View.OnClickListener {

    PresetFragment mPresetFragment;
    DimmerFragment mDimmerFragment;
    TimerFragment mTimerFragment;
    SettingFragment mSettingFragment;
    android.support.v4.app.Fragment fragments[] = new Fragment[4];
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    ArrayList<View> listBottomBarViews = new ArrayList<>();

    View llPresetBtn,llDimmerBtn,llTimerBtn,llSettingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_tft);

        llPresetBtn = findViewById(R.id.ll_preset_button);
        llDimmerBtn = findViewById(R.id.ll_dimmer_button);
        llTimerBtn = findViewById(R.id.ll_timer_button);
        llSettingBtn = findViewById(R.id.ll_setting_button);

        mPresetFragment = PresetFragment.newInstance("","");
        mDimmerFragment = DimmerFragment.newInstance("","");
        mTimerFragment = TimerFragment.newInstance("","");
        mSettingFragment = SettingFragment.newInstance("","");

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        listBottomBarViews.add(llPresetBtn);
        listBottomBarViews.add(llDimmerBtn);
        listBottomBarViews.add(llTimerBtn);
        listBottomBarViews.add(llSettingBtn);

        for(int i = 0; i < listBottomBarViews.size(); i++ ) {
            listBottomBarViews.get(i).setOnClickListener(this);
        }

        addTabFragment(1);
        addTabFragment(0);

        changeColorIndicator(llPresetBtn,"#53caf5");

    }

    private void addTabFragment(int id) {

        if (fragments[id] == null) {
            switch (id) {
                case 0:
                    fragments[0] = mPresetFragment;
                    break;
                case 1:
                    fragments[1] = mDimmerFragment;
                    break;
                case 2:
                    fragments[2] = mTimerFragment;
                    break;
                case 3:
                    fragments[3] = mSettingFragment;
                    break;
                default:
                    break;
            }
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.v_content, fragments[id]);
            fragmentTransaction.commit();
            fragments[id].setUserVisibleHint(true);
        } else {
            fragmentTransaction = fragmentManager.beginTransaction();
            for (int i = 0; i < 4; i++) {
                if (i == id) {
                    fragmentTransaction.show(fragments[i]);
                    fragments[i].setUserVisibleHint(true);
                } else {
                    if (fragments[i] != null) {
                        fragments[i].setUserVisibleHint(false);
                        fragmentTransaction.hide(fragments[i]);
                    }
                }
            }
            fragmentTransaction.commit();
        }
    }

    private void changeColorIndicator(View v, String color) {
        if (v instanceof ViewGroup) {
            LinearLayout ll = (LinearLayout) v;
            TextView textView = (TextView) ll.getChildAt(0);
            textView.setTextColor(Color.parseColor(color));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_preset_button:
                addTabFragment(0);
                break;
            case R.id.ll_dimmer_button:
                addTabFragment(1);
                break;
            case R.id.ll_timer_button:
                addTabFragment(2);
                break;
            case R.id.ll_setting_button:
                addTabFragment(3);
                break;
        }

        for (int i = 0; i < 4; i++) {
            if (!listBottomBarViews.get(i).equals(view)) {
                changeColorIndicator(listBottomBarViews.get(i), "#000000");
            } else {
                changeColorIndicator(view, "#53caf5");
            }
        }

    }
}
