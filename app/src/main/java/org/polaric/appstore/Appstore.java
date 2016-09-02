package org.polaric.appstore;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.afollestad.appthemeengine.ATE;

public class Appstore extends Application {
    private SharedPreferences prefs;
    private boolean darkTheme;
    private boolean newRelease=false;

    @Override
    public void onCreate() {
        super.onCreate();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        darkTheme = prefs.getBoolean("dark_theme",false);
        newRelease = !(BuildConfig.VERSION_CODE == prefs.getInt("current_version",0));

        if (!ATE.config(this, null).isConfigured()) {
            ATE.config(this,null)
                    .primaryColorRes(R.color.md_blue_500)
                    .accentColorRes(R.color.md_pink_500)
                    .commit();
        }

    }

    public boolean isNewRelease() {
        return newRelease;
    }

    public boolean isDarkTheme() {
        return darkTheme;
    }

    public void setDarkTheme(boolean theme) {
        prefs.edit().putBoolean("dark_theme",theme).apply();
        darkTheme=theme;
    }

    public int getActivityTheme() {
        return isDarkTheme() ? R.style.Dark : R.style.Light;
    }

    public void restart() {
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
