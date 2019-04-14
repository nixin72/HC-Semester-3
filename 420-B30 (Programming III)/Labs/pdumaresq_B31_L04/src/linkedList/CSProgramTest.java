package linkedList;

import static org.junit.Assert.*;
import org.junit.Test;

public class CSProgramTest {
	@Test
	public void testCase1() {
		CSProgram prog = new CSProgram();
		assertEquals("Test case 1: Testing getHours()", 20, prog.getHours(5));
	}

	@Test
	public void testCase2() {
		CSProgram prog = new CSProgram();
		assertEquals("Test case 2: Testing getHours()", 19, prog.getHours(4));
	}

	@Test
	public void testCase3() {
		CSProgram prog = new CSProgram();
		try {
			prog.getHours(0);
			fail("Should throw IllegalArgumentException since semester is less than 1");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testCase4() {
		CSProgram prog = new CSProgram();
		try {
			prog.getHours(9000);
			fail("Should throw IllegalArgumentException since semester is less than 1");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testCase5() {
		Course course1 = new Course("420-A11", "Operating Systems");
		Course course2 = new Course("420-A11", "Operating Systems");
		assertEquals("Test case 5: comparing two identical courses", true, course1.equals(course2));
	}

	@Test
	public void testCase6() {
		Course course1 = new Course("420-A11", "Operating Systems");
		Course course3 = new Course("420-A12", "Operating Systems");
		assertEquals("Test case 5: comparing two identical courses", false, course1.equals(course3));
	}

	@Test
	public void testCase7() {
		Course course1 = new Course("420-A11", "Operating Systems");
		Course course4 = new Course("420-A11", "Something else");
		assertEquals("Test case 5: comparing two identical courses", true, course1.equals(course4));
	}
}