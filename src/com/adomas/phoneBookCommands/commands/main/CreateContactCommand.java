package com.adomas.phoneBookCommands.commands.main;

import com.adomas.PhoneBook;
import com.adomas.phoneBookCommands.Command;

public class CreateContactCommand implements Command {

    private PhoneBook phoneBook;

    public CreateContactCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.createContact();
    }
}
