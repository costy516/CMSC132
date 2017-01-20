package student_classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
/**
 * A "bag" is a data-structure that implements a <em>multiset</em>, which is
 * a set that allows multiple (duplicates). The standard operators on such
 * a data-structure include:
 * 
 * 	Bag() --creates an empty bag (optionally, perhaps a default size?)
 * 
 * 	add( Type ele ) --adds an element of Type to the bag
 * 
 * 	remove( Type ele ) --removes an element from the bag; may throw IllegalStateException
 * 					   --in the event that ele is NOT in the Bag.
 * 
 * 	contains( Type ele ) --returns True if ele is in bag.
 * 
 * 	count( Type ele ) --returns the number of occurrences of ele in set. 
 *                 This is called the "multiplicity" of the element.
 * 
 * 	asSet() --returns a collection of the elements in this bag as set.
 * 
 *  size() --returns the number of elements in this bag taking into account
 *           their multiplicities. For example: if the Bag contains the following
 *           elements with multiplicities:
 *           
 *           Key    Count
 *           ------------
 *           "A"      2
 *           "B"      3
 *           "C"      1
 *           
 *           size() => 6.
 * 
 *  iterator() --returns an Iterator that also takes into account the multiplicities
 *           of each key. So, an iterator() should iterate over exactly the same number
 *           of elements as size().
 * Important reminder: You will most likely replace references to <code>Object</code>
 * that appear in parameters lists with your generic variable type(s).
 * 
 * @author UMD CS Department.
 * @param <T>
 * @param <T>
 *
 * @param
 */
public class Bag<T> implements Iterable <T> 
{
	// note you will need to parameterize this class and
	// most likely the implements declaration.
	
	private HashMap<T, Integer> theMap;
	/**
	 * Sole Constructor
	 */
	public Bag()
	{
		theMap = new HashMap();
	}
	
	/**
	 * Adds ele (T) to the bag. If ele was already in the Bag, then its internal count is incremented by 1; 
	 * otherwise a new entry is made, indicating that at least 1 ele exists in this Bag.
	 * 
	 * @param ele
	 */
	public void add (T ele)
	{
		if(theMap.isEmpty())
		{
			theMap.put(ele, 1);
		}
		else
		{
			if(theMap.containsKey(ele))
			{
				Integer value = this.count(ele);
				theMap.replace(ele, value + 1);
				
			}
			else
			{
				theMap.put(ele, 1);
			}
		}
		
	}
	
	/**
	 * Return the keys as a Set—i.e., no duplicates, order-unimportant. 
	 * Use this function to determine the number of unique entries in the Bag!
	 * 
	 * @return
	 */
	public Set<T> asSet ()
	{
		return theMap.keySet();
	}
	
	/**
	 * Returns true if this Bag contains at least one copy of the key.
	 * 
	 * @param ele
	 * @return
	 */
	public boolean contains (T ele)
	{
		return theMap.containsKey(ele);
	}
	
	/**
	 * Returns the number of occurrences of ele in the Bag; 
	 * returns 0 in the event that ele is not in Bag.
	 * 
	 * @param ele
	 * @return
	 */
	public int count ( T ele )
	{
		if(!this.contains(ele))
		{
			return 0;
		}
		return theMap.get(ele);
	}
	
	/**
	 * Returns an object that iterates (implements the Iterator interface) over objects in the Bag.
	 * You will most like return an instance of an inner class that you design to manage an immutable 
	 * Iteration of keys over this bag.
	 */
	public Iterator<T> iterator( )
	{
		return new Bag.myIterator();
	}
	
	/**
	 * Effectively remove the ele from the bag. Note, several possibilities here:
	 * 		• If the ele isn’t in the Bag, throw an Illegal State Exception.
	 * 		
	 * 		• If only one ele exists in the Bag, then remove it.
	 * 		
	 * 		• If more than one ele exists in the Bag, make whatever changes are necessary to 
	 * 		  indicate that one fewer ele now exists in the Bag. Note, how you do this will 
	 * 		  depend upon your internal data-structure.
	 * 
	 * @param ele
	 */
	public void remove ( T ele )
	{
		if(!this.contains(ele))
		{
			throw new IllegalStateException();
		}
		else
		{
			if(this.count(ele) > 1)
			{
				int value  = theMap.get(ele);
				theMap.remove(ele, theMap.get(ele));
				theMap.put(ele, value-1);
			}
			else
			{
				theMap.remove(ele, theMap.get(ele));
			}
		}
	}
	
	/**
	 * The "size" of a bag is the cardinality of the multiset that it embodies. 
	 * In English, that means that the size of your bag must accumulate the multiplicities of each element. 
	 * For example: suppose your Bag contains
	 * Key Count ---------— "A" 2
	 *                      "B" 3
	 *                      "C" 1
	 * Then its size is 6.
	 * 
	 * @return
	 */
	public int size ()
	{
		Object[] theArray;
		theArray = theMap.values().toArray();
		int size = 0;
		
		for(int i = 0; i < theArray.length; i++)
		{
			size += (Integer) theArray[i];
		}
		
		
		return size;
	}
	
	private class myIterator implements Iterator<T> 
	{
		int pos = 0;
		T[] theKeys = (T[]) theMap.keySet().toArray();
		Object[] theValues = theMap.values().toArray();

		@Override
		public boolean hasNext() 
		{
			if(((Integer)theValues[pos]) > 1)
			{
				return true;
			}
			if (pos < theKeys.length-1) 
			{
				pos++;
				return true;
			}
			
			else 
			{
				return false;
			}
		}

		@Override 
		public T next() 
		{
			if(hasNext())
			{
				if((Integer) theValues[pos] >= 1)
				{
					theValues[pos] = ((Integer) theValues[pos]) - 1;
					return theKeys[pos];
				}
			}
			return null;
		}

	}

}
