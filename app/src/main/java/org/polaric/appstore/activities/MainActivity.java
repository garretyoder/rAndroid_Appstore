package org.polaric.cluttr.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.afollestad.appthemeengine.ATEActivity;

import org.polaric.cluttr.Cluttr;
import org.polaric.cluttr.R;

public class MainActivity extends ATEActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(((Cluttr) getApplication()).getActivityTheme());
        setContentView(R.layout.activity_main);
        setSupportActionBar(((Toolbar) findViewById(R.id.toolbar)));
    }
}
