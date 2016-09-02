package org.polaric.appstore.activities;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;

import com.afollestad.appthemeengine.ATEActivity;
import com.afollestad.appthemeengine.Config;

import org.polaric.appstore.Appstore;
import org.polaric.appstore.BuildConfig;
import org.polaric.appstore.R;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.licenses.MITLicense;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;


public class AboutActivity extends ATEActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(((Appstore) getApplication()).getActivityTheme());
        setContentView(R.layout.activity_about);
        toolbar = (Toolbar) findViewById(R.id.about_toolbar);
        toolbar.setTitle(R.string.about);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_48px);
        toolbar.setNavigationOnClickListener(this);

        if (((Appstore) getApplication()).isDarkTheme()) {
            ((NavigationView) findViewById(R.id.appnav)).setItemTextColor(getResources().getColorStateList(R.color.dark_drawer));
            ((NavigationView) findViewById(R.id.appnav)).setItemIconTintList(getResources().getColorStateList(R.color.dark_drawer));

            ((NavigationView) findViewById(R.id.contributenav)).setItemTextColor(getResources().getColorStateList(R.color.dark_drawer));
            ((NavigationView) findViewById(R.id.contributenav)).setItemIconTintList(getResources().getColorStateList(R.color.dark_drawer));
        }

        ((NavigationView) findViewById(R.id.appnav)).getMenu().findItem(0).setTitle(getResources().getString(R.string.version) + " " + BuildConfig.VERSION_NAME);
        ((NavigationView) findViewById(R.id.appnav)).setNavigationItemSelectedListener(this);

        ((NavigationView) findViewById(R.id.contributenav)).setNavigationItemSelectedListener(this);

        if (findViewById(R.id.appnav) != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            findViewById(R.id.appnav).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                    return insets;
                }
            });
        }

        if (findViewById(R.id.contributenav) != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            findViewById(R.id.contributenav).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                    return insets;
                }
            });
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github:
                openInChrome("https://github.com/garretyoder/rAndroid_Appstore");
                break;
            case R.id.reddit:
                openInChrome("https://www.reddit.com/r/android");
                break;
            case R.id.reportbug:
                // TODO
                break;
            case R.id.changelog:
                // TODO
                break;
            case R.id.licenses:
                Notices notices = new Notices();
                notices.addNotice(new Notice("App Theme Engine", "https://github.com/garretyoder/app-theme-engine", null, new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Material Dialogs", "https://github.com/afollestad/material-dialogs", "Copyright (c) 2014-2016 Aidan Michael Follestad", new MITLicense()));
                notices.addNotice(new Notice("Recycler Fast Scroll", "https://github.com/plusCubed/recycler-fast-scroll", null, new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Licenses Dialog", "https://github.com/PSDev/LicensesDialog", null, new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Android Support Libraries", "https://github.com/android/platform_frameworks_support", null, new ApacheSoftwareLicense20()));
                new LicensesDialog.Builder(this)
                        .setNotices(notices)
                        .setTitle(R.string.licenses)
                        .build()
                        .show();
                break;
        }
        return false;
    }
    private void openInChrome(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setSecondaryToolbarColor(Config.primaryColor(this, null));
        builder.setToolbarColor(Config.primaryColor(this, null));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
