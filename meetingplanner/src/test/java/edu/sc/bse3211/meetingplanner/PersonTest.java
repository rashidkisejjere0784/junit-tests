package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void addMeeting() throws TimeConflictException {
      // Arrange
      Person person = new Person("John Doe");
      Meeting meeting = new Meeting(10, 30);
  
      person.addMeeting(meeting);

      Meeting expected = person.getMeeting(10, 30, 0);
      
      assertEquals(meeting, expected);
      
    }

    @Test
  public void CheckAddingMultipleMeetings() throws TimeConflictException {
    // Arrange
    Person person = new Person("John Doe");
    Meeting meeting1 = new Meeting(1, 1, 1, 1);
    Meeting meeting2 = new Meeting(2, 2, 2, 2);
    try {
      person.addMeeting(meeting1);
      person.addMeeting(meeting2);

      assertTrue("Meetings were added successfully", true);
    } catch (Exception e) {
      assertFalse("No exception was meant to be thrown", true);
    }
    
  }

  @Test
    public void testIsBusy() throws TimeConflictException {
        // create a new person with name John
        Person person = new Person("John");
        
        // create a new meeting for John
        Meeting meeting = new Meeting(1, 30, 1, 30);
        
        // add the meeting to the person's calendar
        person.addMeeting(meeting);
        
        // check if the meeting is busy for the timeframe 11:00-12:00
        boolean isBusy = person.isBusy(1, 11, 11, 12);
        
        // assert that the meeting is indeed busy during that timeframe
        assertTrue(isBusy);
    }
 
}
