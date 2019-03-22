package com.example.nguyentuan.tracnghiem1.Tips;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nguyentuan.tracnghiem1.question.DBHelper;


public class TipsController {
    private DBHelper dbHelper;

    public TipsController(Context context) {
        dbHelper= new DBHelper(context);
    }

    public Cursor getTips() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM tips",null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
