package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeetingTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void addAttendee() {
        // Arrange
        Meeting meeting = new Meeting();
        Person person = new Person("John");
        Person person2 = new Person("Jane");

        meeting.addAttendee(person);
        assertTrue(meeting.getAttendees().contains(person));
        assertFalse(meeting.getAttendees().contains(person2));
    }

    @Test
    public void testAddAttendeeNull(){
        // Arrange
        Meeting meeting = new Meeting();

        try {
            meeting.addAttendee(null);
            fail("Exception is expected since person does not exist");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void removeAttendeeTest() {
        // Arrange
        Meeting meeting = new Meeting();
        Person person1 = new Person("John");
        Person person2 = new Person("Jane");
        meeting.addAttendee(person1);
        meeting.addAttendee(person2);

        // Act
        meeting.removeAttendee(person1);

        // Assert
        assertFalse(meeting.getAttendees().contains(person1));
        assertTrue(meeting.getAttendees().contains(person2));
    }

    @Test
    public void removeNotAvailableAttendee() {
        // Arrange
        Meeting meeting = new Meeting();
        Person person1 = new Person("John");

        try {
            meeting.removeAttendee(person1);
            fail("Exception is expected since person does not exist");
        } catch (Exception e) {
            assertTrue(true);
        }

    }

    /**
 * Tests the setMonth method of the Meeting class.
 */
@Test
public void testSetMonth() {
    Meeting meeting = new Meeting();
    meeting.setMonth(1);
    assertEquals(1, meeting.getMonth());
    meeting.setMonth(13);
    assertEquals(13, meeting.getMonth());
}

@Test
public void testInvalidMonth(){
    Meeting meeting = new Meeting();
    try {
        meeting.setMonth(-1);
        fail("Exception is expected since month is invalid");
    } catch (Exception e) {
        assertTrue(true);
    }
}
}
