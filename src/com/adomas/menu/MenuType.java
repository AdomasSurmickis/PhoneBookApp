package com.adomas.menu;

public enum MenuType {
    MAIN("menu"), SEARCH("search"), RECORD("record"), LIST("list"),
    EXIT("exit");

    private String name;

    MenuType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
