package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.Model;

public class DrawerItem {

    String title;
    private String count = "0";

    public DrawerItem() {
        //default constructor
    }

    public DrawerItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}