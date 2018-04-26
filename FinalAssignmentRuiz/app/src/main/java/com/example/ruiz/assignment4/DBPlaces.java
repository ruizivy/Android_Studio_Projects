package com.example.ruiz.assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ruiz on 9/19/2017.
 */

public class DBPlaces extends SQLiteOpenHelper{

    private Context context;
    private static int version = 1;
    private static String dbName = "db_user";
    private String tblUser = "tblUser";
    private String fldID = "userId";
    private String fldName = "name";
    private String fldUsername = "username";
    private String fldPassword = "password";

    private String tblMyLocation = "tblMyLocation";
    private String fldLocationID = "locationId";
    private String fldUserID = "userId";
    private String fldPlace = "place";
    private String fldSubName = "subName";
    private String fldRate = "rate";
    private String fldLat = "lat";
    private String fldLong = "long";
    private String fldAddress = "address";
    private String fldType = "type";

    SQLiteDatabase db;

    public DBPlaces(Context appContext) {
        super(appContext, dbName, null, version);
        this.context = appContext;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + tblUser + " ( " +
                fldID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                fldName + " TEXT," +
                fldUsername + " TEXT," +
                fldPassword + " TEXT);";
        sqLiteDatabase.execSQL(query);

        String query1 = "CREATE TABLE " + tblMyLocation + " ( " +
                fldLocationID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                fldUserID + " INTEGER," +
                fldPlace + " TEXT," +
                fldSubName + " TEXT," +
                fldRate + " TEXT," +
                fldLat + " REAL," +
                fldLong + " REAL," +
                fldAddress + " TEXT," +
                fldType + " TEXT);";
        sqLiteDatabase.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXIST " + tblUser;
        db.execSQL(query);
        onCreate(db);
    }

    public void openConnection() {
        db = this.getWritableDatabase();
    }

    public void closeConnection() {
        this.close();
    }


    public Cursor getUser(int id) {
        openConnection();
        String query = "SELECT * FROM " + tblUser + " WHERE " + fldID + " = " + id;
        return db.rawQuery(query, null);
    }

    public Cursor getUsername(String username) {
        openConnection();
        String query = "SELECT * FROM " + tblUser + " WHERE " + fldUsername + " = '" + username + "'";
        return db.rawQuery(query, null);
    }

    public Cursor getUsernamePassword(String username, String password) {
        openConnection();
        String query = "SELECT * FROM " + tblUser +
                " WHERE " + fldUsername +
                " = '" + username + "' " +
                " and " + fldPassword +
                " = '" + password + "'";
        return db.rawQuery(query, null);
    }


    public Cursor getAllUser() {
        openConnection();
        String query = "SELECT * FROM " + tblUser + " ORDER BY " + fldID + " DESC";
        return db.rawQuery(query, null);
    }
    public Cursor getAllLocationByUserId(int userId) {
        openConnection();
        String query = "SELECT * FROM " + tblMyLocation +
                " WHERE " + fldUserID + " = " + userId +
                " ORDER BY " + fldRate + " DESC";
        return db.rawQuery(query, null);
    }

    public Cursor getLocationById(int locationId) {
        openConnection();
        String query = "SELECT * FROM " + tblMyLocation +
                " WHERE " + fldLocationID + " = " + locationId +
                " ORDER BY " + fldRate + " DESC";
        return db.rawQuery(query, null);
    }

    public long insertUser(String name,
                           String username,
                           String password) {
        openConnection();
        ContentValues values = new ContentValues();
        values.put(fldName, name);
        values.put(fldUsername, username);
        values.put(fldPassword, password);
        long succes = db.insert(tblUser, null, values);
        return succes;
    }
    public long insertLocation(int userId,String place,String subName,double rate
            ,double lati,double longi,String address,String type)
    {
        openConnection();
        ContentValues values = new ContentValues();
        values.put(fldUserID, userId);
        values.put(fldPlace, place);
        values.put(fldSubName, subName);
        values.put(fldRate, rate);
        values.put(fldLat, lati);
        values.put(fldLong, longi);
        values.put(fldAddress, address);
        values.put(fldType, type);
        long succes = db.insert(tblMyLocation, null, values);
        return succes;
    }

    public long updateLocation(int locId,int userId,String place,String subName,double rate
            ,double lati,double longi,String address,String type) {
        openConnection();
        ContentValues values = new ContentValues();
        values.put(fldUserID, userId);
        values.put(fldPlace, place);
        values.put(fldSubName, subName);
        values.put(fldRate, rate);
        values.put(fldLat, lati);
        values.put(fldLong, longi);
        values.put(fldAddress, address);
        values.put(fldType, type);
        long succes = db.update(tblMyLocation, values, fldLocationID + "=?", new String[]{locId + ""});
        return succes;
    }

    public long updateData(int id,
                           String name,
                           String username,
                           String password) {
        openConnection();
        ContentValues values = new ContentValues();
        values.put(fldName, name);
        values.put(fldUsername, username);
        values.put(fldPassword, password);
        long succes = db.update(tblUser, values, fldID + "=?", new String[]{id + ""});
        return succes;
    }

    public boolean deleteMyLocation(int id) {
        String query = "DELETE FROM " + tblMyLocation + " WHERE " + fldLocationID + " = " + id;
        try {
            openConnection();
            db.execSQL(query);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
