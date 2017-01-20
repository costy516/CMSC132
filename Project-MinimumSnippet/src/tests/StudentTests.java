package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import student_classes.MinimumSnippet;

public class StudentTests {

	@Test
	public void testMinimumSnippetOneTerm() {
		Iterable<String> document = new ArrayList<String> (Arrays.asList("A", "B", "C", "A", "D", "Z", "X", "C"));
		List <String> terms = new ArrayList<String> (Arrays.asList("C"));
		MinimumSnippet miniSnip = new MinimumSnippet(document, terms);
		System.out.println("getPos" + miniSnip.getPos(0));
		assertEquals("C", miniSnip.toString());
		//("Not yet implemented");
	}
	@Test
	public void testMinimumSnippetTwoTerm() {
		Iterable<String> document = new ArrayList<String> (Arrays.asList("A", "B", "C", "A", "D", "Z", "X", "C"));
		List <String> terms = new ArrayList<String> (Arrays.asList("Z", "C"));
		MinimumSnippet miniSnip = new MinimumSnippet(document, terms);
		assertEquals("ZXC", miniSnip.toString());
		
		Iterable<String> doc1 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms1 = new ArrayList<String> (Arrays.asList("Y", "O"));
		MinimumSnippet snippet1 = new MinimumSnippet(doc1, terms1);
		assertEquals("OY", snippet1.toString());
		//("Not yet implemented");
	}
	@Test
	public void testMinimumSnippetThreeTerm() {
		Iterable<String> document = new ArrayList<String> (Arrays.asList("A", "B", "C", "A", "D", "Z", "X", "C"));
		List <String> terms = new ArrayList<String> (Arrays.asList("Z", "C", "X"));
		MinimumSnippet miniSnip = new MinimumSnippet(document, terms);
		assertEquals("ZXC", miniSnip.toString());
		
		Iterable<String> doc2 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms2 = new ArrayList<String> (Arrays.asList("Y", "O", "C"));
		MinimumSnippet snippet2 = new MinimumSnippet(doc2, terms2);
		assertEquals("YCO", snippet2.toString());
		//("Not yet implemented");
	}
	@Test
	public void testMinimumSnippetFourTerm() {
		Iterable<String> document = new ArrayList<String> (Arrays.asList("A", "B", "C", "A", "D", "Z", "X", "C"));
		List <String> terms = new ArrayList<String> (Arrays.asList("Z", "A", "C", "D"));
		MinimumSnippet miniSnip = new MinimumSnippet(document, terms);
		assertEquals("CADZ", miniSnip.toString());
		//("Not yet implemented");
	}
	

