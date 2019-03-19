package com.example.nguyentuan.tracnghiem1.slide;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyentuan.tracnghiem1.R;
import com.example.nguyentuan.tracnghiem1.question.Question;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {

    ArrayList<Question> arr_Ques;
    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";
    public int mPageNumber; // vị trí trang hiện tại
    public int checkAns;   // biến kiểm tra ...

    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;
    ImageView imgIcon;
    CheckBox cb1 , cb2, cb3, cb4;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tvNum = (TextView) rootView.findViewById(R.id.tvNum);
        tvQuestion = (TextView) rootView.findViewById(R.id.tvQuestion);
//        radA = (RadioButton) rootView.findViewById(R.id.radA);
//        radB = (RadioButton) rootView.findViewById(R.id.radB);
//        radC = (RadioButton) rootView.findViewById(R.id.radC);
//        radD = (RadioButton) rootView.findViewById(R.id.radD);
        imgIcon=(ImageView) rootView.findViewById(R.id.ivIcon) ;
        cb1 = (CheckBox) rootView.findViewById(R.id.checkBox1);
        cb2 = (CheckBox) rootView.findViewById(R.id.checkBox2);
        cb3 = (CheckBox) rootView.findViewById(R.id.checkBox3);
        cb4 = (CheckBox) rootView.findViewById(R.id.checkBox4);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arr_Ques = new ArrayList<Question>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        arr_Ques = slideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns= getArguments().getInt(ARG_CHECKANSWER);

    }

    public static ScreenSlidePageFragment create(int pageNumber, int checkAnswer) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putInt(ARG_CHECKANSWER,checkAnswer);
        fragment.setArguments(args);

        return fragment;
    }

//    public Question getItem(int position) {
//        return arr_Ques.get(position);
//    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu " + (mPageNumber + 1));
//        tvNum.setVisibility(View.INVISIBLE);
        tvQuestion.setText(arr_Ques.get(mPageNumber).getQuestion());
