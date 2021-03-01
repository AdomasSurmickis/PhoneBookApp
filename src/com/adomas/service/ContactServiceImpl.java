package com.adomas.service;

import contacts.Contact;
import contacts.Organization;
import contacts.Person;
import contacts.PhoneBook;
import contacts.repository.ContactRepoListImpl;
import contacts.repository.ContactRepository;

import java.lang.reflect.Field;

import static contacts.menu.MenuController.sc;

public class ContactServiceImpl {

    private ContactRepository repository;

    public ContactServiceImpl() {
        this.repository = new ContactRepoListImpl();
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
                break;
        }

        for (Field f : contact.getEditableFields()) {
            contact.updateContactField(sc, f.getName());
        }

        return contact;
    }

    public void editContact(Contact c) {
        c.printEditableOptions();
        if (c.updateContactField(sc, sc.nextLine())) {
            System.out.println("Saved");
            repository.save(c);
            System.out.println(c);
        } else {
            System.out.println();
        }

    }

}