package com.adomas;

import contacts.menu.MenuController;

public class Main {
    public static void main(String[] args) {
        MenuController menuController;
        if (args.length == 1) {
            menuController = new MenuController(args[0]);
        } else {
            menuController = new MenuController();
        }
        menuController.loopMenus();
    }
}
