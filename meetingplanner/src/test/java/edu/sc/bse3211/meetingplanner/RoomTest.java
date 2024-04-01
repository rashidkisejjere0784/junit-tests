package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class RoomTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void testGetID() {
        Room room = new Room();
        String expected = "";
        String actual = room.getID();
        assertEquals(expected, actual);
    }

    @Test
    public void addMeeting_conflict_throwsTimeConflictException() {
        final Room room = new Room("123");

        final Meeting m1 = new Meeting(1, 1, 1, 1);
        final Meeting m2 = new Meeting(1, 1, 2, 2);
        
        assertThrows(TimeConflictException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                room.addMeeting(m1);
                room.addMeeting(m2);
            }
        });

        // Attempt to add meetings and catch the exception to check the message
        TimeConflictException exception = assertThrows(TimeConflictException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                room.addMeeting(m1);
                room.addMeeting(m2);
            }
        });

        // Construct the expected message
        String expectedMessage = "Conflict for room 123:\nMeeting starts before it ends.";

        // Assert that the message in the exception is as expected
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void isBusy_noMeetings_returnsFalse() throws TimeConflictException {
        final Room room = new Room("123");

        // Arrange
        int month = 1, day = 1, start = 10, end = 15;

        // Act
        boolean isBusy = room.isBusy(month, day, start, end);

        // Assert
        assertFalse("Expected isBusy to return false when there are no meetings.", isBusy);

    }

    @Test
    public void isBusy_withMeeting_returnsTrue() throws TimeConflictException {
        final Room room = new Room("123");

        // Arrange
        Meeting meeting = new Meeting(1, 1, "Meeting Title");
        room.addMeeting(meeting);

        int month = 1, day = 1, start = 10, end = 15;

        // Act
        boolean isBusy = room.isBusy(month, day, start, end);

        // Assert
        assertTrue("Expected isBusy to return true when there is a meeting during the given timeframe.", isBusy);

    }

}
