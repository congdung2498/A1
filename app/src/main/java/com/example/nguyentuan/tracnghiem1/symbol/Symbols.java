package com.example.nguyentuan.tracnghiem1.symbol;

import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

public class Symbols implements Serializable {
    private int id;
    private String name;//tên biển báo
    private String content;// nội dung biển báo
    private String photo;//hình ảnh biển báo

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Symbols(int id, String name, String content, String photo) {
        this.id=id;
        this.name = name;
        this.content = content;
        this.photo= photo;
    }
}
