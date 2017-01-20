package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

import student_classes.DynArray;
// used to support random integer generation
								 // for tests in this file.


/** 
 * Reserved for you to implement your own tests. Note: you may
 * need to add JUnit4 to your build path to use these. Ask 
 * your TA for help, or let Eclipse lead you through
 * the process.
 * 
 * @author CMSC Student
 *
 */
public class StudentTests {
	// uses these as you wish: they are "samples" of what kinds
	// of things are good test candidates.
	
	@Test
	public void testDynArrayBoolean() { //ctor
		DynArray test = new DynArray(true);
		for(int i = 0; i <= 7; i++)
		{
			assertEquals(test.get(i), null);
		}
		//fail("Not yet implemented");
	}

	@Test
	public void testDynArray() { //ctor
		DynArray test = new DynArray();
		for(int i = 0; i <= 7; i++)
		{
			assertEquals(test.get(i), null);
		}
		//fail("Not yet implemented");
	}

	@Test
	public void testDynArrayIntBoolean() {
		DynArray test = new DynArray(9, true);
		for(int i = 0; i <= 7; i++)
		{
			assertEquals(test.get(i), null);
		}
		assertEquals(test.get(15), null);
		//fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		DynArray test = new DynArray();
		for(int i = 0, j =19; i <= 7; i++, j+=4)
		{
			test.add(j);
		}
		assertEquals(test.get(0), 19);
		assertEquals(test.get(1), 23);
		assertEquals(test.get(5), 39);
		//fail("Not yet implemented");
	}
	/**
	 * Uncomment the following test case taken verbatim from the real Public Tests 
	 * for this project after you have implemented all of the methods for the 
	 * DynArray class. We have provided this method as an example of how one
	 * might write a unit-test for a particular functionality---copy construction,
	 * in this case.
	 */
	@Test
	public void testDynArrayCopyCtor() {
		DynArray< Integer > numbers = new DynArray< Integer >( false );
		/* ensure that the object was created in the first place. */
		assertNotNull( numbers );
		/* Invokes the copy-ctor ... */
		DynArray< Integer > otherArray = 
				new DynArray< Integer >( numbers );
		/* Note: verify that the copy-ctor did something ... */
		assertNotNull( otherArray );
		/* populate the original array with some typical input ... */
		for( int index=0; index < 10; index++ )
			numbers.add( index );
		/* This next line attempts to verify that the copy-constructor did NOT allow the
		 * sharing of structure.
		 */
		assertNotEquals( numbers.size(), otherArray.size() );
		/*
		 * this next piece of logic ensures that ALL of the properties were
		 * copied from the original to the copy .... including whether or not
		 * the original object permitted NULLs.
		 */
		try {
			otherArray.add( null );
			fail( "expected an exception here! ");
		} catch( RuntimeException re ) { }
	}

	@Test
	public void testRemove() {
		DynArray test = new DynArray();
		for(int i = 0, j =19; i <= 7; i++, j+=4)
		{
			test.add(j);
		}
		test.remove(2);
		assertEquals(test.size(), 7);
		assertEquals(test.get(2), 31);
		//fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		/* In order to use this logic, you need to (1) ensure that you've implemented
		 * the Dynamic Array's add() and size() methods, that your class declares that
		 * it implements the RandomAccess interface; and, (2) you will need to 
		 * use the java.util.Random class to define a static instance variable named
		 * "generator" --which has a number of methods, but "nextInt( int )" is the
		 * one that is being called in the code below.
		 */
//		static Random generator;
//		DynArray<Integer> numbers=new DynArray<Integer>( 16, true );
//		assertTrue( numbers instanceof java.util.RandomAccess );
//		assertNotNull( numbers );
//		for( int index=0; index < 100; index++ )
//			numbers.add(generator.nextInt(100));
//		
//		assertEquals( numbers.size(), 100 );
//		numbers.add(null);
//		assertEquals( numbers.get( 100 ), null );
		DynArray test = new DynArray();
		for(int i = 0, j =19; i <= 7; i++, j+=4)
		{
			test.add(j);
		}
		assertEquals(test.get(1), 23);
		//fail("Not yet implemented");
	}

	@Test
	public void testSet() {
		DynArray test = new DynArray();
		for(int i = 0, j =19; i <= 7; i++, j+=4)
		{
			test.add(j);
		}
		test.set(4, 13);
		assertEquals(test.get(0), 19);
		assertEquals(test.get(1), 23);
		assertEquals(test.get(5), 39);
		assertEquals(test.get(4), 13);
		//fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		DynArray test = new DynArray();
		for(int i = 0, j =19; i <= 7; i++, j+=4)
		{
			test.add(j);
		}
		assertEquals(test.size(),8);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testEquals()
	{
		DynArray test1 = new DynArray(true);
		DynArray test2 = new DynArray (false);
		assertTrue(!(test1.equals(test2)));
		test1 = new DynArray();
		for(int i = 0, j =19; i <= 7; i++, j+=4)
		{
			test1.add(j);
		}
		test2 = new DynArray(test1);
		assertTrue(test1.equals(test2));
	}

}
