package com.adomas.menu;

import com.adomas.domain.PhoneBook;
import com.adomas.command.*;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {
    private static List<Menu> menus = new ArrayList<>();

    private MenuFactory() {
    }


    public static Menu createOrGetMenu(MenuType type, PhoneBook phoneBook) {
        Menu newMenu = null;
        for (Menu menu : menus) {
            if (menu.getMenuType().equals(type)) {
                menu.setToExit(false);
                return menu;
            }
        }
        switch (type) {
            case MAIN:
                newMenu = new Menu(MenuType.MAIN);
                newMenu.addCommand("add", new AddCommand(phoneBook))
                        .addCommand("list", new ListCommand(phoneBook))
                        .addCommand("search", new SearchCommand(phoneBook))
                        .addCommand("count", new CountCommand(phoneBook))
                        .addCommand("exit", new ExitMenuCommand(newMenu));
                break;
            case RECORD:
                newMenu = new Menu(MenuType.RECORD);
                newMenu.addCommand("edit", null)
                        .addCommand("delete", null)
                        .addCommand("menu", new ExitMenuCommand(newMenu));

                break;
            case SEARCH:
                newMenu = new Menu(MenuType.SEARCH);
                newMenu.addCommand("[number]", null)
                        .addCommand("again", new SearchCommand(phoneBook))
                        .addCommand("back", new ExitMenuCommand(newMenu));
                break;
            case LIST:
                newMenu = new Menu(MenuType.LIST);
                newMenu.addCommand("[number]", null);
                newMenu.addCommand("back", new ExitMenuCommand(newMenu));
                break;
        }
        menus.add(newMenu);
        return newMenu;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
