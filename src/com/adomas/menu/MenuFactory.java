package com.adomas.menu;

import com.adomas.PhoneBook;
import com.adomas.menu.sub.ListMenu;
import com.adomas.menu.sub.Menu;
import com.adomas.menu.sub.RecordMenu;
import com.adomas.menu.sub.SearchMenu;
import com.adomas.phoneBookCommands.CountCommand;
import com.adomas.phoneBookCommands.ExitMenuCommand;
import com.adomas.phoneBookCommands.ListCommand;
import com.adomas.phoneBookCommands.commands.main.CreateContactCommand;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {
    private static List<Menu> menus = new ArrayList<>();
    private static MenuFactory factory;

    private MenuFactory() {
    }


    public static Menu createOrGetMenu(MenuType type, PhoneBook phoneBook) {
        Menu newMenu = null;
        for (Menu menu : menus) {
            if (menu.getMenuType().equals(type)) {
                return menu;
            }
        }
        switch (type) {
            case MAIN:
                newMenu = new Menu(MenuType.MAIN);
                newMenu.addCommand("add", new CreateContactCommand(phoneBook))
                        .addCommand("list", new ListCommand(newMenu, phoneBook))
                        .addCommand("search", new SearchCommand(phoneBook))
                        .addCommand("count", new CountCommand(phoneBook))
                        .addCommand("exit", new ExitMenuCommand(newMenu));
                break;
            case RECORD:
                newMenu = new RecordMenu(MenuType.RECORD);
                break;
            case SEARCH:
                newMenu = new SearchMenu(MenuType.SEARCH);
                break;
            case LIST:
                newMenu = new ListMenu(MenuType.LIST);
                newMenu.addCommand();
        }
        menus.add(newMenu);
        return newMenu;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
