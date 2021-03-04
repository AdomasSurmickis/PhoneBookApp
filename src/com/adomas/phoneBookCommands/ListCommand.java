package com.adomas.phoneBookCommands;

import com.adomas.PhoneBook;
import com.adomas.menu.sub.Menu;

public class ListCommand implements Command {

    private PhoneBook phoneBook;
    private Menu menu;
    public ListCommand(Menu newMenu, PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.list(menu,phoneBook);
    }
}
