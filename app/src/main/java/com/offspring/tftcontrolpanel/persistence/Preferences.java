package com.offspring.tftcontrolpanel.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by laptop88 on 10/26/2016.
 */

public class Preferences {

    private static final String tag = Preferences.class.getSimpleName();

    private Context mContext;
    private SharedPreferences prefs;
    private static Preferences m_spInstance;

    private static final String PREFERENCE_CHANNEL_COLOR = "channel_color";
    private static final String PREFERENCE_HAS_SETUP = "has_set_up";


    private Preferences(Context context) {
        mContext = context;
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(mContext.getApplicationContext());
        }
    }

    public static synchronized Preferences getInstance(Context context) {
        if (m_spInstance == null) {
            m_spInstance = new Preferences(context);
        }
        return m_spInstance;
    }

    public SharedPreferences getmPrefs() {
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(mContext.getApplicationContext());
        }
        return prefs;
    }

    public ArrayList<String> getChannelColorPreferences() {
        String channelColor = prefs.getString(PREFERENCE_CHANNEL_COLOR, null);
        return new ArrayList<String>(Arrays.asList(channelColor.split(":")));
    }

    public void setChannelColorPreferences(String channelColor) {
        SharedPreferences.Editor editor = getmPrefs().edit();
        editor.putString(PREFERENCE_CHANNEL_COLOR, channelColor);
        if (!editor.commit()) {
            Log.d(tag, "channelColor save failure");
        } else {
            Log.d(tag, "channelColor save success");
        }
    }

    public boolean getHasSetUpPreferences() {
        boolean channelColor = prefs.getBoolean(PREFERENCE_HAS_SETUP, false);
        return channelColor;
    }

    public void setHasSetUp(boolean hasSetUp) {
        SharedPreferences.Editor editor = getmPrefs().edit();
        editor.putBoolean(PREFERENCE_HAS_SETUP, hasSetUp);
        if (!editor.commit()) {
            Log.d(tag, "channelColor save failure");
        } else {
            Log.d(tag, "channelColor save success");
        }
    }

    public void clear() {
        SharedPreferences.Editor editor = getmPrefs().edit();
        editor.clear().commit();
    }

}
