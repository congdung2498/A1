package com.example.nguyentuan.tracnghiem1.Tips;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nguyentuan.tracnghiem1.R;

public class TipsAdapter extends CursorAdapter {

    public TipsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view= LayoutInflater.from(context).inflate(R.layout.item_list_question, parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv= (TextView) view.findViewById(R.id.tvQuestion);
        //LinearLayout ln= (LinearLayout) view.findViewById(R.id.linQues);

//        if(cursor.getPosition()%2 == 0){
//            ln.setBackgroundColor(Color.parseColor("#FFE2DFDF"));
//        }else ln.setBackgroundColor(Color.parseColor("#ffffff"));

        tv.setText(cursor.getString(1));
    }
}
