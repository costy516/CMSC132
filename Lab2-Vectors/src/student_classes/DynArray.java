package student_classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/**
 * Your implementation goes here ...
 * @author Andrew Costello
 *
 * @param <T>
 */
public class DynArray<T> implements RandomAccess, Iterable<T> 
{
	// array is the array that will store the values of the DynArray
	private Object[] array;
	
	// allowNull is a boolean that will store whether or not the DynArray accepts nulls
	private boolean allowNull;
	
	// quanta is the capacity interval of the array
	private int quanta = 8;
	
	// size is the current number of objects that are stored in the array
	private int size = 0;
	
	
	/**
	 * Constructor creates array of objects that has a fixed size of 8.
	 * The constructor also allows for nulls to not be allowed.
	 * @param allowNulls 
	 */
	public DynArray( boolean allowNulls ) 
	{
		array = new Object[quanta];
		allowNull = allowNulls;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Creates a DynArray with capacity of quanta.  The DynArray allows nulls by default
	 */
	public DynArray() 
	{
		array = new Object[quanta];
		allowNull = true;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Constructor creates array of objects that has a length >= ensureCapacity in intervals of quanta.
	 * Example if ensureCapacity is 17 then the length is (8*3)=24
	 * The constructor also allows for nulls to not be allowed.
	 * @param ensureCapacity
	 * @param allow_nulls
	 */
	public DynArray( int ensureCapacity, boolean allow_nulls ) 
	{
		array = new Object[(ensureCapacity/quanta)*quanta + ((ensureCapacity%quanta != 0)?(quanta):(0))];
		allowNull = allow_nulls;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Copy constructor
	 * Sets array length equal to the size of the otherArray.  Using a loop array gets populated form other array.
	 * @param otherArray
	 */
	public DynArray( DynArray<T> otherArray ) 
	{
		array = new Object[otherArray.array.length];
		for(int i = 0; i < otherArray.array.length; i++)
		{
			array[i] = otherArray.get(i);
		}
		size = otherArray.size();
		allowNull = otherArray.allowNull;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Add method
	 * First checks to see if parameter is null and if the array can accept nulls
	 * If the param is allowed to be added method checks to see if more capacity needs to be added to array
	 * If the capacity of the array is able to hold new element the element is added to the lowest open index.
	 * size is incremented
	 * @param  ele
	 */
	public void add( T ele ) 
	{
		if(ele == null && !allowNull)
		{
			throw new NullPointerException();
		}
		else
		{
			if(array.length <= this.size())
			{
				Object[] temp = new Object[array.length+quanta];
				for(int i = 0; i < array.length; i++)
				{
					temp [i] = array[i];
				}
				temp[array.length] = ele;
				
				array = temp;
			}
			else
			{
				array[this.size] = ele;
			}
			size++;
		}
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Remove Method
	 * First checks to see if the index is within array - if not then throws OutofBoundsException
	 * Creates a temp array of same length as array to store all data but item removed
	 * returnVal stores value that gets removed before it is removed
	 * Loop populates temp array excluding the atIndex
	 * array is set equal to temp array
	 * size is decremented
	 * return object that was removed (returnVal)
	 * @param atIndex
	 * @return returnVal
	 */
	public T remove( int atIndex ) 
	{
		if(atIndex > this.size() || this.size() == 0 || atIndex < 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		Object[] temp = new Object[array.length];
		Object returnVal = array[atIndex];
		for(int i = 0, j = 0; i < array.length; i++, j++)
		{
			if(i == atIndex)
			{
				j--;
			}
			else
			{
				temp [j] = array[i];
			}
		}
		array = temp;
		size--;
		return  (T) returnVal;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Get Method
	 * Checks to see if index is within the capacity of the array
	 * If it is not then throws OutofBoundsException
	 * Otherwise returns object at that index
	 * @param index
	 * @return array[index]
	 */
	public T get( int index ) 
	{	
		if(index> array.length-1 || array.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T) array[index];
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Set Method
	 * Checks to see if object is null and if the DynArray can accept nulls
	 * Checks to see if index is within the capacity of the DynArray
	 * Sets array at index to object
	 * @param index
	 * @param object
	 */
	public void set( int index, T object ) 
	{
		if(object == null && !allowNull)
		{
			throw new NullPointerException();
		}
		if(index > array.length-1 || array.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		array [index] = object;
		if(index+1 > size)
		{
			size = index+1;
		}
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Size Method
	 * Returns the size of the array
	 * The size is the number of objects that are added to the DynArray
	 * @return size
	 */
	public int size() {
		return size;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * toString Method
	 * Calls toString method from Arrays
	 * @return Arrays.toString(array)
	 */
	public String toString() {
		return Arrays.toString(array);
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Equals Method
	 * Checks to see if both are null
	 * Checks to see if one is null and not the other
	 * Checks to see if the sizes are the same
	 * Checks to see if each item in the DynArray are the same
	 */
	public boolean equals( Object other ) 
	{
		if(other == null)
		{
			return false;
		}
		else if (this.size() != ((DynArray)other).size())
		{
			return false;
		}
		else if (this.allowNull != ((DynArray) other).allowNull)
		{
			return false;
		}
		else if (this.array.length != ((DynArray)other).array.length)
		{
			return false;
		}
		
		else
		{
			for(int i = 0; i < this.array.length; i++)
			{
				if(!(this.array[i].equals(((DynArray) other).array[i])))
				{
					return false;
				}
			}
			return true;
		}
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * MyIterator Class
	 * Keeps track of position (pos) when iterating
	 * Has method hasNext that checks to see if position is less then items in array
	 * Has method next that increments pos and returns next item in array
	 * @return array[pos]
	 */
	private class MyIterator implements Iterator
	{
		private int pos = 0;
		
		public boolean hasNext()
		{
			return pos < size;
		}
		
		public Object next()
		{
			pos++;
			return (T) array[pos];
		}
	}
	
	/**
	 * Iterator Method
	 * Calls private class
	 * @return DynArray.MyIterator
	 */
	@Override
	public Iterator<T> iterator()
	{
		return new DynArray.MyIterator();
	}

}
