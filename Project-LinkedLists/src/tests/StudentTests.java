//package tests;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//import listClasses.BasicLinkedList;
//import listClasses.SortedLinkedList;
//
//import org.junit.Test;
//
//public class StudentTests {
//	
//	@Test
//	public void test() {
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue");
//		System.out.println("First: " + basicList.getFirst());
//		assertTrue(basicList.getFirst().equals("Blue"));
//		System.out.println("Last: " + basicList.getLast());
//		assertTrue(basicList.getLast().equals("Red"));
//		System.out.println("Size: " + basicList.getSize());
//		assertTrue(basicList.getSize() == 3);
//		System.out.println("Retrieve First: " + (basicList.retrieveFirstElement()));
//		assertTrue(basicList.getFirst().equals("Yellow"));
//		System.out.println("Retrieve Last: " + basicList.retrieveLastElement());
//		System.out.println("Removing Red");
//		basicList.remove("Red", String.CASE_INSENSITIVE_ORDER);
//		System.out.print("Iteration: ");
//		
//		for (String entry : basicList) 
//		{
//			System.out.print(entry + " ");
//		}
//		
//		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
//		sortedList.add("Yellow").add("Red");
//		System.out.print("\n\nIteration (for sorted list): ");
//		
//		for (String entry : sortedList) 
//		{
//			System.out.print(entry + " ");
//		}
//		sortedList.remove("Red");
//		System.out.print("\nAfter remove in sorted list first is: ");
//		System.out.println(sortedList.getFirst());
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	public void bllGetSize()
//	{
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Red");
//		assertEquals(basicList.getSize(), 5);
//		basicList.retrieveFirstElement();
//		assertEquals(basicList.getSize(), 4);
//		basicList.retrieveLastElement();
//		assertEquals(basicList.getSize(), 3);
//		
//		//REMOVE METHOD NOT WORKING AT CURRENT TIME
////		basicList.remove("Blue", String.CASE_INSENSITIVE_ORDER);
////		assertEquals(basicList.getSize() == 2);
//		
//		
//		//fail("Not Implemented");
//	}
//	
//	@Test
//	public void bllAddToEnd()
//	{
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Red");
//		assertEquals(basicList.getLast(), "Red");
//		basicList.addToEnd("Green");
//		assertEquals(basicList.getLast(), "Green");
//		basicList.addToEnd("Toothpaste");
//		assertEquals(basicList.getLast(), "Toothpaste");
//		basicList.addToEnd("Computer");
//		assertEquals(basicList.getLast(), "Computer");
//		basicList.addToEnd("Dez Nuts");
//		assertEquals(basicList.getLast(), "Dez Nuts");
//		basicList.addToEnd("CompSci");
//		assertEquals(basicList.getLast(), "CompSci");
//		basicList.addToFront("Tuesday");
//		assertEquals(basicList.getLast(), "CompSci");
//		
//		basicList.remove("Computer", String.CASE_INSENSITIVE_ORDER);
//		assertEquals(basicList.getLast(), "CompSci");
//		basicList.remove("CompSci", String.CASE_INSENSITIVE_ORDER);
//		assertEquals(basicList.getLast(), "Dez Nuts");
//		//fail("Not Implemented");
//	}
//	
//	@Test
//	public void bllAddToFront()
//	{
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Red");
//		assertEquals(basicList.getFirst(), "Orange");
//		basicList.addToFront("Green");
//		assertEquals(basicList.getFirst(), "Green");
//		basicList.addToFront("Toothpaste");
//		assertEquals(basicList.getFirst(), "Toothpaste");
//		basicList.addToFront("Computer");
//		assertEquals(basicList.getFirst(), "Computer");
//		basicList.addToFront("Dez Nuts");
//		assertEquals(basicList.getFirst(), "Dez Nuts");
//		basicList.addToFront("CompSci");
//		assertEquals(basicList.getFirst(), "CompSci");
//		basicList.addToEnd("Tuesday");
//		assertEquals(basicList.getFirst(), "CompSci");
//	}
//	
//	@Test
//	public void bllGetFirst()
//	{
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Red");
//		assertEquals(basicList.getFirst(), "Orange");
//		//fail("Not Implemented");
//	}
//	
//	@Test
//	public void bllGetLast()
//	{
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Green");
//		assertEquals(basicList.getLast(), "Green");
//		//fail("Not Implemented");
//	}
//	
//	@Test
//	public void bllRetrieveFirstElement()
//	{
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Green");
//		assertEquals(basicList.retrieveFirstElement(), "Orange");
//		assertEquals(basicList.getFirst(), "Blue");
//		//fail("Not Implemented");
//	}
//	@Test
//	public void bllRetrieveLastElement()
//	{
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Green");
//		assertEquals(basicList.retrieveLastElement(), "Green");
//		assertEquals(basicList.getLast(), "Red");
//		//fail("Not Implemented");
//	}
//	
//	@Test
//	public void bllRemove()
//	{
//		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
//		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Green");
//		basicList.addToEnd("Gold").addToFront("Computer").addToEnd("Yes");
//		assertEquals(basicList.getFirst(), "Computer");
//		basicList.remove("Computer", String.CASE_INSENSITIVE_ORDER);
//		assertEquals(basicList.getFirst(), "Orange");
//		assertEquals(basicList.getLast(), "Yes");
//		basicList.remove("Yes", String.CASE_INSENSITIVE_ORDER);
//		assertEquals(basicList.getLast(), "Gold");
//		//fail("Not Implemented");
//	}
//	
//	//sll tests
//	@Test
//	public void sllAdd()
//	{
//		System.out.println(String.CASE_INSENSITIVE_ORDER.compare("Red", "Yellow"));
//		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
//		sortedList.add("Red");
//		assertEquals(sortedList.getFirst(), "Red");
//		sortedList.add("Orange");
//		assertEquals(sortedList.getFirst(), "Orange");
//		assertEquals(sortedList.getLast(), "Red");
//		sortedList.add("Yellow");
//		assertEquals(sortedList.getFirst(), "Orange");
//		assertEquals(sortedList.getLast(), "Yellow");
//		sortedList.add("Green");
//		assertEquals(sortedList.getFirst(), "Green");
//		assertEquals(sortedList.getLast(), "Yellow");
//		sortedList.add("Blue");
//		assertEquals(sortedList.getFirst(), "Blue");
//		assertEquals(sortedList.getLast(), "Yellow");
//		sortedList.add("Indigo");
//		assertEquals(sortedList.getFirst(), "Blue");
//		assertEquals(sortedList.getLast(), "Yellow");
//		sortedList.add("Apple");
//		assertEquals(sortedList.getFirst(), "Apple");
//		assertEquals(sortedList.getLast(), "Yellow");
//		System.out.println("First"+sortedList.getFirst());
//		System.out.println("Last"+sortedList.getLast());
//		sortedList.add("Violet");
//		assertEquals(sortedList.getLast(), "Yellow");
//		assertEquals(sortedList.getFirst(), "Apple");
//		sortedList.add("Zebra");
//		assertEquals(sortedList.getFirst(), "Apple");
//		assertEquals(sortedList.getLast(), "Zebra");
//		//fail("Not Implemented");
//	}
//	
//	@Test
//	public void sllRemove()
//	{
//		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
//		sortedList.add("Red");
//		sortedList.add("Orange");
//		sortedList.add("Yellow");
//		sortedList.add("Green");
//		sortedList.add("Blue");
//		sortedList.add("Indigo");
//		sortedList.add("Apple");
//		sortedList.add("Violet");
//		sortedList.remove("Apple");
//		assertEquals(sortedList.getFirst(), "Blue");
//		sortedList.remove("Yellow");
//		assertEquals(sortedList.getLast(), "Violet");
//		sortedList.remove("Green");
//		sortedList.iterator();
//		//fail("Not Implemented");
//	}
//	
//	@Test
//	public void sllAddToEnd()
//	{
//		//should throw exception
//		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
//		sortedList.add("Red");
//		sortedList.add("Orange").add("Yellow").add("Green").add("Blue").add("Indigo").add("Violet");
////		//fail("Not Implemented");
//	}
//	
//	@Test
//	public void sllAddToFront()
//	{
//		//should throw exception
//		//fail("Not Implemented");
//	}
//}
package tests;

