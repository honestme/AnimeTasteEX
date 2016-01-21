package com.honestme.animetasteex.util;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.honestme.animetasteex.R;


/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class DBUtil  extends SQLiteOpenHelper{
    public static final int VERSION = 1;

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion){

           default:

        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VIDEO_INFO_CREATE);
        db.execSQL(FAVOURATE_CREATE);
        db.execSQL(WATCHED_VIDEO_CREATE);
    }

    public static final String DATABASE_NAME = Resources.getSystem()
            .getResourceName(R.string.app_name);

    private static String TABLE_VIDEO_INFO = "VideoInfo";
    private static String TABLE_FAVOURATE = "Favourate";
    private static String TABLE_WATCHED_VIDEO_LIST = "WatchedVideo";

    private static final String VIDEO_INFO_CREATE =
            "create table Video(_id integer primary key autoincrement, "
                    + "id text not null UNIQUE,"
                    + "name text not null,"
                    + "videourl text not null,"
                    + "author text not null,"
                    + "year text not null,"
                    + "brief text not null,"
                    + "homepic text not null,"
                    + "detailpic text not null,"
                    + "updatetime text not null,"
                    + "isfav text not null,"
                    + "inserttime text not null" + ");";

    private static final String FAVOURATE_CREATE = "create table Fav("
            + "_id integer primary key autoincrement," + "vid integer UNIQUE,"
            + "addtime text not null" + ")";

    private static final String WATCHED_VIDEO_CREATE = "create table Watched("
            + "_id integer primary key autoincrement," + "vid integer UNIQUE)";


    public DBUtil(Context context,String name,int version){
        super(context,name,null,version);
    }

    public DBUtil(Context context,String name){
        super(context,name,null,VERSION);
    }





}
