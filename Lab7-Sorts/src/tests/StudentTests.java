package tests;

import static org.junit.Assert.*;

import org.junit.Test;
/*
 * Do not change or mess with these imports unless you really know
 * what you're doing.
 */
import static student_collections.SList.*;
import student_collections.*;
import static student_classes.Sorts.*;

public class StudentTests {
	
	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	
	
	@Test
	public void appendTest() {
		
		SList<Integer> list1 = list(1, 2, 3);
		SList<Integer> list2 = list(4, 5, 6);
		SList<Integer> list3 = append(list1, list2);
		
		assertEquals((int) first(list3), 1);
		list3 = rest(list3);
		
		assertEquals((int) first(list3), 2);
		list3 = rest(list3);

		assertEquals((int) first(list3), 3);
		list3 = rest(list3);
		
		assertEquals((int) first(list3), 4);
		list3 = rest(list3);
		
		assertEquals((int) first(list3), 5);
		list3 = rest(list3);
		
		assertEquals((int) first(list3), 6);
		list3 = rest(list3);
		
	}
	
	
	
	@Test
	public void dropTest() {
		
		SList<Integer> list1 = list(1, 2, 3, 4, 5);
		SList<Integer> list2 = drop(list1, 3);
		
		assertEquals((int) first(list2), 4);
		list2 = rest(list2);
		
		assertEquals((int) first(list2), 5);
		list2 = rest(list2);
		
		
		
	}
	
	
	
	@Test
	public void mergeSortTest() {
		
		SList<Integer> list1 = list(1,5,2,5,6,8,10,3,7);
		SList<Integer> list2 = mergeSort(list1);
		SList<Integer> list3 = list(1,2,3,5,5,6,7,8,10);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);		
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
	}
	
	
	
	@Test
	public void quickSortTest() {
		
//		SList<Integer> temp1 = list(1,1,1,1);
//		SList<Integer> temp2 = list(1,1,1,1);
//		SList<Integer> temp3 = qSort(temp1);
//		
//		assertEquals(first(temp2), first(temp3));
//		temp2 = rest(temp2);
//		temp3 = rest(temp3);
//		
//		assertEquals(first(temp2), first(temp3));
//		temp2 = rest(temp2);
//		temp3 = rest(temp3);
//		
//		assertEquals(first(temp2), first(temp3));
//		temp2 = rest(temp2);
//		temp3 = rest(temp3);
//		
//		assertEquals(first(temp2), first(temp3));
//		temp2 = rest(temp2);
//		temp3 = rest(temp3);
		
		
		
		
		
		
		
		
		
		
		
		
//		SList<Integer> dummy1 = list(4,1,2,3);
//		SList<Integer> dummy2 = qSort(dummy1);
//		SList<Integer> dummy3 = list(1,2,3,4);
//		
//		assertEquals(first(dummy2), first(dummy3));
//		dummy2 = rest(dummy2);
//		dummy3 = rest(dummy3);
//		
//		assertEquals(first(dummy2), first(dummy3));
//		dummy2 = rest(dummy2);
//		dummy3 = rest(dummy3);
//		
//		assertEquals(first(dummy2), first(dummy3));
//		dummy2 = rest(dummy2);
//		dummy3 = rest(dummy3);
//		
//		assertEquals(first(dummy2), first(dummy3));
//		dummy2 = rest(dummy2);
//		dummy3 = rest(dummy3);
		
		
		
		
		
		
		
		
		SList<Integer> dummy4 = list(6,5,4,3,2);
		SList<Integer> dummy5 = qSort(dummy4);
		SList<Integer> dummy6 = list(2,3,4,5,6);
		
		assertEquals(first(dummy5), first(dummy6));
		dummy5 = rest(dummy5);
		dummy6 = rest(dummy6);
		
		assertEquals(first(dummy5), first(dummy6));
		dummy5 = rest(dummy5);
		dummy6 = rest(dummy6);
		
		assertEquals(first(dummy5), first(dummy6));
		dummy5 = rest(dummy5);
		dummy6 = rest(dummy6);
		
		assertEquals(first(dummy5), first(dummy6));
		dummy5 = rest(dummy5);
		dummy6 = rest(dummy6);
		
		
		
		
		
		
		
		
		
		
		
		SList<Integer> list1 = list(1,5,2,5,6,8,10,3,7);
		SList<Integer> list2 = qSort(list1);
		SList<Integer> list3 = list(1,2,3,5,5,6,7,8,10);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);		
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
		assertEquals(first(list2), first(list3));
		list2 = rest(list2);
		list3 = rest(list3);
		
	}

}
