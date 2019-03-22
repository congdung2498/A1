package com.example.nguyentuan.tracnghiem1.Tips;


public class Tips{
    private int idtips;
    private String contenttips;

    public Tips() {
    }

    public Tips(String contenttips) {
        this.contenttips = contenttips;
    }

    public int getIdtips() {
        return idtips;
    }

    public void setIdtips(int idtips) {
        this.idtips = idtips;
    }

    public String getContenttips() {
        return contenttips;
    }

    public void setContenttips(String contenttips) {
        this.contenttips = contenttips;
    }
}
