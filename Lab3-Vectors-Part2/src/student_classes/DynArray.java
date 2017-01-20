package student_classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/**
 * <h1>Special Instructions</h1>
 * 
 * Copy your existing code <b>into this lab</b> and submit your changes/etc through this Lab only.
 * <ul>
 * <li><b>Do not attempt to submit last week's lab in place of this one.</b></li>
 * <li><b>Submit your changes <em>only</em> by including them in this project/lab and submitting them
 * from within this project/lab.</b></li>
 * </ul>
 * <h1>Engineering Change Order(s)</h1>
 * Since the initial release, the customer has requested that the implementation of this object
 * be refined. Specifically, the customer requests that the code be revised so as to enforce the
 * following invariant(s):
 * <ul>
 * <li>A <code>DynArray</code> that is constructed to <em>disallow</em> <code>null</code> objects should
 * <b>never</b> allow the storage or retrieval of a <code>null</code> object.</li>
 * <li>The object overrides, specifically <code>equals</code> and <code>toString</code> must work
 * transparently with <code>DynArray</code> objects irrespective of whether they allow or 
 * disallow <code>null</code> objects.</li>
 * <li>The <code>set()</code> must allow clients to set any permissible object in the array whose
 * index is valid (within the capacity of the structure), and must ensure that the <b>size</b> of
 * the DynArray reflects these changes. For example; creating a DynArray of capacity N should allow
 * clients to <code>set( i, Object )</code> when i is less than N. Moreover, the size of the underlying
 * DynArray should reflect the total number of object locations used as a result of that operation. Thus,
 * <code>set( 4, Object )</code> inserts the object at the desired location (assuming that N is greater
 * than 4), and ensures that the <code>size()</code> of the underlying array is at least 4 when asked.</i>
 * <li>Exceptions handling is tightened up to require the specified exceptions instead of allowing any
 * exceptions.</li>
 * </ul>
 * <P>
 * <h2>Notes on required exceptions</h2>
 * Note that attempts to store <code>null</code> values in <code>DynArray</code> objects that do not allow such
 * values <em>must</em> result in a <code>NullPointerException</code> being raised. Note also that calling any of
 * the methods that require indexing may result in <em>unchecked</em> <code>ArrayIndexOutOfBounds</code> exceptions
 * being thrown. Additional exceptions may be raised by attempting to use the <code>set()</code> method
 * in such a manner as to either insert a value past this current object's capacity or to insert a null where
 * the object disallows nulls. Please see the documentation for the <code>set()</code> and <code>get()</code> methods
 * for a more thorough treatment.
 * <br>
 * <h2>Notes on equals testing</h2>
 * This revision requires that the <code>equals</code> override not throw exceptions when comparing DynArrays that may contain <code>null</code>s,
 * such as might be the case where the client intends that the structures allow nulls.
 * In addition, your implementation should override the <code>toString()</code> and the <code>equals</code> methods, but <em> need not</em>
 * override the <code>hashCode()</code> method.
 * <P>
 * <h2>Previous Definitions remain in effect</h2>
 * <code>DynArray</code>s are dynamically re-sizable arrays that may contain any kind of first-class
 * <code>Object</code>s. <code>DynArray</code> objects differ from linked-lists in that they are 
 * optimized for array-style access, i.e., accessing elements by indices (ints >= 0).
 * As such, <code>DynArray</code> objects must declare that 
 * they implement the <code>RandomAccess</code> <em>marker interface</em>.
 * </P>
 * <P>Some additional considerations: At least four <code>public</code> constructors are required for this implementation:
 * <ol>
 *  <li><code>DynArray()</code> (the default constructor) which creates a dynamic array whose internal
 *  array is a default size and that allows clients to store <code>null</code> values.</li>
 *  <li><code>DynArray( boolean nullOk )</code> a minimal constructor that allows the client to 
 *  specify whether or not <code>null</code> objects are permitted through the use of the <code>nullOk</code> 
 *  flag.</li>
 *  <li><code>DynArray( int ensureCapacity, boolean nullOk )</code> This constructor creates a <code>DynArray</code>
 *  object that is <em> at least large enough</em> to <code>ensureCapacity</code>; note, the <code>nullOk</code> parameter
 *  is used to delegate calls to <code>DynArray( boolean nullOk )</code>, described above.</li>
 *  <li><code>DynArray( DynArray other )</code> This is a standard copy-constructor that creates a shallow copy
 *  of the underlying storage; it must also preserve all relevant properties. </li>
 * </ol>
 * </P>
 * <H1>Prohibited Constructions/Classes/Utilities, etc</H1>
 * Obviously, you should <b>not</b> use any of Java's collection classes to implement this class. In other
 * words, you cannot use any collection class from the <code>java.util.*</code> library, except for the <code>Iterable</code>
 * interface that you will implement.
 * <P>
 * Note: you may copy the bodies of your previous implementation into the relevant methods below. Please 
 * refrain from copying entire files as this may confuse Eclipse and/or other programs, such as CVS, 
 * that keep track of such things.
 * 
 * The relevant changes/improvements to this version include (but are not limited to)
 * <ul>
 * <li>The <code>get</code> accessor is improved to throw an <code>IllegalStateException</code> in the event that 
 * calling <code>get(i)</code> where the index <code>i</code> references a <code>null</code> and the <code>DynArray</code>
 * has been created to disallow nulls. (See the specific documentation in the reference.)</li>
 * <li>The <code>set</code> accessor is improved to throw several exceptions depending upon circumstances.(See the
 * specifics in the documentation for that method in the attached reference manual.)</li>
 * <li>The <code>equals()</code> method is tested to ensure that it does not prematurely throw <code>NullPointerException</code>s if the
 * either this or the incoming <code>DynArray</code> instances contain <code>null</code>s.
 * </ul>
 * @author CMSC Student
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
		allowNull = otherArray.allowNull;
		array = new Object[otherArray.array.length];
		for(int i = 0; i < otherArray.size(); i++)
		{
			array[i] = otherArray.get(i);
		}
		size = otherArray.size();
		
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
			throw new IllegalStateException();
		}
		else
		{
			if(array[array.length] != null )
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
		if(atIndex > array.length-1 || array.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		if(array[atIndex] == null && !allowNull)
		{
			throw new IllegalStateException();
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
		if(index < this.size)
		{
			if(!allowNull && array[index] == null)
			{
				throw new IllegalStateException();
			}
			return (T) array[index];
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Set Method
	 * Checks to see if object is null and if the DynArray can accept nulls
	 * Checks to see if index is within the size of the DynArray
	 * Sets array at index to object
	 * @param index
	 * @param object
	 */
	public void set( int index, T object ) 
	{
		if(index < this.size)
		{
			if (object == null && !this.allowNull)
			{
				throw new IllegalArgumentException();
			}
			else
			{
				array[index] = object;
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException();
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
	 * Checks to see if other is null
	 * Checks to see if the sizes are the same
	 * Checks capacity
	 * Checks to see if each item in the DynArray are the same
	 */
	@Override
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
		else if (this.array.length != ((DynArray)other).array.length)
		{
			return false;
		}
		else
		{
			for(int i = 0; i < this.size(); i++)
			{
				if((!((this.array[i] == null) && (((DynArray)other).array[i] == null))
						|| !(this.array[i].equals(((DynArray) other).array[i]))))
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
