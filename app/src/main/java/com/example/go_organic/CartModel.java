package com.example.go_organic;

public class CartModel {

    String Product, curl;
    String Price, Quantity;


    CartModel(){

    }
    public CartModel( String price, String quantity,String product, String curl) {

        this.Price = price;
        this.Quantity = quantity;
        this.Product = product;
        this.curl = curl;


    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {this.curl = curl; }



}
