package junit_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import helpers.DateTimeCheck;

public class JUnitTest {

	@Test
	public void testValidDateTimeFormat() {
		String validDateTime = "18/10/2023 15:30";
		assertTrue(DateTimeCheck.CheckValidity(validDateTime));
	}

	@Test
	public void testInvalidDateTimeFormat() {
		// Invalid format: missing time
		String invalidDateTime1 = "18/10/2023";
		assertFalse(DateTimeCheck.CheckValidity(invalidDateTime1));

		// Invalid format: incorrect date format
		String invalidDateTime2 = "2023/10/18 15:30";
		assertFalse(DateTimeCheck.CheckValidity(invalidDateTime2));

		// Invalid because of an empty string
		String invalidDateTime3 = "";
		assertFalse(DateTimeCheck.CheckValidity(invalidDateTime3));

		// Invalid because of the incorrect date and time format
		String invalidDateTime4 = "10-18-2023 2:30 PM";
		assertFalse(DateTimeCheck.CheckValidity(invalidDateTime4));
	}

}
