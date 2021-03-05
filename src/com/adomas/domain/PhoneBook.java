package com.adomas.domain;

import com.adomas.menu.MenuFactory;
import com.adomas.menu.MenuType;
import com.adomas.menu.Menu;
import com.adomas.command.EditCommand;
import com.adomas.command.InfoCommand;
import com.adomas.command.RemoveCommand;
import com.adomas.repository.ContactRepoFileImpl;
import com.adomas.repository.ContactRepoListImpl;
import com.adomas.repository.ContactRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.adomas.Application.*;

public class PhoneBook {
    public static List<Contact> contacts;
    private ContactRepository contactRepository;


    public PhoneBook() {
        this.contactRepository = new ContactRepoListImpl();
        contacts = new ArrayList<>();
    }

    public PhoneBook(String path) {
        this.contactRepository = new ContactRepoFileImpl(path, this);
        contacts = contactRepository.findAll();
    }

    public void printContactCount() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    @SafeVarargs
    public static void printContactList(List<Contact>... contactLists) {
        if (contactLists.length == 0) {
            printList(contacts);
        } else if (contactLists.length == 1) {
            printList(contactLists[0]);
        }
    }

    public void printPhoneBookContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(1 + i + ". " + contacts.get(i).getFullName());
        }
    }

    public static void printList(List<Contact> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(1 + i + ". " + list.get(i).getFullName());
        }
    }

    public static Contact getContactByInputIndex(String input) {
        int parsedInt = 0;
        try {
            parsedInt = Integer.parseInt(input) - 1;
            return contacts.get(parsedInt);
        } catch (NumberFormatException | NullPointerException npe) {
            return null;
        }

    }

    public Contact getContactByInputIndexThrows(String input) {
        int parsedInt = 0;
        try {
            parsedInt = Integer.parseInt(input) - 1;
            return contacts.get(parsedInt);
        } catch (NumberFormatException e) {

        }
        return null;
    }


    public void removeContact(Contact c) {
        contacts.remove(c);
        contactRepository.save(c);
        System.out.println("The record removed!");
    }

    public Contact getContact(int position) {
        return contacts.get(position + 1);
    }


    public void enterSearchMenu() {
        searchContacts();
        Menu searchMenu = MenuFactory.createOrGetMenu(MenuType.SEARCH, this);
        while (!searchMenu.isToExit()) {
            System.out.print(searchMenu);

            String input = sc.nextLine();
            if (!executeInfoCommandIfNumber(searchMenu, input)) {
                searchMenu.executeCommand(input);
            }
        }
    }


    public List<Contact> searchContacts() {
        System.out.print("Enter query to search: ");
        String nextLine = sc.nextLine();
        Pattern p = Pattern.compile(".*(" + nextLine + ").*", Pattern.CASE_INSENSITIVE);

        List<Contact> foundContacts = contacts.stream()
                .filter(contact -> p.matcher(contact.getAllFieldsAsString()).matches())
                .collect(Collectors.toList());

        if (foundContacts.size() > 0) {
            System.out.println("Found " + foundContacts.size() + " results:");
            PhoneBook.printList(foundContacts);
        } else {
            System.out.println("No results has been found");
        }
        return contacts;
    }


    public Contact createContact() {
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();
        Contact contact = null;
        switch (type) {
            case "person":
                contact = new Person(PhoneBook.contacts.size());
                break;
            case "organization":
                contact = new Organization(PhoneBook.contacts.size());
                break;
            default:
                System.out.println("The record was not added.");
                return null;
        }

        for (Field f : contact.getEditableFields()) {
            contact.updateContactField(sc, f.getName());
        }

        contacts.add(contact);
        contactRepository.save(contact);
        return contact;
    }


    public void editContact(Contact c) {
        c.printEditableOptions();
        if (c.updateContactField(sc, sc.nextLine())) {
            System.out.println("Saved");
            contactRepository.save(c);
            System.out.println(c);
        } else {
            System.out.println();
        }
    }

    public void list(PhoneBook phoneBook) {
        Menu listMenu = MenuFactory.createOrGetMenu(MenuType.LIST, this);
        if (contacts.size() > 0) {
            phoneBook.printPhoneBookContacts();
            System.out.print(listMenu);

            String command = sc.nextLine();
            executeInfoCommandIfNumber(listMenu, command);

        } else {
            System.out.println("Phone book is empty");
        }
    }

    public boolean executeInfoCommandIfNumber(Menu menu, String input) {
        if (input.matches("\\d+")) {
            menu.setCommand("[number]", new InfoCommand(this, input));
            menu.executeCommand("[number]");
            return true;
        }

        return false;
    }


    public void retrieveAndEditContact(String contactIndex) {
        Menu recordMenu = MenuFactory.createOrGetMenu(MenuType.RECORD, this);
        Contact contact = getContactByInputIndex(contactIndex);

        if (contact != null) {
            while (!recordMenu.isToExit()) {
                System.out.print(recordMenu);
                String inputCommand = sc.nextLine().toLowerCase();
                switch (inputCommand) {
                    case "edit":
                        recordMenu.setCommand(inputCommand, new EditCommand(this, contact));
                        recordMenu.executeCommand(inputCommand);
                        break;
                    case "delete":
                        recordMenu.setCommand(inputCommand, new RemoveCommand(this, contact));
                        recordMenu.executeCommand(inputCommand);
                        recordMenu.exit();
                        break;
                    case "menu":
                        recordMenu.executeCommand(inputCommand);
                        MenuFactory.createOrGetMenu(MenuType.SEARCH, this).exit();
                }
            }
        } else {
            System.out.println("Contact with index " + contactIndex + "  not found");
        }

    }
}


