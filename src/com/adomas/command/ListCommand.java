package com.adomas.command;

import com.adomas.domain.PhoneBook;
import com.adomas.menu.Menu;

public class ListCommand implements Command {

    private PhoneBook phoneBook;
    private Menu menu;

    public ListCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.list( phoneBook);
    }
}
