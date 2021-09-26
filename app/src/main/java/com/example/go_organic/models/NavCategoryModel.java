package com.example.go_organic.models;

public class NavCategoryModel {

    String name;
    String img_url;
    String discount;
    String description;
    String type;

    public NavCategoryModel() {
    }

    public NavCategoryModel(String name, String img_url, String discount, String description, String type) {
        this.name = name;
        this.img_url = img_url;
        this.discount = discount;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
