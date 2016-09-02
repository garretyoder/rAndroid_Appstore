package org.polaric.appstore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.appthemeengine.ATEActivity;

import org.polaric.appstore.Appstore;
import org.polaric.appstore.R;

public class MainActivity extends ATEActivity {

    Toolbar toolbar;
    View toolbarContainer;
    NavigationView navMenu;
    NavigationView navFooter;
    DrawerLayout mDrawer;

    private View.OnClickListener toolbarNavClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mDrawer.openDrawer(Gravity.LEFT);
        }
    };

    private  NavigationView.OnNavigationItemSelectedListener mainDrawerListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.settings:
                    Intent sIntent = new Intent(getApplication(),SettingsActivity.class);
                    startActivity(sIntent);
                    return false;
                case R.id.about:
                    Intent aIntent = new Intent(getApplication(),AboutActivity.class);
                    startActivity(aIntent);
                    return false;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(((Appstore) getApplication()).getActivityTheme());
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarContainer = findViewById(R.id.toolbar_container);
        navFooter = (NavigationView) findViewById(R.id.nav_footer);
        navMenu = (NavigationView) findViewById(R.id.nav_main);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar.setNavigationIcon(R.drawable.ic_menu_white_48px);

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(toolbarNavClickListener);
        navFooter.setNavigationItemSelectedListener(mainDrawerListener);

    }

}
