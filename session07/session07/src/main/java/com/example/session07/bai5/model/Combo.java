package com.example.session07.bai5.model;

import java.util.List;

public class Combo {
    private String name;
    private double price;
    private List<String> itemList;
    private String bannerPath;

    public Combo() {
    }

    public Combo(String name, double price, List<String> itemList, String bannerPath) {
        this.name = name;
        this.price = price;
        this.itemList = itemList;
        this.bannerPath = bannerPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }
}