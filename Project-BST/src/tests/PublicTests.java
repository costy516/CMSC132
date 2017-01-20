package tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import tree.PlaceKeysValuesInArrayLists;
import tree.PolymorphicBST;

public class PublicTests {
	
	@Test
	public void testBasics() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();
		
		assertEquals(0, ptree.size());
		
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(1, "OneSecondTime");
		assertEquals(3, ptree.size());
		assertEquals("OneSecondTime", ptree.get(1));
		assertEquals("Two", ptree.get(2));
		assertEquals("Three", ptree.get(3));
		assertEquals(null, ptree.get(8));
	}
	
	@Test
	public void testEmptySearchTree() {
		PolymorphicBST<String, Integer> ptree = new PolymorphicBST<String, Integer>();
		
		assertEquals(0, ptree.size());
		
		try {
			assertEquals(null, ptree.getMin());
			fail("Should have thrown NoSuchElementException");
		} catch (NoSuchElementException e) {
			assert true; // as intended
		}
		try {
			assertEquals(null, ptree.getMax());
			fail("Should have thrown NoSuchElementException");
		} catch (NoSuchElementException e) {
			assert true; // as intended
		}
		assertEquals(null, ptree.get("a"));
	}
	
	@Test
	public void testHeightInorderClear() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();
		
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		assertEquals(3, ptree.height());
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		ptree.inorderTraversal(task);
		assertEquals(task.getKeys().toString(), "[1, 2, 3, 4]");
		assertEquals(task.getValues().toString(), "[One, Two, Three, Four]");
		
		ptree.clear();
		assertEquals(0, ptree.size());
	}
}
