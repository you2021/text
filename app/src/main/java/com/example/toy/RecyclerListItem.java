package com.example.toy;

public class RecyclerListItem {
    String name;
    String imgUrl;
    String company;
    String day;
    int number;

    public RecyclerListItem() {
    }

    public RecyclerListItem(String name, String imgUrl, String company, String day, int number) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.company = company;
        this.day = day;
        this.number = number;
    }
}
