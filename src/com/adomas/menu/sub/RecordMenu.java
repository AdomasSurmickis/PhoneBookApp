package com.adomas.menu.sub;

import contacts.Contact;
import contacts.menu.MenuType;

import static contacts.menu.MenuController.*;

public class RecordMenu extends Menu {
    Contact currentRecord;

    public RecordMenu(MenuType type) {
        super(type, "edit", "delete", "menu");
    }

    @Override
    public void enterToMenu() {
        toExit = false;
        while (!toExit) {
            printMenu();
            switch (sc.nextLine()) {
                case "edit":
                    phoneBook.editContact(currentRecord);
                    break;
                case "delete":
                    phoneBook.removeContact(currentRecord);
                    exit();
                    break;
                case "menu":
                    exit();
            }
        }

    }

    public void run(Contact contact) {
        currentRecord = contact;
        System.out.println(contact);
        enterToMenu();
    }

}
