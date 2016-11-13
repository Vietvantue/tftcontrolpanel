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
import com.offspring.tftcontrolpanel.model.DimmerModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DimmerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DimmerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DimmerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DimmerFragment() {
        // Required empty public constructor
    }

    View btnNextPage, btnPrePage;
    TextView tvUniverseName;
    int currentPage = 0;

    View plus1, plus2, plus3, plus4, plus5, plus6, plus7;
    View minus1, minus2, minus3, minus4, minus5, minus6, minus7;

    TextView tvDimmerValue1, tvDimmerValue2, tvDimmerValue3, tvDimmerValue4, tvDimmerValue5, tvDimmerValue6, tvDimmerValue7;

    final int MAX_DIMMER_PAGE = 255;
    ArrayList<DimmerModel> mListDimmer = new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DimmerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DimmerFragment newInstance(String param1, String param2) {
        DimmerFragment fragment = new DimmerFragment();
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
        return inflater.inflate(R.layout.fragment_dimmer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 0; i < 255; i++) {
            mListDimmer.add(new DimmerModel());
        }

        btnNextPage = view.findViewById(R.id.btn_next_page);
        btnNextPage.setOnClickListener(this);
        btnPrePage = view.findViewById(R.id.btn_previous_page);
        btnPrePage.setOnClickListener(this);

        tvUniverseName = (TextView) view.findViewById(R.id.tv_universe_name);

        initViews(view);
    }

    private void initViews(View view) {
        plus1 = view.findViewById(R.id.plus_1);
        plus2 = view.findViewById(R.id.plus_2);
        plus3 = view.findViewById(R.id.plus_3);
        plus4 = view.findViewById(R.id.plus_4);
        plus5 = view.findViewById(R.id.plus_5);
        plus6 = view.findViewById(R.id.plus_6);
        plus7 = view.findViewById(R.id.plus_7);

        plus1.setOnClickListener(this);
        plus2.setOnClickListener(this);
        plus3.setOnClickListener(this);
        plus4.setOnClickListener(this);
        plus5.setOnClickListener(this);
        plus6.setOnClickListener(this);
        plus7.setOnClickListener(this);

        minus1 = view.findViewById(R.id.minus_1);
        minus2 = view.findViewById(R.id.minus_2);
        minus3 = view.findViewById(R.id.minus_3);
        minus4 = view.findViewById(R.id.minus_4);
        minus5 = view.findViewById(R.id.minus_5);
        minus6 = view.findViewById(R.id.minus_6);
        minus7 = view.findViewById(R.id.minus_7);

        minus1.setOnClickListener(this);
        minus2.setOnClickListener(this);
        minus3.setOnClickListener(this);
        minus4.setOnClickListener(this);
        minus5.setOnClickListener(this);
        minus6.setOnClickListener(this);
        minus7.setOnClickListener(this);

        tvDimmerValue1 = (TextView) view.findViewById(R.id.tv_value_1);
        tvDimmerValue2 = (TextView) view.findViewById(R.id.tv_value_2);
        tvDimmerValue3 = (TextView) view.findViewById(R.id.tv_value_3);
        tvDimmerValue4 = (TextView) view.findViewById(R.id.tv_value_4);
        tvDimmerValue5 = (TextView) view.findViewById(R.id.tv_value_5);
        tvDimmerValue6 = (TextView) view.findViewById(R.id.tv_value_6);
        tvDimmerValue7 = (TextView) view.findViewById(R.id.tv_value_7);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next_page:
                if (currentPage >= MAX_DIMMER_PAGE - 1)
                    return;
                bindDataToPage(++currentPage);
                break;
            case R.id.btn_previous_page:
                if (currentPage <= 0)
                    return;
                bindDataToPage(--currentPage);
                break;
            case R.id.plus_1:
                plusDimmer(currentPage,0,tvDimmerValue1);
                break;
            case R.id.plus_2:
                plusDimmer(currentPage,1,tvDimmerValue2);
                break;
            case R.id.plus_3:
                plusDimmer(currentPage,2,tvDimmerValue3);
                break;
            case R.id.plus_4:
                plusDimmer(currentPage,3,tvDimmerValue4);
                break;
            case R.id.plus_5:
                plusDimmer(currentPage,4,tvDimmerValue5);
                break;
            case R.id.plus_6:
                plusDimmer(currentPage,5,tvDimmerValue6);
                break;
            case R.id.plus_7:
                plusDimmer(currentPage,6,tvDimmerValue7);
                break;
            case R.id.minus_1:
                minusDimmer(currentPage,0,tvDimmerValue1);
                break;
            case R.id.minus_2:
                minusDimmer(currentPage,1,tvDimmerValue2);
                break;
            case R.id.minus_3:
                minusDimmer(currentPage,2,tvDimmerValue3);
                break;
            case R.id.minus_4:
                minusDimmer(currentPage,3,tvDimmerValue4);
                break;
            case R.id.minus_5:
                minusDimmer(currentPage,4,tvDimmerValue5);
                break;
            case R.id.minus_6:
                minusDimmer(currentPage,5,tvDimmerValue6);
                break;
            case R.id.minus_7:
                minusDimmer(currentPage,6,tvDimmerValue7);
                break;
        }
    }

    private void bindDataToPage(int page) {
        tvUniverseName.setText("Universe " + (page + 1));
        tvDimmerValue1.setText(mListDimmer.get(page).dimmer[0]+"");
        tvDimmerValue2.setText(mListDimmer.get(page).dimmer[1]+"");
        tvDimmerValue3.setText(mListDimmer.get(page).dimmer[2]+"");
        tvDimmerValue4.setText(mListDimmer.get(page).dimmer[3]+"");
        tvDimmerValue5.setText(mListDimmer.get(page).dimmer[4]+"");
        tvDimmerValue6.setText(mListDimmer.get(page).dimmer[5]+"");
        tvDimmerValue7.setText(mListDimmer.get(page).dimmer[6]+"");
    }

    private void plusDimmer(int page,int pos,TextView textView) {
        if(mListDimmer.get(page).dimmer[pos] >= 255)
            return;
        mListDimmer.get(page).dimmer[pos]++;
        textView.setText(mListDimmer.get(page).dimmer[pos]+"");
    }

    private void minusDimmer(int page,int pos,TextView textView) {
        if(mListDimmer.get(page).dimmer[pos] <= 0)
            return;
        mListDimmer.get(page).dimmer[pos]--;
        textView.setText(mListDimmer.get(page).dimmer[pos]+"");
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
