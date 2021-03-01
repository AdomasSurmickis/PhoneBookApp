package com.adomas;

import com.adomas.menu.MenuController;

public class Main {
    public static void main(String[] args) {
        new Thread(new Thread()).start();
        MenuController menuController;
        if (args.length == 1) {
            menuController = new MenuController(args[0]);
        } else {
            menuController = new MenuController();
        }
        menuController.loopMenus();
    }

}
