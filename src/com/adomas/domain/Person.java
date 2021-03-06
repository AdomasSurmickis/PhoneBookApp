package com.adomas.domain;

import lombok.Data;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
public class Person extends Contact  {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;


    public Person(int id) {
        super(id);
    }




    @Override
    public String getAllFieldsAsString() {
        return this.name + " " + this.surname + " " + this.number + " " + this.birthDate + " " + this.gender;
    }

    @Override
    public String getFullName() {
        return name + " " + surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setBirthDate(String birthDate) {
        try {
            this.birthDate = LocalDate.parse(birthDate);
            return true;
        } catch (DateTimeException e) {
            System.out.println("Bad date");
            return false;
        }
    }


    public void setGender(String gender) {
        if (gender.equals("M") || gender.equals("F")) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            gender = null;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Surname: " + surname + '\n' +
                "Birth date: " + (birthDate == null ? "[no data]" : birthDate.toString()) + '\n' +
                "Gender: " + (gender == null ? "[no data]" : gender) + '\n' +
                "Number: " + (number == null ? "[no data]" : number) + '\n' +
                "Time created: " + creationDate.truncatedTo(ChronoUnit.MINUTES) + '\n' +
                "Time last edit: " + lastEditDate.truncatedTo(ChronoUnit.MINUTES) + '\n';
    }


}
