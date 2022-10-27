package edu.neumont.csc.datavalidation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    public DataValidation validator = new DataValidation();
    /**
     * Rigorous Test.
     */
    Person personFail = new Person("123", "123-2A-2222", "Fail", "707-A07-0707");
    Person personPass = new Person("Jerry Jar", "123-23-2222", "jerryjarsjars@jar.co", "707-707-0707");
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testPersonFailName() {
        // Create a Person with fields that will cause the validations to fail.
        /*
         * Tests Bools
         */
        Boolean validName = validator.isValidHumanName(personFail.name);
        assertEquals(false, validName);
    }

    @Test
    void testPersonFailEmail() {
        Boolean validEmail = validator.isValidEmailAddress(personFail.email);
        assertEquals(false, validEmail);
    }
    @Test 
    void testPersonFailSSN()
    {
        Boolean validSSN = validator.isValidSSN(personFail.ssn);
        assertEquals(false, validSSN);
    }
    @Test
    void testPersonFailPhone()
    {
        Boolean validPhone = validator.isValidPhoneNumber(personFail.phoneNumber);
        assertEquals(false, validPhone);
    }
    @Test
    void testPersonPassName() {
        // Create a Person with fields that will cause the validations to fail.
        /*
         * Tests Bools
         */
        Boolean validName = validator.isValidHumanName(personPass.name);
        assertEquals(true, validName);
    }

    @Test
    void testPersonPassEmail() {
        Boolean validEmail = validator.isValidEmailAddress(personPass.email);
        assertEquals(true, validEmail);
    }
    @Test 
    void testPersonPassSSN()
    {
        Boolean validSSN = validator.isValidSSN(personPass.ssn);
        assertEquals(true, validSSN);
    }
    @Test
    void testPersonPassPhone()
    {
        Boolean validPhone = validator.isValidPhoneNumber(personPass.phoneNumber);
        assertEquals(true, validPhone);
    }
}
