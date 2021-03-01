package com.adomas;

import contacts.repository.ContactRepoFileImpl;
import contacts.repository.ContactRepoListImpl;
import contacts.repository.ContactRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static contacts.menu.MenuController.sc;

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

    public Contact getContactByInputIndexThrows(String input) throws NumberFormatException {
        int parsedInt = 0;
        parsedInt = Integer.parseInt(input) - 1;
        return contacts.get(parsedInt);
    }


    public void removeContact(Contact c) {
        contacts.remove(c);
        contactRepository.save(c);
        System.out.println("The record removed!");
    }

    public Contact getContact(int position) {
        return contacts.get(position + 1);
    }


    public List<Contact> searchContacts(String nextLine) {
        Pattern p = Pattern.compile(".*(" + nextLine + ").*", Pattern.CASE_INSENSITIVE);

        return contacts.stream()
                .filter(contact -> p.matcher(contact.getAllFieldsAsString()).matches())
                .collect(Collectors.toList());
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
}


