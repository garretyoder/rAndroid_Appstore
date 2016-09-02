package org.polaric.cluttr.activities;

import android.content.Intent;
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

import org.polaric.cluttr.BuildConfig;
import org.polaric.cluttr.Cluttr;
import org.polaric.cluttr.R;


public class AboutActivity extends ATEActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(((Cluttr) getApplication()).getActivityTheme());
        setContentView(R.layout.activity_about);
        toolbar = (Toolbar) findViewById(R.id.about_toolbar);
        toolbar.setTitle(R.string.about);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_48px);
        toolbar.setNavigationOnClickListener(this);

        if (((Cluttr) getApplication()).isDarkTheme()) {
            ((NavigationView) findViewById(R.id.appnav)).setItemTextColor(getResources().getColorStateList(R.color.dark_drawer));
            ((NavigationView) findViewById(R.id.appnav)).setItemIconTintList(getResources().getColorStateList(R.color.dark_drawer));

            ((NavigationView) findViewById(R.id.authornav)).setItemTextColor(getResources().getColorStateList(R.color.dark_drawer));
            ((NavigationView) findViewById(R.id.authornav)).setItemIconTintList(getResources().getColorStateList(R.color.dark_drawer));
        }

        ((NavigationView) findViewById(R.id.appnav)).getMenu().findItem(0).setTitle(getResources().getString(R.string.version) + " " + BuildConfig.VERSION_NAME);
        ((NavigationView) findViewById(R.id.appnav)).setNavigationItemSelectedListener(this);

        ((NavigationView) findViewById(R.id.authornav)).setNavigationItemSelectedListener(this);

        if (findViewById(R.id.appnav) != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            findViewById(R.id.appnav).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                    return insets;
                }
            });
        }

        if (findViewById(R.id.authornav) != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            findViewById(R.id.authornav).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                    return insets;
                }
            });
        }

        /*TODO
        if (!Util.isGooglePlayServicesAvailable(this)) {
            ((NavigationView) findViewById(R.id.authornav)).getMenu().getItem(1).setVisible(false);
        }*/

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github:
                openInChrome("https://github.com/garretyoder");
                break;
            case R.id.website:
                openInChrome("http://www.polaric.org");
                break;
            case R.id.rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                } catch (android.content.ActivityNotFoundException anfe) {
                    openInChrome("https://play.google.com/store/apps/details?id=" + getPackageName());
                }
                break;
            case R.id.garret:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://dev?id=6014078401699539823")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    openInChrome("https://play.google.com/store/apps/dev?id=6014078401699539823");
                }
                break;
            case R.id.donate:
                /* TODO
                startActivity(new Intent(getApplication(),DonatePopup.class));
                */
                break;
            case R.id.reportbug:
                /* TODO
                if (Build.VERSION.SDK_INT<=Build.VERSION_CODES.KITKAT) {
                    new BugReportDialog(this,android.R.style.Theme_Black,this).show();
                } else {
                    new BugReportDialog(this, this).show();
                } */
                break;
            case R.id.changelog:
                /* TODO
                new ChangelogDialog(this).show();
                */
                break;
            case R.id.licenses:
                /* TODO
                Notices notices = new Notices();
                notices.addNotice(new Notice("App Theme Engine", "https://github.com/garretyoder/app-theme-engine", null, new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Material Dialogs", "https://github.com/afollestad/material-dialogs", "Copyright (c) 2014-2016 Aidan Michael Follestad", new MITLicense()));
                notices.addNotice(new Notice("Picasso", "http://square.github.io/picasso/", "Copyright 2013 Square, Inc.", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("OkHttp", "http://square.github.io/okhttp/", "Copyright 2016 Square, Inc.", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Recycler Fast Scroll", "https://github.com/plusCubed/recycler-fast-scroll", null, new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Licenses Dialog", "https://github.com/PSDev/LicensesDialog", null, new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Android In-App Billing v3 Library", "https://github.com/anjlab/android-inapp-billing-v3", "Copyright 2014 AnjLab", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Android Support Libraries", "https://github.com/android/platform_frameworks_support", null, new ApacheSoftwareLicense20()));
                new LicensesDialog.Builder(this)
                        .setNotices(notices)
                        .setTitle(R.string.licenses)
                        .build()
                        .show();
                */
                break;
            case R.id.gpl:
                /* TODO
                new GPLNoticeDialog(this,this).show();
                */
                break;
        }
        return false;
    }
    private void openInChrome(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        //builder.setSecondaryToolbarColor(Config.primaryColor(this, null));
        //builder.setToolbarColor(Config.primaryColor(this, null));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
