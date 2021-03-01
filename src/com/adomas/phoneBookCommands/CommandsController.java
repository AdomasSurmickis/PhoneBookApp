package com.adomas.phoneBookCommands;

public class CommandsController {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
