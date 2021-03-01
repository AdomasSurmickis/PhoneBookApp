package com.adomas.menu;

public enum MenuType {
    MAIN("menu"), SEARCH("search"), RECORD("record"), LIST("list"),
    EXIT("exit");

    public String name;

    MenuType(String name) {
        this.name = name;
    }
}