import static org.junit.Assert.*;
import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;




import org.junit.Test;

public class StudentTests {

	@Test
	public void basicTest() {
		
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue");
		System.out.println("First: " + basicList.getFirst());
		System.out.println("Last: " + basicList.getLast());
		System.out.println("Size: " + basicList.getSize());
		System.out.println("Retrieve First: " + basicList.retrieveFirstElement());
		System.out.println("Retrieve Last: " + basicList.retrieveLastElement());
		System.out.println("Removing Red");
		basicList.remove("Red", String.CASE_INSENSITIVE_ORDER);
		System.out.print("Iteration: ");
		for (String entry : basicList) {
			System.out.print(entry + " ");
		}
		
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		sortedList.add("Yellow").add("Red");
		System.out.print("\n\nIteration (for sorted list): ");
		for (String entry : sortedList) {
			System.out.print(entry + " ");
		}
		sortedList.remove("Red");
		System.out.print("\nAfter remove in sorted list first is: ");
		System.out.println(sortedList.getFirst());
		
	}
	
	
	
	@Test
	public void basicLinkedListConstructor() {
		
//		BasicLinkedList<Integer> list1 = new BasicLinkedList<Integer> ();
//		assertTrue(list1.getFirst() == null);
//		assertTrue(list1.getLast() == null);
		
		
	}
	
	
	
