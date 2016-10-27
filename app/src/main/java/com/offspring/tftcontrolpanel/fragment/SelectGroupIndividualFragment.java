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
 * {@link SelectGroupIndividualFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SelectGroupIndividualFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectGroupIndividualFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    View btnPrevios, btnNext;
    TextView mNumberChannelText;
    int mSelectdNumChannel = 0;

    public SelectGroupIndividualFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectGroupIndividualFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectGroupIndividualFragment newInstance(String param1, String param2) {
        SelectGroupIndividualFragment fragment = new SelectGroupIndividualFragment();
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
        return inflater.inflate(R.layout.fragment_select_group_individual, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNext = view.findViewById(R.id.btn_right);
        btnPrevios = view.findViewById(R.id.btn_left);
        btnNext.setOnClickListener(this);
        btnPrevios.setOnClickListener(this);

        mNumberChannelText = (TextView) view.findViewById(R.id.tv_fixture);
        mNumberChannelText.setText(ConstantConfig.FixtureType[mSelectdNumChannel]);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                if (mSelectdNumChannel > 0) {
                    mSelectdNumChannel = mSelectdNumChannel - 1;
                } else if(mSelectdNumChannel == 0) {
                    mSelectdNumChannel = ConstantConfig.FixtureType.length - 1;
                }
                mNumberChannelText.setText(ConstantConfig.FixtureType[mSelectdNumChannel]);
                break;
            case R.id.btn_right:
                mSelectdNumChannel = (mSelectdNumChannel + 1) % ConstantConfig.FixtureType.length;
                mNumberChannelText.setText(ConstantConfig.FixtureType[mSelectdNumChannel]);
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
