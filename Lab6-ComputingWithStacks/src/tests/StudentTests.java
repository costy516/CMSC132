package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import student_classes.CommonFunctions;

public class StudentTests {

	@Test
	public void test() 
	{
		assertTrue(CommonFunctions.isPalindrome("racecar"));
	}

}
