package com.example.nguyentuan.tracnghiem1.slide;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyentuan.tracnghiem1.R;
import com.example.nguyentuan.tracnghiem1.question.Question;
import com.example.nguyentuan.tracnghiem1.score.ScoreController;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<Question> arr_QuesBegin= new ArrayList<Question>();
    int numNoAns=0;
    int numTrue=0;
    int numFalse=0;
    int totalScore=0;

    ScoreController scoreController;

    TextView tvTrue, tvFalse, tvNotAns, tvTotalScore , tvResult;
    Button btnSaveScore, btnAgain, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);
         scoreController=new ScoreController(TestDoneActivity.this);

        final Intent intent= getIntent();
        arr_QuesBegin= (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        System.out.println(arr_QuesBegin.get(0).getResult1() + "   "+arr_QuesBegin.get(0).getResult2() +"   "+ arr_QuesBegin.get(0).getTraloi1() +"   "+ arr_QuesBegin.get(0).getTraloi2());
        begin();
        checkResult();
        totalScore= numTrue*10;
        tvNotAns.setText(""+numNoAns);
        tvFalse.setText(""+numFalse);
        tvTrue.setText(""+numTrue);
        tvTotalScore.setText(""+totalScore);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                builder.show();
            }
        });

        btnSaveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater=TestDoneActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.allert_dialog_save_score,null);
                builder.setView(view);

                final EditText edtName= (EditText) view.findViewById(R.id.edtName);
                final EditText edtRoom= (EditText) view.findViewById(R.id.edtRoom);
                TextView tvScore= (TextView) view.findViewById(R.id.tvScore);
                final int numTotal= numTrue*10;
                tvScore.setText(numTotal+" điểm");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name= edtName.getText().toString();
                        String room= edtRoom.getText().toString();
                        scoreController.insertScore(name,numTotal,room);
                        Toast.makeText(TestDoneActivity.this, "Lưu điểm thành công!",Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog b= builder.create();
                b.show();
            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
                finish();
                Intent intent2= new Intent(TestDoneActivity.this, ScreenSlideActivity.class);
                intent2.putExtra("arr_Ques",arr_QuesBegin);
                intent2.putExtra("test","no");
                startActivity(intent2);
            }
        });

    }

    public void refresh(){
        for(int i=0; i<arr_QuesBegin.size(); i++){
            arr_QuesBegin.get(i).setTraloi1("");
        }
    }

    public void begin(){
        tvFalse= (TextView)findViewById(R.id.tvFalse);
        tvTrue= (TextView)findViewById(R.id.tvTrue);
        tvNotAns= (TextView)findViewById(R.id.tvNotAns);
        tvTotalScore= (TextView)findViewById(R.id.tvTotalPoint);
        btnAgain=(Button)findViewById(R.id.btnAgain);
        btnSaveScore=(Button)findViewById(R.id.btnSaveScore);
        btnExit=(Button)findViewById(R.id.btnExit);
        tvResult = (TextView)findViewById(R.id.result);
    }

    //PT Check kết quả
    public void checkResult(){
//        System.out.println("rs1 "+ arr_QuesBegin.get(0).getResult1() + "   rs2 " + arr_QuesBegin.get(0).getResult2() +"   tl1 "+ arr_QuesBegin.get(0).getResult1() +"   tl2 "+ arr_QuesBegin.get(0).getResult2());
        for(int i=0; i< arr_QuesBegin.size(); i++){
//            System.out.println("rs1 "+ arr_QuesBegin.get(i).getResult1() + "   rs2 " + arr_QuesBegin.get(i).getResult2() +"   tl1 "+ arr_QuesBegin.get(i).getResult1() +"   tl2 "+ arr_QuesBegin.get(i).getResult2());
            if(arr_QuesBegin.get(i).getTraloi1().equals("")==true && arr_QuesBegin.get(i).getTraloi2().equals("")==true){
                numNoAns++;
            }else if(arr_QuesBegin.get(i).getResult1().equals(arr_QuesBegin.get(i).getTraloi1())==true && arr_QuesBegin.get(i).getResult2().equals(arr_QuesBegin.get(i).getTraloi2())==true ){
                numTrue++;
            }else numFalse++;
        }
        if(numTrue >= 16){
            tvResult.setText("Chúc mừng bạn đã đỗ");

        }
        else{
            tvResult.setText("Rất tiếc bạn đã trượt");
//            tvResult.setTextColor(Integer.parseInt("FF303F9F"));
        }
    }

}
