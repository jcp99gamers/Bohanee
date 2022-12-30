package com.bohanee.jcp.hrai.database;

/**
 * Created by Shivanshu Raj on 09-10-2022.
 */
public class Product {
    private String productName;
    private int cp;
    private int sp;
    private int quantity;

    public Product(String productName, int sp, int quantity) {
        this.productName = productName;
        this.sp = sp;
        this.quantity = quantity;
    }

    public Product(String productName, int cp, int sp, int quantity) {
        this.productName = productName;
        this.cp = cp;
        this.sp = sp;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
