package com.example.nguyentuan.tracnghiem1.monhoc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nguyentuan.tracnghiem1.question.DBHelper;
import com.example.nguyentuan.tracnghiem1.question.Question;

import java.util.ArrayList;


public class ExamController {
    private DBHelper dbHelper;

    public ExamController(Context context) {
        dbHelper= new DBHelper(context);
    }

    //Lấy danh sách câu hỏi
    public ArrayList<Exam> getExam(){
        ArrayList<Exam> lsData= new ArrayList<Exam>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM exam",null);
        cursor.moveToFirst();
        do {
            Exam item;
            item= new Exam(cursor.getInt(0),cursor.getString(1));
            lsData.add(item);

        }while (cursor.moveToNext());
        return lsData;
    }

}
