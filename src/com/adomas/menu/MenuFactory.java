package com.adomas.menu;

import com.adomas.menu.sub.ListMenu;
import com.adomas.menu.sub.Menu;
import com.adomas.menu.sub.RecordMenu;
import com.adomas.menu.sub.SearchMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {
    List<Menu> menus = new ArrayList<>();
    private static MenuFactory factory;

    public MenuFactory() {
    }

    public static MenuFactory getInstance() {
        return factory == null ? new MenuFactory() : factory;
    }

    public Menu createOrGetMenu(MenuType type) {
        Menu newMenu = null;
        for (Menu menu : menus) {
            if (menu.getType().equals(type)) {
                return menu;
            }
        }
        switch (type) {
            case RECORD:
                newMenu = new RecordMenu(MenuType.RECORD);
                break;
            case SEARCH:
                newMenu = new SearchMenu(MenuType.SEARCH);
                break;
            case LIST:
                newMenu = new ListMenu(MenuType.LIST);
        }
        menus.add(newMenu);
        return newMenu;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
