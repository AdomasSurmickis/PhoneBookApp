package com.adomas.menu;

import com.adomas.PhoneBook;
import com.adomas.phoneBookCommands.Command;

public class SearchCommand implements Command {
    private PhoneBook phoneBook;

    public SearchCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.searchContacts();
    }
}
