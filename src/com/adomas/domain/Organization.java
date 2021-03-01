package com.adomas.domain;

import lombok.Data;

import java.time.temporal.ChronoUnit;

@Data
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

    @Override
    public String toString() {
        return "Organization name: " + name + '\n' +
                "Address: " + address + '\n' +
                "Number: " + (number == null ? "[no data]" : number) + '\n' +
                "Time created: " + creationDate.truncatedTo(ChronoUnit.MINUTES) + '\n' +
                "Time last edit: " + lastEditDate.truncatedTo(ChronoUnit.MINUTES) + '\n';
    }
}
