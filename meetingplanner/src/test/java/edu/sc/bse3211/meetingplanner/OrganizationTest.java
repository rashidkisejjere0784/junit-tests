package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;


import java.util.ArrayList;

import org.junit.Test;

public class OrganizationTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.
    @Test
  public void testGetEmployees() {
    // Arrange
    Organization organization = new Organization();

    // Act
    ArrayList<Person> employees = organization.getEmployees();

    // Assert
    assertEquals(5, employees.size());
    assertEquals("Namugga Martha", employees.get(0).getName());
    assertEquals("Shema Collins", employees.get(1).getName());
    assertEquals("Acan Brenda", employees.get(2).getName());
    assertEquals("Kazibwe Julius", employees.get(3).getName());
    assertEquals("Kukunda Lynn", employees.get(4).getName());
  }
                                                                        
    @Test
    public void testGetRoom() throws Exception {
        // Arrange
        String testRoomID = "LLT6A";
        Organization org = new Organization();
        
        Room result = org.getRoom(testRoomID);
        
        assertEquals(testRoomID, result.getID());

        testRoomID = "";
        try {
            result = org.getRoom(testRoomID);
            fail("Should throw an exception on invalid values");
        } catch (Exception e) {
            assertTrue("Should throw an exception on invalid values", true);
        }
        
        
    }

    @Test
    public void testGetRoom_Invalid() throws Exception {
        // Arrange
        String testRoomID = "";
        Organization org = new Organization();

        try {
            Room result = org.getRoom(testRoomID);
            
            fail("System should have thrown exception since the room doesn't exists");
        } catch (Exception e) {
            assertTrue(true);
        }
        
    }

    /**
 * Tests the Organization class's getEmployee method.
 */
@Test
public void testGetEmployee() throws Exception {
    // Arrange
    final Organization org = new Organization();
    String validName = "Namugga Martha";
    final String invalidName = "Invalid Name";

    // Act
    Person validEmployee = extracted(org, validName);

    // Assert
    assertEquals(validName, validEmployee.getName());
    assertThrows(Exception.class, new Executable() {
        @Override
        public void execute() throws Throwable {
            extracted(org, invalidName);
        }
    });
}

/**
 * Extracts an employee from the Organization object based on the given name.
 *
 * @param org the Organization object
 * @param name the name of the employee
 * @return the Person object of the employee with the given name
 * @throws Exception if the employee with the given name is not found
 */
private Person extracted(Organization org, String name) throws Exception {
    return org.getEmployee(name);
}

}
