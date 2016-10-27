package com.offspring.tftcontrolpanel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.offspring.tftcontrolpanel.R;
import com.offspring.tftcontrolpanel.persistence.Preferences;

public class MainActivity extends AppCompatActivity {

    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = Preferences.getInstance(MainActivity.this);

//        if (preferences.getHasSetUpPreferences()) {
//            startActivity(new Intent(MainActivity.this, TabTFTActivity.class));
//        }

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
