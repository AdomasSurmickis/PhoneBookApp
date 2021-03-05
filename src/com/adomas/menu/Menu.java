package com.adomas.menu;

import com.adomas.command.Command;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Data
public class Menu {

    public void setToExit(boolean toExit) {
        this.toExit = toExit;
    }

    private boolean toExit = false;

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
            System.out.println("Command not found!");
        }
    }

    public boolean exit() {
        return toExit = true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n[");
        sb.append(this.menuType.getName()).append("]").append(" Enter action(");
        for (String key : menuItems.keySet()) {
            sb.append(key).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "): ");
        return sb.toString();
    }


}
