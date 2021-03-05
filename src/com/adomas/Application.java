package com.adomas;

import com.adomas.domain.PhoneBook;
import com.adomas.menu.MenuFactory;
import com.adomas.menu.MenuType;
import com.adomas.menu.Menu;

import java.util.Scanner;

public class Application {

    public static Scanner sc = new Scanner(System.in);
    public static PhoneBook phoneBook;
    public static boolean exitApp = false;


    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
//        MenuController menuController;
//        if (args.length == 1) {
//            menuController = new MenuController(args[0]);
//        } else {
//            menuController = new MenuController();
//        }
//        menuController.loopMenus();

        Menu mainMenu = MenuFactory.createOrGetMenu(MenuType.MAIN, phoneBook);
        while (!mainMenu.isToExit()) {

            System.out.print(mainMenu);
            mainMenu.executeCommand(sc.nextLine()); // exec next user command, if not repeat


        }


    }

    public static void exitProgram() {
        exitApp = true;
    }


}
