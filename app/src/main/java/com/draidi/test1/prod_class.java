package com.draidi.test1;

public class prod_class {
    private int id;
    private String prodName,ownerName,type,amount,info,price,img1,img2,img3,views,date;

    public prod_class() {
    }

    public prod_class(int id, String prodName, String ownerName, String type, String amount, String info, String price, String img1, String img2, String img3, String views, String date) {
        this.id = id;
        this.prodName = prodName;
        this.ownerName = ownerName;
        this.type = type;
        this.amount = amount;
        this.info = info;
        this.price = price;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.views = views;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getProdName() {
        return prodName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getType() {
        return type;
    }

    public String getAmount() {
        return amount;
    }

    public String getInfo() {
        return info;
    }

    public String getPrice() {
        return price;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public String getImg3() {
        return img3;
    }

    public String getViews() {
        return views;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return prodName;
    }
}
