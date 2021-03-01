package com.adomas.menu.sub;

import contacts.Contact;
import contacts.PhoneBook;
import contacts.menu.MenuController;
import contacts.menu.MenuType;

import java.util.List;

import static contacts.menu.MenuController.*;

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
        foundContacts =phoneBook.searchContacts(sc.nextLine());
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
        String input = sc.nextLine();
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
                runRecordMenu(record);
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
