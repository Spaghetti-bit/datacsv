package edu.neumont.csc.datavalidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Person> people = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\LaptopNeumont-Sage\\CSC180 Workspace DIR\\datacsv\\people-2.to.regex.csv"));
            // Skip first line (name, ssn, email, phone)
            br.readLine();
            String line = "";
            DataValidation validator = new DataValidation();
            Field[] personFields = Person.class.getFields();
            while ((line = br.readLine()) != null)
            {
                Person person = new Person();
                // CSV :)
                String[] personStrArray = line.split(",");
                // Iterate through fields AND the personStrArray, hydrate with valid data.
                for (int i = 0; i < personStrArray.length && i < personFields.length; i++)
                {
                    //Validate data.
                    /*
                    * name
                    * ssn
                    * email
                    * phone
                    */
                    personFields[i].set(person, personStrArray[i]);
                }
                // Validate data
                Boolean validName = validator.isValidHumanName(person.name);
                Boolean validSSN = validator.isValidSSN(person.ssn);
                Boolean validPhone = validator.isValidPhoneNumber(person.phoneNumber);
                Boolean validEmail = validator.isValidHumanName(person.email);
    
                if (validName && validSSN && validPhone && validEmail)
                {
                    people.add(person);
                }
            }
        } catch (Exception e)
        {

        }
    }
}