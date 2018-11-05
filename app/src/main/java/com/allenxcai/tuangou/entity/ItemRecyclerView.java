package com.allenxcai.tuangou.entity;

/**
 * Project:TuanGou
 * Author:Allenxcai
 * Date:2018/10/14/014
 * Description:
 */
public class ItemRecyclerView {

    private String iV_Path;
    private String name;
    private String description;
    private String price;
    private String action;
    private String count;

    public ItemRecyclerView() {
    }

    public ItemRecyclerView(String iV_Path, String name, String description, String price, String action, String count) {
        this.iV_Path = iV_Path;
        this.name = name;
        this.description = description;
        this.price = price;
        this.action = action;
        this.count = count;
    }

    public String getiV_Path() {
        return iV_Path;
    }

    public void setiV_Path(String iV_Path) {
        this.iV_Path = iV_Path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


}
