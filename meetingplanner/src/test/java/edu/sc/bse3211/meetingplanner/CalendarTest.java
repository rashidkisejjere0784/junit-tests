package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class CalendarTest {
	// Add test methods here. 
	// You are not required to write tests for all classes.
	
	@Test
	public void testAddMeeting_holiday() {
		
		Calendar calendar = new Calendar();
		// Add to calendar object.
		try {
			Meeting janan = new Meeting(2, 16, "Janan Luwum");
			calendar.addMeeting(janan);
			// Verify that it was added.
			Boolean added = calendar.isBusy(2, 16, 0, 23);
			assertTrue("Janan Luwum Day should be marked as busy on the calendar",added);
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}

	@Test
	public void testAddMeeting_Null_Message(){
		// Create Janan Luwum holiday
		Calendar calendar = new Calendar();
		// Add to calendar object.
		try {
			Meeting janan = new Meeting(2, 16, null);
			calendar.addMeeting(janan);

			fail("System should input a valid description");
		} catch(TimeConflictException e) {
			assertTrue("System should fail", true);
		}
	}
	
	@Test
	public void testAddMeeting_OverlappingDates() {
		Calendar calender = new Calendar();

		Meeting meeting1 = new Meeting(1,2,"Meeting 1");
		Meeting meeting2 = new Meeting(1,2,"Meeting 2");
		try {
			calender.addMeeting(meeting1);
			calender.addMeeting(meeting2);

		fail("Overlapping Meetings should fail with an exception");
		} catch (TimeConflictException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testIsBusy_invalidDate() {
		// Check and Verify Invalid Dates
		Calendar calendar = new Calendar();
		
		try {
			Boolean isbusy = calendar.isBusy(30, 13, 1, 1);

			fail("Invalid date: " + isbusy);
		} catch (TimeConflictException e) {
			assertTrue("System threw an exception which is correct since the date is Invalid", true);
		}
	}

	@Test
  public void clearSchedule_validInput_clearsDay() throws TimeConflictException {
    // Arrange
    int month = 1;
    int day = 1;
    ArrayList<Meeting> meetings = new ArrayList<>();
	Calendar calendar = new Calendar();
    Meeting meeting = new Meeting(month, day, "test meeting");
    meetings.add(meeting);


    // Act
    calendar.clearSchedule(month, day);
    boolean isBusy = calendar.isBusy(month, day, 0, 23);

    // Assert
    assertEquals(false, isBusy);
  }


  @Test
  public void testGetMeeting() throws TimeConflictException {
    // Arrange
    Calendar calendar = new Calendar();
    Meeting meeting1 = new Meeting(1, 1, "test meeting 1");
    Meeting meeting2 = new Meeting(2, 2, "test meeting 2");
	
    calendar.addMeeting(meeting1);
    calendar.addMeeting(meeting2);

    // Act
    Meeting retrievedMeeting1 = calendar.getMeeting(1, 1, 0);
    Meeting retrievedMeeting2 = calendar.getMeeting(2, 2, 0);

    // Assert
    assertEquals(meeting1, retrievedMeeting1);
    assertEquals(meeting2, retrievedMeeting2);
  }

  @Test
  public void printAgenda() throws TimeConflictException {
    // Arrange
    Calendar calendar = new Calendar();
    Meeting meeting1 = new Meeting(1, 1, "Meeting 1");
    Meeting meeting2 = new Meeting(1, 2, "Meeting 2");
    calendar.addMeeting(meeting1);
    calendar.addMeeting(meeting2);

    // Act
    String actual = calendar.printAgenda(1);

    // Assert
    String expected = "Agenda for 1:\n" + meeting1 + "\n" + meeting2 + "\n";
    assertEquals(expected, actual);
  }
}
