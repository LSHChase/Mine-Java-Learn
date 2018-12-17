package com.me.note.common;

public enum NewEnum {
    NIHAO("你好");

    private String name;

    private NewEnum(String name){
        this.name = name;
    };

    public String getName() {
        return name;
    }
}