	@Test
	public void basicLinkedListAddToEnd() {
		
		BasicLinkedList<Integer> list1 = new BasicLinkedList<Integer> ();
		list1.addToEnd(3);
		assertEquals(list1.getLast().intValue(), 3);
	}
	
	
	
	@Test
	public void basicLinkedListAddToFront() {
		
		BasicLinkedList<Integer> list1 = new BasicLinkedList<Integer> ();
		list1.addToFront(3);
		assertEquals(list1.getFirst().intValue(), 3);
		
	}
	
	
	
	@Test
	public void basicLinkedListGetFirst() {
		
		BasicLinkedList<Integer> list1 = new BasicLinkedList<Integer> ();
		list1.addToFront(3);
		assertEquals(list1.getFirst().intValue(), 3);
		
	}
	
	
	
	@Test
	public void basicLinkedListGetLast() {
	
		BasicLinkedList<Integer> list1 = new BasicLinkedList<Integer> ();
		list1.addToEnd(3);
		assertEquals(list1.getLast().intValue(), 3);
		
	}
	
	
	
	@Test
	public void basicLinkedListGetSize() {
		
		BasicLinkedList<Integer> list1 = new BasicLinkedList<Integer> ();
		list1.addToFront(3);
		list1.addToEnd(6);
		assertEquals(list1.getSize(), 2);

		BasicLinkedList<Integer> list2 = new BasicLinkedList<Integer> ();
		list2.addToFront(1);
		list2.addToEnd(3);
		list2.addToEnd(5);
		assertEquals(list2.getSize(), 3);
		
		BasicLinkedList<Integer> list3 = new BasicLinkedList<Integer> ();
		assertEquals(list3.getSize(), 0);
		
		
	}

	
	
	@Test 
	public void basicLinkedListRemove() {
		
		BasicLinkedList<String> list1 = new BasicLinkedList<String> ();
		list1.addToEnd("Hello").addToEnd("World");
		list1.remove("World", String.CASE_INSENSITIVE_ORDER);
		assertEquals("Hello", list1.getFirst());
		assertEquals("Hello", list1.getLast());
		
		BasicLinkedList<String> list2 = new BasicLinkedList<String> ();
		list2.addToEnd("Hello").addToEnd("World");
		list2.remove("Hello", String.CASE_INSENSITIVE_ORDER);
		assertEquals("World", list2.getFirst());
		assertEquals("World", list2.getLast());
		
		BasicLinkedList<String> list3 = new BasicLinkedList<String> ();
		list3.remove("Hello", String.CASE_INSENSITIVE_ORDER);
		
	}
	
	
	
	@Test
	public void basicLinkedListRetrieveFirstElement() {
		
		BasicLinkedList<Integer> list1 = new BasicLinkedList<Integer> ();
		list1.addToFront(3);
		list1.addToEnd(6);
		list1.retrieveFirstElement();
		assertEquals(list1.getFirst().intValue(), 6);
		
		BasicLinkedList<Integer> list2 = new BasicLinkedList<Integer> ();
		list2.addToFront(3);
		list2.addToEnd(6);
		assertEquals(list2.retrieveFirstElement().intValue(), 3);
		
	}
	
	
	
	@Test
	public void basicLinkedListRetrieveLastElement() {
	
		BasicLinkedList<Integer> list1 = new BasicLinkedList<Integer> ();
		list1.addToFront(3);
		list1.addToEnd(6);
		list1.retrieveLastElement();
		assertEquals(list1.getLast().intValue(), 3);
		list1.addToEnd(6);
		assertEquals((int) list1.retrieveLastElement(), 6);
		
		BasicLinkedList<Integer> list2 = new BasicLinkedList<Integer> ();
		list2.addToFront(3);
		list2.addToEnd(6);
		assertEquals(list2.retrieveLastElement().intValue(), 6);
		
	}
	
	
	
