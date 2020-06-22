package com.example.mb_demo.controller;

import java.text.SimpleDateFormat;

public enum SingletonEnum {
    INSTANCE;
    private SimpleDateFormat singleton;
    SingletonEnum(){
        singleton =new SimpleDateFormat("yyyy-MM-dd");
    }
    public SimpleDateFormat getInstance(){
        return singleton;
    }
}