	@Test
	public void testFoundAllTerms1() {
		
		Iterable<String> doc1 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms1 = new ArrayList<String> (Arrays.asList("Y", "O"));
		MinimumSnippet snippet1 = new MinimumSnippet(doc1, terms1);
		assertTrue("True",snippet1.foundAllTerms() == true);
		
		Iterable<String> doc2 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "D", "N", "Y"));
		List<String> terms2 = new ArrayList<String> (Arrays.asList("Y", "O"));
		MinimumSnippet snippet2 = new MinimumSnippet(doc2, terms2);
		assertTrue("False", snippet2.foundAllTerms() == false);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetStartingPos1() {
		
		Iterable<String> doc1 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms1 = new ArrayList<String> (Arrays.asList("Y", "O"));
		MinimumSnippet snippet1 = new MinimumSnippet(doc1, terms1);
		System.out.println("yolo " + snippet1.getStartingPos());
		assertTrue(("Two Terms: was " + snippet1.getStartingPos() + " should be 6"),snippet1.getStartingPos() == 6);
		
		
		Iterable<String> doc2 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms2 = new ArrayList<String> (Arrays.asList("D", "O", "T"));
		MinimumSnippet snippet2 = new MinimumSnippet(doc2, terms2);
		assertTrue("Three Terms",snippet2.getStartingPos() == 0);
		
		Iterable<String> doc3 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms3 = new ArrayList<String> (Arrays.asList("D", "O", "T", "Y"));
		MinimumSnippet snippet3 = new MinimumSnippet(doc3, terms3);
		assertTrue("Four Terms",snippet3.getStartingPos() == 0);
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetEndingPos1() {
		
		Iterable<String> doc1 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms1 = new ArrayList<String> (Arrays.asList("Y", "O"));
		MinimumSnippet snippet1 = new MinimumSnippet(doc1, terms1);
		System.out.println("snippet ending pos = " + snippet1.getEndingPos());
		assertTrue(("Two Terms: was " + snippet1.getEndingPos() + " should be 7"),snippet1.getEndingPos() == 7);
		
		
		Iterable<String> doc2 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms2 = new ArrayList<String> (Arrays.asList("D", "O", "T"));
		MinimumSnippet snippet2 = new MinimumSnippet(doc2, terms2);
		assertTrue("Three Terms",snippet2.getEndingPos() == 4);
		
		Iterable<String> doc3 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms3 = new ArrayList<String> (Arrays.asList("D", "O", "T", "Y"));
		MinimumSnippet snippet3 = new MinimumSnippet(doc3, terms3);
		assertTrue("Four Terms",snippet3.getEndingPos() == 4);
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetLength1() {
		
		Iterable<String> doc3 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms3 = new ArrayList<String> (Arrays.asList("O"));
		MinimumSnippet snippet3 = new MinimumSnippet(doc3, terms3);
		System.out.println("snippet3.getLength() = " +  snippet3.getLength());
		assertTrue("One Term",snippet3.getLength() == 1);
		
		Iterable<String> doc1 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms1 = new ArrayList<String> (Arrays.asList("C", "O"));
		MinimumSnippet snippet1 = new MinimumSnippet(doc1, terms1);
		assertTrue("Two Terms", snippet1.getLength() == 2);
	
		Iterable<String> doc2 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms2 = new ArrayList<String> (Arrays.asList("Y", "O", "C"));
		MinimumSnippet snippet2 = new MinimumSnippet(doc2, terms2);
		System.out.println("snippet2.getLength(3) = " +  snippet2.getLength());
		assertTrue("Three Terms", snippet2.getLength() == 3);
	
		Iterable<String> doc4 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms4 = new ArrayList<String> (Arrays.asList("Y", "O", "C", "N"));
		MinimumSnippet snippet4 = new MinimumSnippet(doc4, terms4);
		assertTrue("Four Terms", snippet4.getLength() == 5);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPos1() {
		Iterable<String> doc3 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms3 = new ArrayList<String> (Arrays.asList("Y"));
		MinimumSnippet snippet3 = new MinimumSnippet(doc3, terms3);
		assertTrue("One Term",snippet3.getPos(0) == 1);
		
		Iterable<String> doc1 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms1 = new ArrayList<String> (Arrays.asList("Y", "O"));
		MinimumSnippet snippet1 = new MinimumSnippet(doc1, terms1);
		System.out.println("snippet1.getPos(1) = " +  snippet1.getPos(1));
		assertTrue("Two Terms, First Term",snippet1.getPos(0) == 7);
		assertTrue("Two Terms, Second Term",snippet1.getPos(1) == 6);
		
		Iterable<String> doc4 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms4 = new ArrayList<String> (Arrays.asList("Y", "O", "D"));
		MinimumSnippet snippet4 = new MinimumSnippet(doc4, terms4);
		assertTrue("Three Terms, First Term", snippet4.getPos(0) == 1);
		assertTrue("Three Terms, Second Term", snippet4.getPos(1) == 3);
		assertTrue("Three Terms, Third Term",snippet4.getPos(2) == 4);
		
		Iterable<String> doc5 = new ArrayList<String> (Arrays.asList("T", "Y", "C", "O", "D", "N", "O", "Y"));
		List<String> terms5 = new ArrayList<String> (Arrays.asList("Y", "O", "D", "N"));
		MinimumSnippet snippet5 = new MinimumSnippet(doc5, terms5);
//		System.out.println("snippet5.getPos(0) = " +  snippet5.getPos(0));
//		System.out.println("snippet5.getPos(1) = " +  snippet5.getPos(1));
//		System.out.println("snippet5.getPos(2) = " +  snippet5.getPos(2));
//		System.out.println("snippet5.getPos(3) = " +  snippet5.getPos(3));
		assertTrue("Four Terms, First Term", snippet5.getPos(0) == 7);
		assertTrue("Four Terms, Second Term", snippet5.getPos(1) == 6);
		assertTrue("Four Terms, Third Term",snippet5.getPos(2) == 4);
		assertTrue("Four Terms, Fourth Term",snippet5.getPos(3) == 5);
	
		
		//fail("Not yet implemented");
	}


}
	