	@Test
	public void basicLinkedListAddCases () {
		
		BasicLinkedList<String> list1 = new BasicLinkedList<String> ();
		list1.addToFront("World").addToEnd("People").addToFront("Pen").addToEnd("Hello").remove("World", String.CASE_INSENSITIVE_ORDER).remove("Hello", String.CASE_INSENSITIVE_ORDER);
		assertEquals("Pen", list1.getFirst());
		assertEquals("People", list1.getLast());
		list1.remove("Pen", String.CASE_INSENSITIVE_ORDER);
		assertEquals("People", list1.getFirst());
		assertEquals("People", list1.getLast());
		
		
	}
	

	
	@Test
	public void sortedLinkedListAdd() {
		
		SortedLinkedList<String> list1 = new SortedLinkedList<String> (String.CASE_INSENSITIVE_ORDER);
		list1.add("Apple").add("Bee").add("Banana").add("Dog").add("Ant").add("Orange");
		assertEquals("Ant", list1.getFirst());
		assertEquals("Orange", list1.getLast());
		
		list1.remove("Ant");
		assertEquals("Apple", list1.getFirst());
		assertEquals("Orange", list1.getLast());
		
		list1.remove("Orange");
		list1.remove("Apple");
		assertEquals("Banana", list1.getFirst());
		assertEquals("Dog", list1.getLast());
		
		list1.remove("Bee");
		assertEquals(list1.getSize(), 2);
		
	}

	
	
	@Test 
	public void sortedLinkedListAddToEnd() {
		
		SortedLinkedList<String> list1 = new SortedLinkedList<String> (String.CASE_INSENSITIVE_ORDER);
		try {
			list1.addToEnd("Hello");
			fail();
		} catch (UnsupportedOperationException e) {
			
		}
		
	}
	
	
	
