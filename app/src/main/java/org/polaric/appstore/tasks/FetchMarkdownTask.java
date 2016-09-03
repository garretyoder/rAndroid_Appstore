package org.polaric.appstore.tasks;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import org.polaric.appstore.Util;
import org.polaric.appstore.objects.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class FetchMarkdownTask extends AsyncTask<Void,Boolean,Boolean> {
    OnExecuteFinishedListener l;

    public void setOnExecuteFinishedListener(OnExecuteFinishedListener l) {
        this.l=l;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        String html="";
        try {
            html = getStringFromURL(Util.REDDIT_ANDROID_WIKI_URL);
        } catch (Exception e) {
            Log.e(Util.LOG_TAG,e.getMessage());
            if (l!=null) {
                l.onExecuteFinished(null);
                return null;
            }
        }

        int start = html.indexOf("#Apps")+5;
        int end = html.indexOf("</textarea>");
        System.out.println(start + " " + end);
        return null;
    }

    private static String getStringFromURL(String loc) throws IOException {
        URL url = new URL(loc);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        in.close();
        return content.toString();
    }

    interface OnExecuteFinishedListener {
        void onExecuteFinished(ArrayList<App> apps);
    }

}
