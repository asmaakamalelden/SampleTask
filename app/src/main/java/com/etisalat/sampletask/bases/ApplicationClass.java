package com.etisalat.sampletask.bases;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ApplicationClass extends Application {
    private static ApplicationClass instance;

    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static ApplicationClass getInstance ()
    {
        return instance;
    }
    public static boolean hasNetwork ()
    {
        return instance.checkIfHasNetwork();
    }

    public boolean checkIfHasNetwork()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
