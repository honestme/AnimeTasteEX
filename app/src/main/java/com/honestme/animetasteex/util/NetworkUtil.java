package com.honestme.animetasteex.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class NetworkUtil {
    private static final int WIFI = 1;
    private static final int MOBILE = 2;
    private static final int NO_CONNECTION = 0;

    public static boolean isWifiAvailable(Context context){
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        int state = wifiManager.getWifiState();

        if(state == WifiManager.WIFI_STATE_ENABLED){
            return true;
        }
        else if(state == WifiManager.WIFI_STATE_DISABLED){
            return false;
        }
        else {
            return false;
        }


    }

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = connectivityManager.getActiveNetworkInfo();

        if(network != null) {
            if (network.isAvailable()) {
                return true;
            } else {
                return false;
            }
        }

        return false;

    }

    public static int getNetworkStatus(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = connectivityManager.getActiveNetworkInfo();

        if(network.getType() == ConnectivityManager.TYPE_WIFI){
            return WIFI;
        }
        else if(network.getType() == ConnectivityManager.TYPE_MOBILE){
            return MOBILE;
        }
        else {
            return NO_CONNECTION;
        }
    }



}
