package com.adomas.command;

import com.adomas.domain.PhoneBook;

public class InfoCommand implements Command {
    private PhoneBook phoneBook;
    private String contactIndex;

    public InfoCommand(PhoneBook phoneBook, String contactIndex) {
        this.phoneBook = phoneBook;
        this.contactIndex = contactIndex;
    }

    @Override
    public void execute() {
        phoneBook.retrieveAndEditContact(contactIndex);
    }
}
