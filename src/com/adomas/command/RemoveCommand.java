package com.adomas.command;

import com.adomas.domain.PhoneBook;
import com.adomas.domain.Contact;

public class RemoveCommand implements Command {

    private PhoneBook phoneBook;
    private Contact contact;

    public RemoveCommand(PhoneBook phoneBook, Contact contact) {
        this.phoneBook = phoneBook;
        this.contact = contact;
    }

    @Override
    public void execute() {
            phoneBook.removeContact(contact);
    }
}
