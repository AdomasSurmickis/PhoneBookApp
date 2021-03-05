package com.adomas.command;

import com.adomas.menu.Menu;

public class ExitMenuCommand implements Command {
    private Menu menuToExit;

    public ExitMenuCommand(Menu menu) {
        this.menuToExit = menu;
    }

    @Override
    public void execute() {
        menuToExit.exit();
    }
}
