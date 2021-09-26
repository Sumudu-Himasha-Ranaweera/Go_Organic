package com.example.go_organic.models;

public class NavCategoryDetailModel {

    String name;
    String price;
    String img_url;
    String type;

    public NavCategoryDetailModel() {
    }

    public NavCategoryDetailModel(String name, String price, String img_url, String type) {
        this.name = name;
        this.price = price;
        this.img_url = img_url;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
