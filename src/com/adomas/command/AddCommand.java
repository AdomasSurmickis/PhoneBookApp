package com.adomas.command;

import com.adomas.domain.PhoneBook;

public class AddCommand implements Command {

    private PhoneBook phoneBook;

    public AddCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.createContact();
    }
}
