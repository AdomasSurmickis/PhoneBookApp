package com.adomas.menu;

import com.adomas.domain.Contact;
import com.adomas.PhoneBook;
import com.adomas.menu.sub.RecordMenu;
import com.adomas.service.ContactServiceImpl;
import com.adomas.service.PhoneBookService;

import java.util.Scanner;

public class MenuController  {
    public static Scanner sc;
    public static ContactServiceImpl contactService;
    public static PhoneBookService phoneBookService;
    private static MenuFactory menuFactory;
    public static PhoneBook phoneBook;
    public static boolean exitApp = false;

    public MenuController() {
        sc = new Scanner(System.in);
        contactService = new ContactServiceImpl();
//        menuFactory = MenuFactory.getInstance();
        phoneBook = new PhoneBook();
    }


    public MenuController(String filePath) {
        sc = new Scanner(System.in);
//        menuFactory = MenuFactory.getInstance();
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
                    menuFactory.createOrGetMenu(MenuType.LIST, phoneBook).executeCommand("asd");
                    break;
                case "search":
                    menuFactory.createOrGetMenu(MenuType.SEARCH, phoneBook).enterToMenu();
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



    public static void runRecordMenu(Contact contact) {
        ((RecordMenu) menuFactory.createOrGetMenu(MenuType.RECORD, phoneBook)).run(contact);
    }


    public static void saveToFile() {

    }

}
