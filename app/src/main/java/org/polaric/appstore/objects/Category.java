package org.polaric.appstore.objects;

import java.util.ArrayList;

public class Category {
    private ArrayList<App> apps;
    private String name;

    public Category(String name) {
        this.name=name;
    }

    public void addApp(App app) {
        apps.add(app);
    }
}
