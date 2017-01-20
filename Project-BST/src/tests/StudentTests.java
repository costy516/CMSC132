package tests;

import org.junit.Test;

import tree.PlaceKeysValuesInArrayLists;
import tree.PolymorphicBST;
import junit.framework.TestCase;

public class StudentTests extends TestCase {
	
	@Test
	public void testRightRootLeftTraversalClear() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();
		
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		assertEquals(3, ptree.height());
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		ptree.rightRootLeftTraversal(task);
		assertEquals(task.getKeys().toString(), "[4, 3, 2, 1]");
		assertEquals(task.getValues().toString(), "[Four, Three, Two, One]");
		
		ptree.clear();
		assertEquals(0, ptree.size());
	}
	
}