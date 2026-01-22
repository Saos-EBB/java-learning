package src;

import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setFirstNameTestInvalids() throws InvalidNameException {
    Person p = new Person("Kevin","Schaberl");
    assertEquals("Kevin" , "!1234!");
    }

    @Test
    void setLastName() throws InvalidNameException {
        Person p = new Person("Kevin","Schaberl");
        assertEquals("Schaberl" , "Schaberl!");
    }



    @Test
    void getName() throws ItemNotFoundException, InvalidNameException {
        Person p = new Person("Kevin","Schaberl");




    }
}