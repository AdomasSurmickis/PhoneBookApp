package com.adomas.menu;

import contacts.Contact;
import contacts.PhoneBook;
import contacts.menu.sub.MenuFactory;
import contacts.menu.sub.RecordMenu;
import contacts.service.ContactServiceImpl;
import contacts.service.PhoneBookService;

import java.util.Scanner;

public class MenuController {
    public static Scanner sc;
    public static ContactServiceImpl contactService;
    public static PhoneBookService phoneBookService;
    private static MenuFactory menuFactory;
    public static PhoneBook phoneBook;
    public static boolean exitApp = false;

    public MenuController() {
        sc = new Scanner(System.in);
        contactService = new ContactServiceImpl();
        menuFactory = MenuFactory.getInstance();
        phoneBook = new PhoneBook();
    }


    public MenuController(String filePath) {
        sc = new Scanner(System.in);
        menuFactory = MenuFactory.getInstance();
        phoneBook = new PhoneBook(filePath);
        contactService = new ContactServiceImpl();


    }

    public void loopMenus() {

        while (!exitApp) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String selection = sc.nextLine();
            switch (selection) {
                case "add":
                    System.out.println();
                    phoneBook.createContact();
                    break;
                case "list":
                    menuFactory.createOrGetMenu(MenuType.LIST).enterToMenu();
                    break;
                case "search":
                    menuFactory.createOrGetMenu(MenuType.SEARCH).enterToMenu();
                case "count":
                    phoneBook.printContactCount();
                    break;
                case "exit":
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid option(" + selection + ") was provided");
                    break;
            }
            System.out.println();
        }

    }

    public static void exitProgram() {
        exitApp = true;
    }


    public static void runRecordMenu(Contact contact) {
        ((RecordMenu) menuFactory.createOrGetMenu(MenuType.RECORD)).run(contact);
    }


    public static void saveToFile() {

    }

}
