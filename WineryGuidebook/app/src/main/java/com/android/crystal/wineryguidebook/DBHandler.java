//package com.android.crystal.wineryguidebook;
//
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteException;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.Cursor;
//import android.content.Context;
//import android.content.ContentValues;
//
//
//public class DBHandler extends SQLiteOpenHelper{
//    private static final int DATABASE_VERSION = 1; //whenever update the db, update the version here.
//    private static final String DATABASE_NAME = "Winery.db";
//
//    public static final String TABLE_WINERY = "winery"; // wID int, NAME text,typeID int, Desc(wine type) text, Phone text, Add text, isFav bool
//    public static final String TABLE_REVIEW = "review";// rID int, wID int, Review text, Rate int, uID int
//    public static final String TABLE_MYREVIEW = "myReview";//mrID int, wID int, Rate int, Review text
//    public static final String TABLE_USER = "user";//可能不用  uID int, Password text, name text
//    public static final String TABLE_TYPE = "wineType"; //typeID int, type text; serch by type 的时候map winery table
//
//    //constructor
//    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
//        super(context, DATABASE_NAME,factory, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        //will be called the very first time.
//        //need query for creating tables
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WINERY);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEW);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MYREVIEW);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TYPE);
//        onCreate(db);
//    }
//
//    //start other functions for querying database
//
//
//}
