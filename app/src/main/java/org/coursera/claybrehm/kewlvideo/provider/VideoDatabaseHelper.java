package org.coursera.claybrehm.kewlvideo.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

/**
 * Created by claybrehm on 7/8/15.
 */
public class VideoDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="kewlvideo.db";

    public static final int DATABASE_VERSION=1;

    public VideoDatabaseHelper(Context context) {
        super(context, context.getCacheDir()+File.separator+DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldV, int newV) {

    }
}
