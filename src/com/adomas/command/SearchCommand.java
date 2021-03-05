package com.adomas.command;

import com.adomas.domain.PhoneBook;

public class SearchCommand implements Command {
    private PhoneBook phoneBook;

    public SearchCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.enterSearchMenu();
    }
}
