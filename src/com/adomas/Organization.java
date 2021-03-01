package com.adomas;

import java.time.temporal.ChronoUnit;

public class Organization extends Contact {
    private String name;
    private String address;



    public Organization(int id) {
        super(id);
    }

    @Override
    public String getFullName() {
        return name;
    }

    @Override
    public String getAllFieldsAsString() {
        return this.name + " " + this.number + " " + this.address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;


    }


    public String getName() {
        return name;
    }

    public void setName(String organizationName) {
        this.name = organizationName;
    }

    @Override
    public String toString() {
        return "Organization name: " + name + '\n' +
                "Address: " + address + '\n' +
                "Number: " + (number == null ? "[no data]" : number) + '\n' +
                "Time created: " + creationDate.truncatedTo(ChronoUnit.MINUTES) + '\n' +
                "Time last edit: " + lastEditDate.truncatedTo(ChronoUnit.MINUTES) + '\n';
    }
}
