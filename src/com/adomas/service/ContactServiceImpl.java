//package com.adomas.service;
//
//import com.adomas.domain.Contact;
//import com.adomas.domain.Organization;
//import com.adomas.domain.Person;
//import com.adomas.domain.PhoneBook;
//import com.adomas.menu.MenuController;
//import com.adomas.repository.ContactRepoListImpl;
//import com.adomas.repository.ContactRepository;
//
//import java.lang.reflect.Field;
//
//public class ContactServiceImpl {
//
//    private ContactRepository repository;
//
//    public ContactServiceImpl() {
//        this.repository = new ContactRepoListImpl();
//    }
//
//
//
//    public Contact  createContact() {
//        System.out.print("Enter the type (person, organization): ");
//        String type = MenuController.sc.nextLine();
//        Contact contact = null;
//        switch (type) {
//            case "person":
//                contact = new Person(PhoneBook.contacts.size());
//                break;
//            case "organization":
//                contact = new Organization(PhoneBook.contacts.size());
//                break;
//            default:
//                System.out.println("The record was not added.");
//                break;
//        }
//
//        for (Field f : contact.getEditableFields()) {
//            contact.updateContactField(MenuController.sc, f.getName());
//        }
//
//        return contact;
//    }
//
//    public void editContact(Contact c) {
//        c.printEditableOptions();
//        if (c.updateContactField(MenuController.sc, MenuController.sc.nextLine())) {
//            System.out.println("Saved");
//            repository.save(c);
//            System.out.println(c);
//        } else {
//            System.out.println();
//        }
//
//    }
//
//}