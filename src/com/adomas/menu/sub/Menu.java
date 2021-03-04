package com.adomas.menu.sub;

import com.adomas.menu.MenuType;
import com.adomas.phoneBookCommands.Command;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Data
public class Menu {

    protected boolean toExit = false;

    protected final MenuType menuType;
    private HashMap<String, Command> menuItems;


    public Menu(MenuType menuType) {
        this.menuType = menuType;
        this.menuItems = new LinkedHashMap<>();
    }

    public Menu addCommand(String name, Command command) {
        this.menuItems.putIfAbsent(name, command);
        return this;
    }

    public void setCommand(String name, Command command) {
        this.menuItems.put(name, command);
    }


    public void executeCommand(String name) {
        if (this.menuItems.containsKey(name)) {
            this.menuItems.get(name).execute();
        } else {
            System.out.println("Command not found!\n");
        }
    }

    public boolean exit() {
        return toExit = true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.menuType.getName()).append("]").append(" Enter action(");
        for (String key : menuItems.keySet()) {
            sb.append(key).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "): ");
        return sb.toString();
    }


}
