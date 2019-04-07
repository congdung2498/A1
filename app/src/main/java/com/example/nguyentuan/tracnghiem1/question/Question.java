package com.example.nguyentuan.tracnghiem1.question;

import java.io.Serializable;


public class Question implements Serializable{
    private  int _id;
    private  String question;
    private  String ans_a;
    private  String ans_b;
    private  String ans_c;
    private  String ans_d;
    private  String result1;
    private  String result2;
    private  int num_exam;
    private  String image;
    private String traloi1="";
    private String traloi2="";
    public int choiceID= -1; //hỗ trợ check Id của radiogroup

    public String getTraloi1() {
        return traloi1;
    }

    public void setTraloi1(String traloi1) {
        this.traloi1 = traloi1;
    }

    public String getTraloi2() {
        return traloi2;
    }

    public void setTraloi2(String traloi2) {
        this.traloi2 = traloi2;
    }


    public Question(int _id, String question, String ans_a, String ans_b, String ans_c, String ans_d,String image, String result1,String result2,  String traloi1, String traloi2, int num_exam) {
        this._id = _id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result1 = result1;
        this.result2 = result2;
        this.num_exam = num_exam;
        this.image = image;
        this.traloi1= traloi1;
        this.traloi2 =  traloi2;
    }

    public Question() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }
    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }
    public int getNum_exam() {
        return num_exam;
    }

    public void setNum_exam(int num_exam) {
        this.num_exam = num_exam;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
