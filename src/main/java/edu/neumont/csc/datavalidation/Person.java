package edu.neumont.csc.datavalidation;

public class Person {
    public String name;
    public String ssn;
    public String email;
    public String phoneNumber;

    @Override
    public String toString()
    {
        return String.format("Name: %s\nSSN: %s\nEmail: %s\nPhone: %s", name, ssn, email, phoneNumber);
    }

    Person()
    {

    }

    Person(String name, String ssn, String email, String phoneNumber)
    {
        this.name = name;
        this.ssn = ssn;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}