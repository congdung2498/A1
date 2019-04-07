package com.example.nguyentuan.tracnghiem1.monhoc;


public class Exam {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exam(int id, String name) {
        this.name = name;
        this.id=id;
    }

    public Exam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
