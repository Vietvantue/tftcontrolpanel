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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SelectChannelColorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SelectChannelColorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectChannelColorFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    View mPreviousColor1, mPreviousColor2, mPreviousColor3, mPreviousColor4, mPreviousColor5, mPreviousColor6, mPreviousColor7;
    View mNextColor1, mNextColor2, mNextColor3, mNextColor4, mNextColor5, mNextColor6, mNextColor7;
    TextView mColorText1, mColorText2, mColorText3, mColorText4, mColorText5, mColorText6, mColorText7;
    int[] mSelectedColor = new int[7];

    public SelectChannelColorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectChannelColorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectChannelColorFragment newInstance(String param1, String param2) {
        SelectChannelColorFragment fragment = new SelectChannelColorFragment();
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
        return inflater.inflate(R.layout.fragment_select_channel_color, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mPreviousColor1 = view.findViewById(R.id.btn_left_1);
        mPreviousColor2 = view.findViewById(R.id.btn_left_2);
        mPreviousColor3 = view.findViewById(R.id.btn_left_3);
        mPreviousColor4 = view.findViewById(R.id.btn_left_4);
        mPreviousColor5 = view.findViewById(R.id.btn_left_5);
        mPreviousColor6 = view.findViewById(R.id.btn_left_6);
        mPreviousColor7 = view.findViewById(R.id.btn_left_7);
        mPreviousColor1.setOnClickListener(this);
        mPreviousColor2.setOnClickListener(this);
        mPreviousColor3.setOnClickListener(this);
        mPreviousColor4.setOnClickListener(this);
        mPreviousColor5.setOnClickListener(this);
        mPreviousColor6.setOnClickListener(this);
        mPreviousColor7.setOnClickListener(this);

        mNextColor1 = view.findViewById(R.id.btn_right_1);
        mNextColor2 = view.findViewById(R.id.btn_right_2);
        mNextColor3 = view.findViewById(R.id.btn_right_3);
        mNextColor4 = view.findViewById(R.id.btn_right_4);
        mNextColor5 = view.findViewById(R.id.btn_right_5);
        mNextColor6 = view.findViewById(R.id.btn_right_6);
        mNextColor7 = view.findViewById(R.id.btn_right_7);
        mNextColor1.setOnClickListener(this);
        mNextColor2.setOnClickListener(this);
        mNextColor3.setOnClickListener(this);
        mNextColor4.setOnClickListener(this);
        mNextColor5.setOnClickListener(this);
        mNextColor6.setOnClickListener(this);
        mNextColor7.setOnClickListener(this);

        mColorText1 = (TextView) view.findViewById(R.id.tv_color_1);
        mColorText2 = (TextView) view.findViewById(R.id.tv_color_2);
        mColorText3 = (TextView) view.findViewById(R.id.tv_color_3);
        mColorText4 = (TextView) view.findViewById(R.id.tv_color_4);
        mColorText5 = (TextView) view.findViewById(R.id.tv_color_5);
        mColorText6 = (TextView) view.findViewById(R.id.tv_color_6);
        mColorText7 = (TextView) view.findViewById(R.id.tv_color_7);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_left_1:
                if (mSelectedColor[0] > 0) {
                    mSelectedColor[0] = mSelectedColor[0] - 1;
                }
                mColorText1.setText(ConstantConfig.ColorChannels[mSelectedColor[0]]);
                break;
            case R.id.btn_left_2:
                if (mSelectedColor[1] > 0) {
                    mSelectedColor[1] = mSelectedColor[1] - 1;
                }
                mColorText2.setText(ConstantConfig.ColorChannels[mSelectedColor[1]]);
                break;
            case R.id.btn_left_3:
                if (mSelectedColor[2] > 0) {
                    mSelectedColor[2] = mSelectedColor[2] - 1;
                }
                mColorText3.setText(ConstantConfig.ColorChannels[mSelectedColor[2]]);
                break;
            case R.id.btn_left_4:
                if (mSelectedColor[3] > 0) {
                    mSelectedColor[3] = mSelectedColor[3] - 1;
                }
                mColorText4.setText(ConstantConfig.ColorChannels[mSelectedColor[3]]);
                break;
            case R.id.btn_left_5:
                if (mSelectedColor[4] > 0) {
                    mSelectedColor[4] = mSelectedColor[4] - 1;
                }
                mColorText5.setText(ConstantConfig.ColorChannels[mSelectedColor[4]]);
                break;
            case R.id.btn_left_6:
                if (mSelectedColor[5] > 0) {
                    mSelectedColor[5] = mSelectedColor[5] - 1;
                }
                mColorText6.setText(ConstantConfig.ColorChannels[mSelectedColor[5]]);
                break;
            case R.id.btn_left_7:
                if (mSelectedColor[6] > 0) {
                    mSelectedColor[6] = mSelectedColor[6] - 1;
                }
                mColorText7.setText(ConstantConfig.ColorChannels[mSelectedColor[6]]);
                break;

            case R.id.btn_right_1:
                if (mSelectedColor[0] < ConstantConfig.ColorChannels.length - 1) {
                    mSelectedColor[0] = mSelectedColor[0] + 1;
                }
                mColorText1.setText(ConstantConfig.ColorChannels[mSelectedColor[0]]);
                break;
            case R.id.btn_right_2:
                if (mSelectedColor[1] < ConstantConfig.ColorChannels.length - 1) {
                    mSelectedColor[1] = mSelectedColor[1] + 1;
                }
                mColorText2.setText(ConstantConfig.ColorChannels[mSelectedColor[1]]);
                break;
            case R.id.btn_right_3:
                if (mSelectedColor[2] < ConstantConfig.ColorChannels.length - 1) {
                    mSelectedColor[2] = mSelectedColor[2] + 1;
                }
                mColorText3.setText(ConstantConfig.ColorChannels[mSelectedColor[2]]);
                break;
            case R.id.btn_right_4:
                if (mSelectedColor[3] < ConstantConfig.ColorChannels.length - 1) {
                    mSelectedColor[3] = mSelectedColor[3] + 1;
                }
                mColorText4.setText(ConstantConfig.ColorChannels[mSelectedColor[3]]);
                break;
            case R.id.btn_right_5:
                if (mSelectedColor[4] < ConstantConfig.ColorChannels.length - 1) {
                    mSelectedColor[4] = mSelectedColor[4] + 1;
                }
                mColorText5.setText(ConstantConfig.ColorChannels[mSelectedColor[4]]);
                break;
            case R.id.btn_right_6:
                if (mSelectedColor[5] < ConstantConfig.ColorChannels.length - 1) {
                    mSelectedColor[5] = mSelectedColor[5] + 1;
                }
                mColorText6.setText(ConstantConfig.ColorChannels[mSelectedColor[5]]);
                break;
            case R.id.btn_right_7:
                if (mSelectedColor[6] < ConstantConfig.ColorChannels.length - 1) {
                    mSelectedColor[6] = mSelectedColor[6] + 1;
                }
                mColorText7.setText(ConstantConfig.ColorChannels[mSelectedColor[6]]);
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
