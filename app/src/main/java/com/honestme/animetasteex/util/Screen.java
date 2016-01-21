package com.honestme.animetasteex.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Administrator on 2015/11/3 0003.
 */
public class Screen {
    public static int getStatusBarHeight(Context context){
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height","dimen","android");

        if(resourceId > 0){
            result = context.getResources().getDimensionPixelOffset(resourceId);
        }

        return result;
    }

    public static int getScreenHeight(WindowManager windowManager){
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        return displayMetrics.heightPixels;



    }

    public static int getScreenWidth(WindowManager windowManager){
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

}
