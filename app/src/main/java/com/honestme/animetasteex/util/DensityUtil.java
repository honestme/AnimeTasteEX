package com.honestme.animetasteex.util;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


/**
 * Created by Administrator on 2015/11/2 0002.
 */
public class DensityUtil {
    public static int dpTopx(Context context,int dp){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int)((dp * displayMetrics.density) + 0.5);
    }

    public static int pxTodp(Context context,int px){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int)((px / displayMetrics.density) + 0.5);
    }

    public static int getScreenWidth(Context context){
        WindowManager windowManager = (WindowManager)context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    public static int getSceenHeight(Context context){
        WindowManager windowManager = (WindowManager)context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point.y;
    }

}

