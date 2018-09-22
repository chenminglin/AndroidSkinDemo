package com.chenminglin.androidskindemo;

import android.app.Application;

import solid.ren.skinlibrary.SkinConfig;
import solid.ren.skinlibrary.loader.SkinManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
        SkinConfig.setCanChangeStatusColor(true);
        SkinConfig.setCanChangeFont(true);
        SkinConfig.setDebug(true);
        SkinConfig.enableGlobalSkinApply();
    }
}
