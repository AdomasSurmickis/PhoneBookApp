package com.adomas;

public enum ContactType {
    PERSON("person"), ORGANIZATION("organization");

    public String name;

    ContactType(String s) {
        this.name = s;
    }

}
