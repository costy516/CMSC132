package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import student_classes.Bag;
import student_classes.DenseSearchTree;

public class StudentTests 
{
	//Bags
	@Test
	public void BigTestBag()
	{
		Bag<Integer> theBag = new Bag<Integer>();
		assertEquals(0, theBag.size());
		
		theBag.add(3);
		assertEquals(1, theBag.size());
		assertEquals(1, theBag.count(3));
		theBag.add(2);
		assertEquals(2, theBag.size());
		assertEquals(1, theBag.count(3));
		theBag.add(3);
		assertEquals(2, theBag.count(3));
		assertEquals(3, theBag.size());
		theBag.add(1);
		assertEquals(4, theBag.size());
		assertEquals(2, theBag.count(3));
		theBag.add(7);
		assertEquals(5, theBag.size());
		assertEquals(2, theBag.count(3));
		theBag.add(3);
		assertEquals(6, theBag.size());
		assertEquals(3, theBag.count(3));
		theBag.add(3);
		assertEquals(7, theBag.size());
		assertEquals(4, theBag.count(3));
		theBag.add(15);
		assertEquals(8, theBag.size());
		assertEquals(4, theBag.count(3));
		theBag.add(2);
		assertEquals(9, theBag.size());
		assertEquals(4, theBag.count(3));
		theBag.add(0);
		assertEquals(10, theBag.size());
		assertEquals(4, theBag.count(3));
		
		theBag.remove(3);
		assertEquals(9, theBag.size());
		assertEquals(3, theBag.count(3));
		theBag.remove(3);
		assertEquals(8, theBag.size());
		assertEquals(2, theBag.count(3));
		theBag.remove(1);
		assertEquals(7, theBag.size());
		assertEquals(2, theBag.count(3));
		
		for(Integer item: theBag)
		{
			System.out.println(item);
		}
		
	}
	//Bags End
	//DST
	@Test
	public void BigTestDST()
	{
		DenseSearchTree<Integer> tree = new DenseSearchTree<Integer>();
		
		tree.add(1);
		assertEquals(1, tree.size());
		tree.add(3);
		assertEquals(2, tree.size());
		tree.add(1);
		assertEquals(3, tree.size());
		tree.add(4);
		assertEquals(4, tree.size());
		tree.add(10);
		assertEquals(5, tree.size());
		tree.add(15);
		assertEquals(6, tree.size());
		tree.add(3);
		assertEquals(7, tree.size());
		tree.add(22);
		assertEquals(8, tree.size());
		tree.add(16);
		assertEquals(9, tree.size());
		tree.add(21);
		assertEquals(10, tree.size());
		tree.add(13);
		assertEquals(11, tree.size());
		tree.add(15);
		assertEquals(12, tree.size());
		tree.add(7);
		assertEquals(13, tree.size());
		tree.add(1);
		assertEquals(14, tree.size());
		
		tree.remove(3);
		assertEquals(13, tree.size());
		tree.remove(4);
		assertEquals(12, tree.size());
		tree.remove(22);
		assertEquals(11, tree.size());
		tree.remove(3);
		assertEquals(10, tree.size());
		tree.remove(1);
		assertEquals(9, tree.size());
		
		for(Integer item: tree)
		{
			System.out.println(item);
		}
		
	}
	//DST End

}
