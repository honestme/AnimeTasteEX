package com.honestme.animetasteex.util;

import android.content.Context;

import java.io.File;

/**
 * Created by Administrator on 2015/11/2 0002.
 */
public class CacheUtil {
    public static void deleteCache(Context context){
        try{
            File dir = context.getCacheDir();
            if(dir != null && dir.isDirectory()){
                deleteDir(dir);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static boolean deleteDir(File dir){
        if(dir != null && dir.isDirectory()){
            String[] childFiles = dir.list();
            for(String s:childFiles){
                boolean success = deleteDir(new File(dir,s));
                if(success == false){
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
