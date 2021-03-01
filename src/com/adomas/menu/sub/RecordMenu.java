package com.adomas.menu.sub;

import com.adomas.domain.Contact;
import com.adomas.menu.MenuController;
import com.adomas.menu.MenuType;

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
            switch (MenuController.sc.nextLine()) {
                case "edit":
                    MenuController.phoneBook.editContact(currentRecord);
                    break;
                case "delete":
                    MenuController.phoneBook.removeContact(currentRecord);
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
