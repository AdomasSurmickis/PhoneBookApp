package com.adomas;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Stream;

public abstract class Contact implements Serializable {
    private int id;
    protected String number;
    protected LocalDateTime creationDate;
    protected LocalDateTime lastEditDate;

    public Contact() {
        this.creationDate = LocalDateTime.now();
        this.lastEditDate = LocalDateTime.now();
    }

    public Contact(int id) {
        this();
        this.id = id;
    }


    public boolean hasNumber() {
        return (number != null && !number.equals(""));
    }

    public abstract String getFullName();

    public abstract String getAllFieldsAsString();


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        if (number != null && Util.isPhoneValid(number)) {
            this.number = number;
        } else {
            this.number = null;
        }
    }

    public boolean isPerson() {
        return this instanceof contacts.Person;
    }

    public List<Field> getEditableFields() {
        List<Field> list = new ArrayList<>(Arrays.asList(this.getClass().getDeclaredFields()));
        list.addAll(Arrays.asList(this.getClass().getSuperclass().getDeclaredFields()));
        return list;
    }

    public void printEditableOptions() {
        System.out.print("Select a field (");
        String fieldPrint = "";
        for (Field f : getEditableFields()) {
            String name = f.getName();
            if (name.equals("birthDate")) {
                fieldPrint = fieldPrint.concat("birth, ");
                continue;
            } else if (name.equals("creationDate") || name.equals("lastEditDate") || name.equals("id")) {
                continue;
            }
            fieldPrint = fieldPrint.concat(f.getName() + ", ");
        }
        fieldPrint = fieldPrint.substring(0, fieldPrint.length() - 2);
        System.out.print(fieldPrint + "): ");
    }

    public <T> void editField(String fieldName, T value) {
        Class<?> type;

        Optional<Field> field = Stream.of(this.getClass().getDeclaredFields(), this.getClass().getSuperclass().getDeclaredFields())
                .flatMap(Arrays::stream).filter(f -> f.getName().equals(fieldName)).findFirst();

        try {
            type = field.orElseThrow(() -> new RuntimeException("No matching field found")).getType();
            if (value.getClass().getName().equals(type.getName())) {
                Method setter = this.getClass().getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), value.getClass());
                setter.invoke(this, value);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Unable to set field" + e.getMessage());
        }
    }

    public <T> T getField(String fieldName) {
        try {
            Method setter = this.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            return (T) setter.invoke(this);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Unable to get field" + e.getMessage());
        }
        return null;
    }

    public boolean updateContactField(Scanner sc, String fieldName) {
        switch (fieldName) {
            case "name":
                System.out.print("Enter name: ");
                editField(fieldName, sc.nextLine());
                return true;
            case "surname":
                System.out.print("Enter the surname: ");
                editField(fieldName, sc.nextLine());
                return true;
            case "birthDate":
            case "birth":
                System.out.print("Enter the birth date: ");
                LocalDate birthDate;
                try {
                    birthDate = LocalDate.parse(sc.nextLine());
                    editField("birthDate", birthDate);
                    return true;
                } catch (DateTimeParseException e) {
                    System.out.println("Bad birth date");
                    return false;
                }
            case "gender":
                System.out.print("Enter the gender (M, F): ");
                String gender = sc.nextLine();
                if (gender.equals("M") || gender.equals("F")) {
                    editField(fieldName, gender);
                    return true;
                } else {
                    System.out.println("Bad gender!");
                    return false;
                }
            case "number":
                System.out.print("Enter the number: ");
                String number = sc.nextLine();
                if (Util.isPhoneValid(number)) {
                    editField(fieldName, number);
                    return true;
                } else {
                    System.out.println("Number invalid");
                    return false;
                }
            case "organizationName":
                System.out.print("Enter the organization name: ");
                editField(fieldName, sc.nextLine());
                return true;
            case "address":
                System.out.print("Enter the address: ");
                editField(fieldName, sc.nextLine());
                return true;
        }
        return false;
    }


    //    A method that returns all of the possible fields this class is able to change.
//    A method that takes a string that represents a field that the class is able to change and its new value.
//    A method that takes a string representation of the field and returns the value of this field.

}
