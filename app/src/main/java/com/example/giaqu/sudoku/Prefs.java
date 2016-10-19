package com.example.giaqu.sudoku;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.sudoku.R;

/**
 * Created by giaqu on 8/24/2016.
 */
public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
