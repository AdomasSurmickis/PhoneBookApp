package com.adomas.menu.sub;

import com.adomas.domain.Contact;
import com.adomas.PhoneBook;
import com.adomas.menu.MenuController;
import com.adomas.menu.MenuType;

import java.util.List;

public class SearchMenu extends Menu {
    List<Contact> foundContacts;
    Contact foundRecord;

    public SearchMenu(MenuType type) {
        super(type, "[number]", "back", "again");
    }

    @Override
    public void enterToMenu() {
        main();
        toExit=false;
        while (!toExit) {
            secondary();
        }
    }

    public void main() {
        System.out.print("Enter search query: ");
        foundContacts = MenuController.phoneBook.searchContacts(MenuController.sc.nextLine());
        if (foundContacts.size() > 0) {
            System.out.println("Found " + foundContacts.size() + " results:");
            PhoneBook.printList(foundContacts);
        } else {
            System.out.println("No results has been found");
        }
    }

    public void secondary() {
        System.out.println();
        printMenu();
        String input = MenuController.sc.nextLine();
        Contact record = PhoneBook.getContactByInputIndex(input);

        if (record != null) {
            input = "number";
        }
        switch (input) {
            case "again":
                main();
            case "back":
                exit();
                break;
            case "number":
                foundRecord = record;
                MenuController.runRecordMenu(record);
                exit();
        }

    }

    private List<Contact> searchContacts(String input) {
        return MenuController.phoneBookService.searchContacts(input);
    }

    public List<Contact> getFoundContacts() {
        return foundContacts;
    }

}
