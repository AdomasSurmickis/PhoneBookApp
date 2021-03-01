package com.adomas.menu.sub;

import contacts.Contact;
import contacts.PhoneBook;
import contacts.menu.MenuType;

import static contacts.menu.MenuController.runRecordMenu;
import static contacts.menu.MenuController.sc;

public class ListMenu extends Menu {

    private PhoneBook phoneBook = null;

    public ListMenu(MenuType type) {
        super(type, "[number]", "back");
    }

    @Override
    public void enterToMenu() {
        toExit = false;
        if (PhoneBook.contacts.size() > 0) {
            PhoneBook.printContactList();
            System.out.println();

            while (!toExit) {
                printMenu();
                String input = sc.nextLine();

                Contact record = PhoneBook.getContactByInputIndex(input);
                if (record != null) {
                    input = "number";
                }
                switch (input) {
                    case "number":
                        runRecordMenu(record);
                        exit();
                    case "back":
                        exit();
                        break;
                }

            }
        } else {
            System.out.println("Phone book is empty");
            exit();
        }
    }

}
