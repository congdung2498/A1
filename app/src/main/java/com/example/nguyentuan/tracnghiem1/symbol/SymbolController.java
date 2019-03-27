package com.example.nguyentuan.tracnghiem1.symbol;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nguyentuan.tracnghiem1.question.DBHelper;

import java.util.ArrayList;

public class SymbolController {
    private DBHelper dbHelper;

    public SymbolController(Context context) {
        dbHelper= new DBHelper(context);
    }

    public Cursor getSymbols() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM tbl_symbol ORDER BY name ASC",null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
