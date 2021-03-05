package com.adomas.command;

import com.adomas.domain.PhoneBook;
import com.adomas.domain.Contact;

public class EditCommand implements Command {
    private PhoneBook phoneBook;
    private Contact contact;

    public EditCommand(PhoneBook phoneBook, Contact contact) {
        this.phoneBook = phoneBook;
        this.contact = contact;
    }

    @Override
    public void execute() {
        phoneBook.editContact(contact);
    }
}
