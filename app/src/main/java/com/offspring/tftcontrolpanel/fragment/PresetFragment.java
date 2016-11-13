package com.offspring.tftcontrolpanel.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.ToggleButton;

import com.offspring.tftcontrolpanel.R;
import com.offspring.tftcontrolpanel.model.Preset;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PresetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PresetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PresetFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Preset> mListPreset = new ArrayList<>();
    int currentPage = 0;

    View nextPage, previousPage;
    ToggleButton toggleButton1, toggleButton2, toggleButton3, toggleButton4, toggleButton5, toggleButton6, toggleButton7, toggleButton8;

    private OnFragmentInteractionListener mListener;

    public PresetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PresetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PresetFragment newInstance(String param1, String param2) {
        PresetFragment fragment = new PresetFragment();
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
        return inflater.inflate(R.layout.fragment_preset_v2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 0; i < 80; i++) {
            mListPreset.add(new Preset());
        }

        nextPage = view.findViewById(R.id.btn_next_page_preset);
        nextPage.setOnClickListener(this);
        previousPage = view.findViewById(R.id.btn_previous_page_preset);
        previousPage.setOnClickListener(this);
        toggleButton1 = (ToggleButton) view.findViewById(R.id.toggleButton1);
        toggleButton1.setOnClickListener(this);

        toggleButton2 = (ToggleButton) view.findViewById(R.id.toggleButton2);
        toggleButton2.setOnClickListener(this);

        toggleButton3 = (ToggleButton) view.findViewById(R.id.toggleButton3);
        toggleButton3.setOnClickListener(this);

        toggleButton4 = (ToggleButton) view.findViewById(R.id.toggleButton4);
        toggleButton4.setOnClickListener(this);

        toggleButton5 = (ToggleButton) view.findViewById(R.id.toggleButton5);
        toggleButton5.setOnClickListener(this);

        toggleButton6 = (ToggleButton) view.findViewById(R.id.toggleButton6);
        toggleButton6.setOnClickListener(this);

        toggleButton7 = (ToggleButton) view.findViewById(R.id.toggleButton7);
        toggleButton7.setOnClickListener(this);

        toggleButton8 = (ToggleButton) view.findViewById(R.id.toggleButton8);
        toggleButton8.setOnClickListener(this);

        bindPresetToView(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next_page_preset:
                if (currentPage >= 9)
                    return;
                currentPage = currentPage + 1;
                bindPresetToView(currentPage);
                break;
            case R.id.btn_previous_page_preset:
                if (currentPage <= 0)
                    return;
                currentPage = currentPage - 1;
                bindPresetToView(currentPage);
                break;
            case R.id.toggleButton1:
                mListPreset.get(currentPage * 8 + 0).enable = !mListPreset.get(currentPage * 8 + 0).enable;
                break;
            case R.id.toggleButton2:
                mListPreset.get(currentPage * 8 + 1).enable = !mListPreset.get(currentPage * 8 + 1).enable;
                break;
            case R.id.toggleButton3:
                mListPreset.get(currentPage * 8 + 2).enable = !mListPreset.get(currentPage * 8 + 2).enable;
                break;
            case R.id.toggleButton4:
                mListPreset.get(currentPage * 8 + 3).enable = !mListPreset.get(currentPage * 8 + 3).enable;
                break;
            case R.id.toggleButton5:
                mListPreset.get(currentPage * 8 + 4).enable = !mListPreset.get(currentPage * 8 + 4).enable;
                break;
            case R.id.toggleButton6:
                mListPreset.get(currentPage * 8 + 5).enable = !mListPreset.get(currentPage * 8 + 5).enable;
                break;
            case R.id.toggleButton7:
                mListPreset.get(currentPage * 8 + 6).enable = !mListPreset.get(currentPage * 8 + 6).enable;
                break;
            case R.id.toggleButton8:
                mListPreset.get(currentPage * 8 + 7).enable = !mListPreset.get(currentPage * 8 + 7).enable;
                break;
        }
    }

    private void bindPresetToView(int page) {
        toggleButton1.setChecked(mListPreset.get(page * 8 + 0).enable);
        toggleButton1.setTextOn("Preset " + (page * 8 + 1));
        toggleButton1.setTextOff("Preset " + (page * 8 + 1));

        toggleButton2.setChecked(mListPreset.get(page * 8 + 1).enable);
        toggleButton2.setTextOn("Preset " + (page * 8 + 2));
        toggleButton2.setTextOff("Preset " + (page * 8 + 2));

        toggleButton3.setChecked(mListPreset.get(page * 8 + 2).enable);
        toggleButton3.setTextOn("Preset " + (page * 8 + 3));
        toggleButton3.setTextOff("Preset " + (page * 8 + 3));

        toggleButton4.setChecked(mListPreset.get(page * 8 + 3).enable);
        toggleButton4.setTextOn("Preset " + (page * 8 + 4));
        toggleButton4.setTextOff("Preset " + (page * 8 + 4));

        toggleButton5.setChecked(mListPreset.get(page * 8 + 4).enable);
        toggleButton5.setTextOn("Preset " + (page * 8 + 5));
        toggleButton5.setTextOff("Preset " + (page * 8 + 5));

        toggleButton6.setChecked(mListPreset.get(page * 8 + 5).enable);
        toggleButton6.setTextOn("Preset " + (page * 8 + 6));
        toggleButton6.setTextOff("Preset " + (page * 8 + 6));

        toggleButton7.setChecked(mListPreset.get(page * 8 + 6).enable);
        toggleButton7.setTextOn("Preset " + (page * 8 + 7));
        toggleButton7.setTextOff("Preset " + (page * 8 + 7));

        toggleButton8.setChecked(mListPreset.get(page * 8 + 7).enable);
        toggleButton8.setTextOn("Preset " + (page * 8 + 8));
        toggleButton8.setTextOff("Preset " + (page * 8 + 8));
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

    private void setBackgroundColor(View view, String color) {
        Drawable background = view.getBackground();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(Color.parseColor(color));
        }
    }
}
