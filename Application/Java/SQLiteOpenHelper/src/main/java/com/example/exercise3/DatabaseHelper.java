package com.example.exercise3;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "EventManagement.db";
    private static final int DATABASE_VERSION = 1;

    // Tạo bảng
    private static final String CREATE_TABLE = "CREATE TABLE event (id INTEGER PRIMARY KEY AUTOINCREMENT, subject TEXT, room TEXT, date TEXT, enable INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        
        values.put("subject", event.getSubject());
        values.put("room", event.getRoom());
        values.put("date", event.getDate());
        values.put("enable", event.getEnable() ? 1 : 0);
        
        db.insert("event", null, values);
        db.close();
    }

    public List<Event> getAllData() {
        List<Event> events = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM event", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                
                @SuppressLint("Range") 
                String subject = cursor.getString(cursor.getColumnIndex("subject"));
                
                @SuppressLint("Range") 
                String room = cursor.getString(cursor.getColumnIndex("room"));
                
                @SuppressLint("Range") 
                String date = cursor.getString(cursor.getColumnIndex("date"));
                
                @SuppressLint("Range") 
                int enableValue = cursor.getInt(cursor.getColumnIndex("enable"));
                boolean enable = enableValue == 1; // Chuyển đổi giá trị 1 thành true, và 0 thành false
                
                events.add(new Event(id, subject, room, date, enable));
                
            } while (cursor.moveToNext());
        }

        cursor.close();
        return events;
    }

    public void updateData(int id, boolean newEnable) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("enable", newEnable ? 1 : 0);
        db.update("event", values, "id = ?", new String[] { String.valueOf(id) });
        
        db.close();
    }

    public void deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        db.delete("event", "id = ?", new String[] { String.valueOf(id) });
        
        db.close();
    }
}
