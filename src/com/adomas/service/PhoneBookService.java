//package com.adomas.service;
//
//import com.adomas.domain.PhoneBook;
//import com.adomas.domain.Contact;
//
//import java.util.List;
//import java.util.Scanner;
//
//
//public class PhoneBookService {
//
//
//    public void removeContact(PhoneBook phoneBook, Scanner sc) {
//        System.out.println("Select a record: ");
//        Contact contact = phoneBook.getContactByInputIndex(sc.nextLine());
//        if (contact != null) {
//            phoneBook.removeContact(contact);
//        } else {
//            System.out.println("No records to remove");
//        }
//    }
//
////    public Object searchMenuSwitch(String action, Scanner sc, PhoneBook phoneBook) {
////        switch (action) {
////            case "again":
////                System.out.print("Enter search query: ");
////                List<Contact> foundContacts = phoneBook.searchContacts(sc.nextLine());
////                if (foundContacts.size() > 0) {
////                    System.out.println("Found " + foundContacts.size() + " results:");
////                    phoneBook.printList(foundContacts);
////                } else {
////                    System.out.println("No results has been found");
////                }
////
////                return foundContacts;
////
////            case "back":
////                return null;
////            default:
////                try {
////                    int i = Integer.parseInt(action);
////                    return phoneBook.getContact(i - 1);
////                } catch (NumberFormatException e) {
////                    return action;
////                }
////        }
////    }
//
//    public List<Contact> searchContacts(String nextLine) {
//        return null;
//    }
//
//
//    public void editContactInPhoneBook() {
//        System.out.println("Select a record: ");
//        Contact contact = PhoneBook.getContactByInputIndex(sc.nextLine());
//        contactService.editContact(contact);
//    }
//
//}
