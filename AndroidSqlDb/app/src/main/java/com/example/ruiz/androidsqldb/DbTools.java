package com.example.ruiz.androidsqldb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ruiz on 7/22/2017.
 */

public class DbTools extends SQLiteOpenHelper{

    private Context context;
    private static  int version = 2;
    private static String dbName = "DBUsers";
    private String tblName = "tblUsers";

    private String fldID ="UserID";
    private String fldUName = "UserName";
    private String fldPwd = "Userpassword";

    SQLiteDatabase db;

    public DbTools(Context appContext){
        super(appContext , dbName , null , version);
        this.context = appContext;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "  + tblName + "( " +
                fldID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                fldUName + " TEXT, " +
                fldPwd + " TEXT)";
        db.execSQL(query);
        query = "INSERT INTO " + tblName + " ( "+ fldUName+ "," + fldPwd+ ")" +
                "VALUES('JOHN DOE' , '12345')";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS " + tblName;
        db.execSQL(query);
        onCreate(db);
    }
    public  void openConnection(){
        db = this.getWritableDatabase();
    }
    public  void closeConnection(){
        this.close();
    }
    public Cursor getAllUsers(){
        openConnection();
        return db.query(tblName , new String[]{fldID , fldUName , fldPwd} , null , null, null, null, null);
    }
    public long insertUser(String name , String pwd){

        openConnection();
        ContentValues values = new ContentValues();
        values.put(fldUName, name);
        values.put(fldPwd, pwd);
        long success = db.insert(tblName , null , values);

        return success;
    }
    public  long updateUser(int id , String name , String pwd){
        openConnection();
        ContentValues values = new ContentValues();

        values.put(fldID , id);
        values.put(fldUName , name);
        values.put(fldPwd , pwd);

        long success = db.update(tblName, values , fldID + "=? " , new String[]{id + ""});

        return  success;
    }
    public  boolean delete(int id){
        String query = "DELETE FROM "+ tblName + " WHERE " +
                fldID + " = " + id;
        try {
            openConnection();
            db.execSQL(query);
            return true;
        }catch (Exception ex){
            return  false;
        }

    }
    public Cursor getUser(int id){
        String query = "SELECT & FROM  tblUsers " +
                " WHERE UserID = " + id;

        return db.rawQuery(query , null);
    }
}
