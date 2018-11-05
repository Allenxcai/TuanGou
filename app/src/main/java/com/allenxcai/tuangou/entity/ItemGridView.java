package com.allenxcai.tuangou.entity;

/**
 * Project:TuanGou
 * Author:Allenxcai
 * Date:2018/10/14/014
 * Description:
 */
public class ItemGridView {

    private int iV_Id;
    private String text;

    public ItemGridView() {
    }

    public ItemGridView(int imageView, String text) {
        this.iV_Id = imageView;
        this.text = text;
    }

    public int getImageView() {

        return iV_Id;
    }

    public void setImageView(int imageView) {
        this.iV_Id = imageView;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