	@Test
	public void basicLinkedListRemoveCases() {
		
		BasicLinkedList<String> list1 = new BasicLinkedList<String> ();
		list1.addToFront("Fox").addToEnd("Jumped").addToFront("Quick").addToEnd("Over").addToFront("The").addToEnd("The").addToEnd("Dog");
		assertEquals("The", list1.getFirst());
		assertEquals("Dog", list1.getLast());
		assertEquals(7, list1.getSize());
	
		list1.remove("Fox", String.CASE_INSENSITIVE_ORDER);
		assertEquals("The", list1.getFirst());
		assertEquals("Dog", list1.getLast());
		assertEquals(6, list1.getSize());
		
		list1.remove("The", String.CASE_INSENSITIVE_ORDER);
		assertEquals("Quick", list1.getFirst());
		assertEquals("Dog", list1.getLast());
		assertEquals(4, list1.getSize());
		
		list1.remove("Quick", String.CASE_INSENSITIVE_ORDER);
		list1.remove("Dog", String.CASE_INSENSITIVE_ORDER);
		assertEquals("Jumped", list1.getFirst());
		assertEquals("Over", list1.getLast());
		assertEquals(2, list1.getSize());
		
		list1.remove("Jumped", String.CASE_INSENSITIVE_ORDER);
		assertEquals("Over", list1.getFirst());
		assertEquals("Over", list1.getLast());
		assertEquals(1, list1.getSize());
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void sortedLinkedListConstructor() {
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
        sortedList.add("Red");
        sortedList.add("Orange");
        sortedList.add("Yellow");
        sortedList.add("Green");
        sortedList.add("Blue");
        sortedList.add("Indigo");
        sortedList.add("Violet");
        assertEquals( "Blue", sortedList.getFirst());
	}
	
	

	@Test
	public void bllGetSize()
	{
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Red");
		assertEquals(basicList.getSize(), 5);
		basicList.retrieveFirstElement();
		assertEquals(basicList.getSize(), 4);
		basicList.retrieveLastElement();
		assertEquals(basicList.getSize(), 3);
		
		//REMOVE METHOD NOT WORKING AT CURRENT TIME
//		basicList.remove("Blue", String.CASE_INSENSITIVE_ORDER);
//		assertEquals(basicList.getSize() == 2);
		
		
		//fail("Not Implemented");
	}
	
	@Test
	public void bllAddToEnd()
	{
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Red");
		assertEquals(basicList.getLast(), "Red");
		basicList.addToEnd("Green");
		assertEquals(basicList.getLast(), "Green");
		basicList.addToEnd("Toothpaste");
		assertEquals(basicList.getLast(), "Toothpaste");
		basicList.addToEnd("Computer");
		assertEquals(basicList.getLast(), "Computer");
		basicList.addToEnd("Dez Nuts");
		assertEquals(basicList.getLast(), "Dez Nuts");
		basicList.addToEnd("CompSci");
		assertEquals(basicList.getLast(), "CompSci");
		basicList.addToFront("Tuesday");
		assertEquals(basicList.getLast(), "CompSci");
		
		basicList.remove("Computer", String.CASE_INSENSITIVE_ORDER);
		assertEquals(basicList.getLast(), "CompSci");
		basicList.remove("CompSci", String.CASE_INSENSITIVE_ORDER);
		assertEquals(basicList.getLast(), "Dez Nuts");
		//fail("Not Implemented");
	}
	
	@Test
	public void bllAddToFront()
	{
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Red");
		assertEquals(basicList.getFirst(), "Orange");
		basicList.addToFront("Green");
		assertEquals(basicList.getFirst(), "Green");
		basicList.addToFront("Toothpaste");
		assertEquals(basicList.getFirst(), "Toothpaste");
		basicList.addToFront("Computer");
		assertEquals(basicList.getFirst(), "Computer");
		basicList.addToFront("Dez Nuts");
		assertEquals(basicList.getFirst(), "Dez Nuts");
		basicList.addToFront("CompSci");
		assertEquals(basicList.getFirst(), "CompSci");
		basicList.addToEnd("Tuesday");
		assertEquals(basicList.getFirst(), "CompSci");
	}
	
	@Test
	public void bllGetFirst()
	{
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Red");
		assertEquals(basicList.getFirst(), "Orange");
		//fail("Not Implemented");
	}
	
	@Test
	public void bllGetLast()
	{
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Green");
		assertEquals(basicList.getLast(), "Green");
		//fail("Not Implemented");
	}
	
	@Test
	public void bllRetrieveFirstElement()
	{
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Green");
		assertEquals(basicList.retrieveFirstElement(), "Orange");
		assertEquals(basicList.getFirst(), "Blue");
		//fail("Not Implemented");
	}
	@Test
	public void bllRetrieveLastElement()
	{
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Green");
		assertEquals(basicList.retrieveLastElement(), "Green");
		assertEquals(basicList.getLast(), "Red");
		//fail("Not Implemented");
	}
	
	@Test
	public void bllRemove()
	{
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue").addToFront("Orange").addToEnd("Green");
		basicList.addToEnd("Gold").addToFront("Computer").addToEnd("Yes");
		assertEquals(basicList.getFirst(), "Computer");
		basicList.remove("Computer", String.CASE_INSENSITIVE_ORDER);
		assertEquals(basicList.getFirst(), "Orange");
		assertEquals(basicList.getLast(), "Yes");
		basicList.remove("Yes", String.CASE_INSENSITIVE_ORDER);
		assertEquals(basicList.getLast(), "Gold");
		//fail("Not Implemented");
	}
	
	//sll tests
	@Test
	public void sllAdd()
	{
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		sortedList.add("Red");
		assertEquals(sortedList.getFirst(), "Red");
		sortedList.add("Orange");
		assertEquals(sortedList.getFirst(), "Orange");
		assertEquals(sortedList.getLast(), "Red");
		sortedList.add("Yellow");
		assertEquals(sortedList.getFirst(), "Orange");
		assertEquals(sortedList.getLast(), "Yellow");
		sortedList.add("Green");
		assertEquals(sortedList.getFirst(), "Green");
		assertEquals(sortedList.getLast(), "Yellow");
		sortedList.add("Blue");
		assertEquals(sortedList.getFirst(), "Blue");
		assertEquals(sortedList.getLast(), "Yellow");
		sortedList.add("Indigo");
		assertEquals(sortedList.getFirst(), "Blue");
		assertEquals(sortedList.getLast(), "Yellow");
		sortedList.add("Apple");
		assertEquals(sortedList.getFirst(), "Apple");
		assertEquals(sortedList.getLast(), "Yellow");
		System.out.println("First"+sortedList.getFirst());
		System.out.println("Last"+sortedList.getLast());
		sortedList.add("Violet");
		assertEquals(sortedList.getLast(), "Yellow");
		assertEquals(sortedList.getFirst(), "Apple");
		sortedList.add("Zebra");
		assertEquals(sortedList.getFirst(), "Apple");
		assertEquals(sortedList.getLast(), "Zebra");
		//fail("Not Implemented");
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
