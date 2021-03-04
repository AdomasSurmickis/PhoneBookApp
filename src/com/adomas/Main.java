package com.adomas;

import com.adomas.domain.Contact;
import com.adomas.menu.MenuFactory;
import com.adomas.menu.MenuType;
import com.adomas.menu.sub.Menu;
import com.adomas.menu.sub.RecordMenu;
import com.adomas.service.ContactServiceImpl;
import com.adomas.service.PhoneBookService;

import java.util.Scanner;

public class Main {

    public static Scanner sc;
    public static ContactServiceImpl contactService;
    public static PhoneBookService phoneBookService;
    private static MenuFactory menuFactory;
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
        while (!exitApp) {

            System.out.println(mainMenu);
            mainMenu.executeCommand(sc.nextLine()); // exec next user command, if not repeat


        }


    }

    public static void exitProgram() {
        exitApp = true;
    }

    public static void runRecordMenu(Contact contact) {
        ((RecordMenu) menuFactory.createOrGetMenu(MenuType.RECORD, phoneBook)).run(contact);
    }

}
