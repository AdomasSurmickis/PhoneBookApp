package com.adomas.menu.sub;

import com.adomas.menu.MenuType;

public abstract class Menu {

    protected boolean toExit = false;

    protected final MenuType type;
    protected final String[] actions;

    public Menu() {
        this.type = null;
        this.actions = null;
    }

    public Menu(MenuType type, String... actions) {
        this.type = type;
        this.actions = actions;
    }

    public abstract void enterToMenu();



    public void printMenu() {
        String s = "[" + type.name + "] Enter action (";
        s += String.join(", ", actions);
        s += "): ";
        System.out.print(s);
    }

    public MenuType getType() {
        return type;
    }

    public boolean exit() {
        return toExit = true;
    }


}
