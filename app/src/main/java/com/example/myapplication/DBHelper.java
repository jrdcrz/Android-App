package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
   private static final String DB_NAME = "Userdata.db";
   private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS UserLogin (UserID INTEGER PRIMARY KEY AUTOINCREMENT," +
           "Username TEXT NOT NULL, Password TEXT NOT NULL, Email TEXT NOT NULL);";
   private static final String DELETE_TABLE = "DROP TABLE IF EXISTS UserLogin;";
   private SQLiteDatabase db;
   private ContentValues cv;

   public DBHelper(Context context) {
        super(context, DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE);
    }

    public boolean insertUserData (String username, String email, String password) {
        db = this.getWritableDatabase();
        cv = new ContentValues();
        cv.put("Username", username);
        cv.put("Email", email);
        cv.put("Password", password);

        long newData = db.insert("UserLogin", null, cv);
        if(newData == - 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateUserData (int id, String username) {
        db = this.getWritableDatabase();
        cv = new ContentValues();
        cv.put("Username", username);

        Cursor cursor = db.rawQuery("SELECT * FROM UserLogin WHERE ID = ?", new String[id]);

        if(cursor.getCount() > 0) {
            long updateData = db.update("UserLogin", cv, "id=?",new String[id]);
            if (updateData == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean deleteUserData (int id) {
        db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM UserLogin WHERE ID = ?", new String[id]);
        if(cursor.getCount() > 0) {
            long updateData = db.delete("UserLogin","id=?",new String[id]);
            if (updateData == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor readUserData () {
        db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM UserLogin", null);
        return cursor;
    }
}