//        radA.setText(getItem(mPageNumber).getAns_a());
//        radB.setText(getItem(mPageNumber).getAns_b());
//        if(getItem(mPageNumber).getAns_c()== null || getItem(mPageNumber).getAns_c().length() == 0){
//            radC.setVisibility(View.INVISIBLE);
//        }else{
//            radC.setVisibility(View.VISIBLE);
//            radC.setText(getItem(mPageNumber).getAns_c());
//        }
//        if(getItem(mPageNumber).getAns_d()== null || getItem(mPageNumber).getAns_d().length() == 0 ){
//            radD.setVisibility(View.INVISIBLE);
//        }
//        else{
//            radD.setVisibility(View.VISIBLE);
//            radD.setText(getItem(mPageNumber).getAns_d());
//        }

        cb1.setText(getItem(mPageNumber).getAns_a());
        cb2.setText(getItem(mPageNumber).getAns_b());
        if(getItem(mPageNumber).getAns_c()== null || getItem(mPageNumber).getAns_c().length() == 0){
            cb3.setVisibility(View.INVISIBLE);
        }else{
            cb3.setVisibility(View.VISIBLE);
            cb3.setText(getItem(mPageNumber).getAns_c());
        }
        if(getItem(mPageNumber).getAns_d()== null || getItem(mPageNumber).getAns_d().length() == 0 ){
            cb4.setVisibility(View.INVISIBLE);
        }
        else{
            cb4.setVisibility(View.VISIBLE);
            cb4.setText(getItem(mPageNumber).getAns_d());
        }

        imgIcon.setImageResource(getResources().getIdentifier(getItem(mPageNumber).getImage()+"","drawable","com.example.nguyentuan.tracnghiem1"));

        if(checkAns!=0){
            cb1.setClickable(false);
            cb2.setClickable(false);
            cb3.setClickable(false);
            cb4.setClickable(false);
            getCheckAns(getItem(mPageNumber).getResult1(),getItem(mPageNumber).getResult2());
        }

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose(view);
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose(view);
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose(view);
            }
        });
        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chose(view);
            }
        });
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                getItem(mPageNumber).choiceID = checkedId;
//                getItem(mPageNumber).setTraloi1(getChoiceFromID(checkedId));
//                Toast.makeText(getActivity(),"Đây là đáp án "+ checkedId, Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    public Question getItem(int posotion){
        return arr_Ques.get(posotion);
    }

    //Lấy giá trị (vị trí) radiogroup chuyển thành đáp án A/B/C/D
    private String getChoiceFromID(int ID) {
        if (ID == R.id.checkBox1) {
            return "A";
        } else if (ID == R.id.checkBox2) {
            return "B";
        } else if (ID == R.id.checkBox3) {
            return "C";
        } else if (ID == R.id.checkBox4) {
            return "D";
        } else return "";
    }

    //Hàm kiểm tra câu đúng, nếu câu đúng thì đổi màu background radiobutton tương ứng
    private void getCheckAns(String ans1, String ans2){
        if(ans1.equals("A")==true){
            cb1.setBackgroundColor(Color.RED);
        }
        if(ans1.equals("B")==true){
            cb2.setBackgroundColor(Color.RED);
        } if(ans1.equals("C")==true){
            cb3.setBackgroundColor(Color.RED);
        } if(ans1.equals("D")==true){
            cb4.setBackgroundColor(Color.RED);
        } if(ans2.equals("A")==true) {
            cb1.setBackgroundColor(Color.RED);
        }if(ans2.equals("B")==true) {
            cb2.setBackgroundColor(Color.RED);
        }if(ans2.equals("C")==true) {
            cb3.setBackgroundColor(Color.RED);
        }if(ans2.equals("D")==true) {
            cb4.setBackgroundColor(Color.RED);
        }
    }

    public void chose(View v){
        if (cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb1.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(v.getId()));
            getItem(mPageNumber).setTraloi2("");
        }
        else if(!cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb2.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb2.getId()));
            getItem(mPageNumber).setTraloi2("");
        }
        else if(!cb1.isChecked() && !cb2.isChecked() && cb3.isChecked() && !cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb3.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb3.getId()));
            getItem(mPageNumber).setTraloi2("");
        }else if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb4.getId();
            getItem(mPageNumber).setTraloi2("");
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb4.getId()));
        }else if(cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb1.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb1.getId()));
            getItem(mPageNumber).setTraloi2(getChoiceFromID(cb2.getId()));
        }
        else if(cb1.isChecked() && !cb2.isChecked() && cb3.isChecked() && !cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb1.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb1.getId()));
            getItem(mPageNumber).setTraloi2(getChoiceFromID(cb3.getId()));
        }else if(cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb1.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb1.getId()));
            getItem(mPageNumber).setTraloi2(getChoiceFromID(cb4.getId()));
        }else if(!cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && !cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb2.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb2.getId()));
            getItem(mPageNumber).setTraloi2(getChoiceFromID(cb3.getId()));
        }else if(!cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb2.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb2.getId()));
            getItem(mPageNumber).setTraloi2(getChoiceFromID(cb4.getId()));
        }else if(!cb1.isChecked() && !cb2.isChecked() && cb3.isChecked() && cb4.isChecked()){
            getItem(mPageNumber).choiceID = cb3.getId();
            getItem(mPageNumber).setTraloi1(getChoiceFromID(cb3.getId()));
            getItem(mPageNumber).setTraloi2(getChoiceFromID(cb4.getId()));
        }else if(cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && !cb4.isChecked()){
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            cb4.setChecked(false);
            getItem(mPageNumber).setTraloi1("");
            getItem(mPageNumber).setTraloi2("");

        }
        else if(cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && cb4.isChecked()){
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            cb4.setChecked(false);
            getItem(mPageNumber).setTraloi1("");
            getItem(mPageNumber).setTraloi2("");

        }else if(cb1.isChecked() && !cb2.isChecked() && cb3.isChecked() && cb4.isChecked()){
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            cb4.setChecked(false);
            getItem(mPageNumber).setTraloi1("");
            getItem(mPageNumber).setTraloi2("");

        }else if(!cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked()){
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            cb4.setChecked(false);
            getItem(mPageNumber).setTraloi1("");
            getItem(mPageNumber).setTraloi2("");

        }else{
            getItem(mPageNumber).choiceID = -1;
            getItem(mPageNumber).setTraloi1("");
            getItem(mPageNumber).setTraloi2("");
        }
//        if(getItem(mPageNumber).getTraloi1()==null ||getItem(mPageNumber).getTraloi1().length()==0 ){
//            getItem(mPageNumber).choiceID = v.getId();
//            getItem(mPageNumber).setTraloi1(getChoiceFromID(v.getId()));
//        }
//        else if(getItem(mPageNumber).getTraloi2()==null ||getItem(mPageNumber).getTraloi2().length()==0){
//            getItem(mPageNumber).setTraloi2(getChoiceFromID(v.getId()));
//        }
//        else
//        Toast.makeText(getActivity(),"Đây là đáp án 1 "+ getItem(mPageNumber).getTraloi1() +"Đây là đáp án 2 "+ getItem(mPageNumber).getTraloi2(), Toast.LENGTH_SHORT).show();
    }
}
