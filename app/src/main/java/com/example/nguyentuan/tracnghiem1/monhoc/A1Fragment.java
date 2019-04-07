package com.example.nguyentuan.tracnghiem1.monhoc;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.nguyentuan.tracnghiem1.MainActivity;
import com.example.nguyentuan.tracnghiem1.R;
import com.example.nguyentuan.tracnghiem1.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class A1Fragment extends Fragment {

    ExamAdapter examAdapter;
    GridView gvExam;
    ArrayList<Exam> arr_exam= new ArrayList<Exam>();
    ExamController examController;
    public A1Fragment() {

    }

    //Tạo và trả về view fragment tương ứng
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Thi bằng lái xe A1");
        return inflater.inflate(R.layout.fragment_a1, container, false);
    }

    //Hoàn thành nốt việc khởi tạo
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gvExam = (GridView) getActivity().findViewById(R.id.gvExam);
        examController = new ExamController(getActivity());
        arr_exam = examController.getExam();

        examAdapter=new ExamAdapter(getActivity(),arr_exam);
        gvExam.setAdapter(examAdapter);
//        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent= new Intent(getActivity(), ScreenSlideActivity.class);
//                intent.putExtra("num_exam",i);
//                intent.putExtra("test","yes");
//                startActivity(intent);
//            }
//        });

    }
}
