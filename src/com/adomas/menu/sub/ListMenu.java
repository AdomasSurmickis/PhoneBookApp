package com.adomas.menu.sub;

import com.adomas.domain.Contact;
import com.adomas.PhoneBook;
import com.adomas.menu.MenuController;
import com.adomas.menu.MenuType;

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
                String input = MenuController.sc.nextLine();

                Contact record = PhoneBook.getContactByInputIndex(input);
                if (record != null) {
                    input = "number";
                }
                switch (input) {
                    case "number":
                        MenuController.runRecordMenu(record);
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
