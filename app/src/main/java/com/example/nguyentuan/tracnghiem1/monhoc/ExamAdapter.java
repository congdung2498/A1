package com.example.nguyentuan.tracnghiem1.monhoc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyentuan.tracnghiem1.R;

import java.util.ArrayList;

//Kế thừa từ ArrayAdapter chứa mảng là đối tượng Exam
public class ExamAdapter extends ArrayAdapter<Exam> {
    //super() gọi hàm tạo lớp cha ArrayAdapter
    public ExamAdapter(Context context, ArrayList<Exam> exam) {
        super(context, 0, exam);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext()); //Chuyển xml thành view
            convertView= inflater.inflate(R.layout.item_gridview, parent, false);//tham số 1: xml muốn chuyển. TS2 nơi xml nhúng vào.ts3 true thì nhúng ngay vào viewgroup, flase không thêm ngay.
        }
        TextView tvName= (TextView) convertView.findViewById(R.id.tvNumExam);
        ImageView imgIcon= (ImageView) convertView.findViewById(R.id.imgIcon);

        Exam p= getItem(position);
        if(p!=null){
            tvName.setText(""+ p.getName());
            imgIcon.setImageResource(R.drawable.subject);
        }

        return convertView;
    }
}
