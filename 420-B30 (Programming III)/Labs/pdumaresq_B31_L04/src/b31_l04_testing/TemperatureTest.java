package b31_l04_testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemperatureTest {

	// public void testTemperature() {
	// fail("Not yet implemented");
	// }
	@Test
	public void testCase1() {
		// Test the instantiation of a Temperature object using default values
		// for the attributes.
		Temperature t1 = new Temperature();
		// verify that the temperature has been correctly set
		assertEquals("Test Case 1: getTemperature()", 0.0, t1.getTemperature(), 0.000001);
		// verify that the units have been correctly set
		assertEquals("Test Case 1: getUnits ()", 'C', t1.getUnits());
	} // testCase1()

	@Test
	public void testCase2() {
		Temperature t2 = new Temperature(24.0, 'C');
		assertEquals("Test case 2: getTemperature()", 24.0, t2.getTemperature(), 0.000001);
		assertEquals("Test case 2: getUnits()", 'C', t2.getUnits());
	}

	@Test
	public void testCase3() {
		Temperature t3 = new Temperature(84.0, 'F');
		assertEquals("Test case 3: getTemperature()", 84.0, t3.getTemperature(), 0.000001);
		assertEquals("Test case 3: getUnits()", 'F', t3.getUnits());
	}

	@SuppressWarnings("unused")
	@Test
	public void testCase4() {
		// Test the instantiation of a Temperature object using illegal values
		// for the attributes.
		try {
			// Try to instantiate a Temperature object with an invalid unit type
			Temperature t4 = new Temperature(24.0, 'A');
			// If the program gets here, the exception wasn't thrown
			fail("Test case 4 - IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			assertTrue(true); // It worked
		}
	}
	
	@Test 
	public void testCase5() {
		Temperature t5 = new Temperature(24.0,'C');
		t5.setTemperature(56.5);
		assertEquals("Test case 5: getTemperature()", 56.5, t5.getTemperature(), 0.000001);
	}
	
	@Test 
	public void testCase6() {
		Temperature t6 = new Temperature(24.0,'C');
		t6.setUnits('F');
		assertEquals("Test case 6: getUnits()", 'F', t6.getUnits());
	}
	
	@Test 
	public void testCase7() {
		Temperature t7 = new Temperature(24.0,'C');
		try {
			t7.setUnits('X');
			fail("Test case 7: IllegalArgumentException was not thrown");
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCase8() {
		Temperature t8 = new Temperature(100.0, 'C');
		assertEquals("Test case 8: getCelsius()", 100.0, t8.getCelsius(), 0.000001);
		t8.setUnits('F');
		assertEquals("Test case 8: getCelsius()", 37.7777778, t8.getCelsius(), 0.000001);
	}
	@Test
	public void testCase9() {
		Temperature t9 = new Temperature(37.7777778, 'F');
		assertEquals("Test case 9: getFahrenheit()", 37.7777778, t9.getFahrenheit(), 0.000001);
		t9.setUnits('C');
		assertEquals("Test case 9: getFahrenheit()", 100.0, t9.getFahrenheit(), 0.000001);
	}
	
	
}
