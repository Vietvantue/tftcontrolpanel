package com.offspring.tftcontrolpanel.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.offspring.tftcontrolpanel.R;
import com.offspring.tftcontrolpanel.util.ConstantConfig;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SetTimeDateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SetTimeDateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetTimeDateFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    View mPreviousMonth, mPreviousDay, mPreviousYear, mPreviousHour, mPreviousMinute, mPreviousAmPm;
    View mNextMonth, mNextDay, mNextYear, mNextHour, mNextMinute, mNextAmPm;
    TextView mMonthText, mDayText, mYearText, mHourText, mMinuteText, mAmPmText;
    int mSelectedLightOrOther[] = new int[6];

    Calendar mCalendar;

    public SetTimeDateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SetTimeDateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetTimeDateFragment newInstance(String param1, String param2) {
        SetTimeDateFragment fragment = new SetTimeDateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mCalendar = Calendar.getInstance();
        return inflater.inflate(R.layout.fragment_set_time_date, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mPreviousMonth = view.findViewById(R.id.btn_left_month);
        mPreviousDay = view.findViewById(R.id.btn_left_day);
        mPreviousYear = view.findViewById(R.id.btn_left_year);
        mPreviousHour = view.findViewById(R.id.btn_left_hour);
        mPreviousMinute = view.findViewById(R.id.btn_left_minute);
        mPreviousAmPm = view.findViewById(R.id.btn_left_am_pm);

        mPreviousMonth.setOnClickListener(this);
        mPreviousDay.setOnClickListener(this);
        mPreviousYear.setOnClickListener(this);
        mPreviousHour.setOnClickListener(this);
        mPreviousMinute.setOnClickListener(this);
        mPreviousAmPm.setOnClickListener(this);

        mNextMonth = view.findViewById(R.id.btn_right_month);
        mNextDay = view.findViewById(R.id.btn_right_day);
        mNextYear = view.findViewById(R.id.btn_right_year);
        mNextHour = view.findViewById(R.id.btn_right_hour);
        mNextMinute = view.findViewById(R.id.btn_right_minute);
        mNextAmPm = view.findViewById(R.id.btn_right_am_pm);

        mNextMonth.setOnClickListener(this);
        mNextDay.setOnClickListener(this);
        mNextYear.setOnClickListener(this);
        mNextHour.setOnClickListener(this);
        mNextMinute.setOnClickListener(this);
        mNextAmPm.setOnClickListener(this);


        mDayText = (TextView) view.findViewById(R.id.tv_day);
        mMonthText = (TextView) view.findViewById(R.id.tv_month);
        mYearText = (TextView) view.findViewById(R.id.tv_year);
        mMinuteText = (TextView) view.findViewById(R.id.tv_minute);
        mHourText = (TextView) view.findViewById(R.id.tv_hour);
        mAmPmText = (TextView) view.findViewById(R.id.tv_am_pm);

        setDateTime();
    }

    private void setDateTime() {
        mMonthText.setText(new SimpleDateFormat("MMMM").format(mCalendar.getTime()));
        mDayText.setText(String.format("%02d", (mCalendar.get(Calendar.DAY_OF_MONTH))));
        mYearText.setText(String.format("%04d", (mCalendar.get(Calendar.YEAR))));

        mHourText.setText(new SimpleDateFormat("hh").format(mCalendar.getTime()));
        mMinuteText.setText(new SimpleDateFormat("mm").format(mCalendar.getTime()));
        mAmPmText.setText(new SimpleDateFormat("aa").format(mCalendar.getTime()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_left_month:
                mCalendar.add(Calendar.MONTH,-1);
                setDateTime();
                break;
            case R.id.btn_left_day:
                mCalendar.add(Calendar.DAY_OF_MONTH,-1);
                setDateTime();
                break;
            case R.id.btn_left_year:
                mCalendar.add(Calendar.YEAR,-1);
                setDateTime();
                break;
            case R.id.btn_left_hour:
                mCalendar.add(Calendar.HOUR,-1);
                setDateTime();
                break;
            case R.id.btn_left_minute:
                mCalendar.add(Calendar.MINUTE,-1);
                setDateTime();
                break;
            case R.id.btn_left_am_pm:
                if ("AM".equalsIgnoreCase(mAmPmText.getText().toString())) {
                    mAmPmText.setText("PM");
                    mCalendar.set(Calendar.AM_PM,Calendar.PM);
                } else {
                    mAmPmText.setText("AM");
                    mCalendar.set(Calendar.AM_PM,Calendar.AM);
                }
                break;

            case R.id.btn_right_month:
                mCalendar.add(Calendar.MONTH,1);
                setDateTime();
                break;
            case R.id.btn_right_day:
                mCalendar.add(Calendar.DAY_OF_MONTH,1);
                setDateTime();
                break;
            case R.id.btn_right_year:
                mCalendar.add(Calendar.YEAR,1);
                setDateTime();
                break;
            case R.id.btn_right_hour:
                mCalendar.add(Calendar.HOUR,1);
                setDateTime();
                break;
            case R.id.btn_right_minute:
                mCalendar.add(Calendar.MINUTE,1);
                setDateTime();
                break;
            case R.id.btn_right_am_pm:
                if ("AM".equalsIgnoreCase(mAmPmText.getText().toString())) {
                    mAmPmText.setText("PM");
                    mCalendar.set(Calendar.AM_PM,Calendar.PM);
                } else {
                    mAmPmText.setText("AM");
                    mCalendar.set(Calendar.AM_PM,Calendar.AM);
                }
                break;

        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
