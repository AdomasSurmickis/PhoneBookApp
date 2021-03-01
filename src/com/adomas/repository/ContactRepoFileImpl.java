package com.adomas.repository;

import contacts.Contact;
import contacts.PhoneBook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ContactRepoFileImpl implements ContactRepository {

    private Path path;
    private PhoneBook phoneBook;

    public ContactRepoFileImpl(String pathStr, PhoneBook phoneBook) {
        Path p = Path.of(pathStr);
        if (Files.exists(p)) {
            this.path = p;
        } else {
            try {
                path = Files.createFile(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.phoneBook = phoneBook;
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toString()))) {
            contacts = (List<Contact>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public Contact save(Contact object) {
        try (ObjectOutputStream inputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            inputStream.writeObject(phoneBook.contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void delete(Contact object) {
        PhoneBook.contacts.remove(object);
        try (ObjectOutputStream inputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            inputStream.writeObject(PhoneBook.contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
