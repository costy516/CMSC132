package student_classes;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * This is a truly minimal implementation of the well-known HashTable 
 * class that is still defined in Java (qv). Essentially, a HashTable
 * allows users to associate values with keys in O(1) time (amortized
 * over the life of the running application). 
 * 
 * Note: this implementation throws NullPointerExceptions if <code>put</code>
 * is called with either a null key or a null value.
 * 
 * Moreover, instead of returning Enumerations (old school), this version
 * returns Iterators for its keys and values.
 * 
 * You could theoretically use objects of this class as a hash table, but
 * too much would still need to be done, for real applications.
 * 
 * @author UMD CS Department.
 *
 * @param <E> ///> Keys type
 * @param <V> ///> Values type.
 */
public class HashTbl<E, V> {
	/* define your properties here */
	private final int defaultSize=41;
	private Object buckets[] = new Object[ defaultSize ];
	private int putIndex;
	/** Only one public constructor is provided ... in reality, we'd
	 * probably like a few more that allowed us to control growth rate,
	 * initial size, etc.
	 */
	public HashTbl() { 
		putIndex = 0;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Installs the <code>value</code> on the <code>key</code> in this
	 * table. Note, if either parameter is <code>null</code> a
	 * <code>NullPointerException</code> is signaled. 
	 * @param key
	 * @param value
	 */
	public void put( E key, V value ) {
		if(key == null || value == null)
		{
			throw new NullPointerException();
		}
		Object[] temp = (putIndex >= buckets.length - 1)?(new Object[buckets.length + defaultSize]):(new Object[buckets.length]);
		boolean duplicate = false;
	
		for(int i = 0; i < buckets.length; i++)
		{
			temp[i] = buckets[i];
			if((buckets[i] != null) && ((Bucket)buckets[i]).getKey().equals(key))
			{
				duplicate = true;
			}
		}
		buckets = temp;
		if(!duplicate)
		{
			buckets[putIndex] = new Bucket(key, value);
		}
		putIndex++;
		
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Returns the value associated with <code>key</code>. Because this is a table,
	 * nulls are not allowed, therefore if a <code>null</code> is returned ... we
	 * know that the key wasn't found.
	 * @param key
	 * @return
	 */
	public V get( E key ) {
		for(int i = 0; i < buckets.length; i++)
		{
			if(buckets[i] != null && ((Bucket)buckets[i]).getKey().equals(key))
			{
				return ((Bucket)buckets[i]).value;
			}
		}
		return null;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Returns an Iterator over the <code>key</code>s in this table; note, no particular
	 * order is specified here.
	 * @return an Iterator over Keys.
	 */
	public Iterator<E> keys() {
		return new HashTbl.keyIterator();
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Returns an Iterator over the <code>value</code>s in the table; note, no
	 * particular order is assumed.
	 * @return
	 */
	public Iterator<V> values() {
		return new HashTbl.valueIterator();
		//throw new UnsupportedOperationException("You must implement this method.");
	}

	public class Bucket
	{
		E key;
		V value;
		
		public Bucket(E key, V value)
		{
			this.key = key;
			this.value = value;
		}
		public E getKey()
		{
			return key;
		}
		public V getValue()
		{
			return value;
		}
		public void setValue(V value)
		{
			this.value = value;
		}
	}
	
	public class keyIterator implements Iterator<E>
	{
		int pos = 0;
		@Override
		public boolean hasNext() {
			return (pos < putIndex);
		}

		@Override
		public E next() {
			if(hasNext())
			{
				E next = ((Bucket)buckets[pos]).getKey();
				pos++;
				return next;
			}
			throw new NoSuchElementException();
		}
		
	}
	
	public class valueIterator implements Iterator<V>
	{
		int pos = 0;
		@Override
		public boolean hasNext() {
			return (pos < putIndex);
		}

		@Override
		public V next() {
			if(hasNext())
			{
				V next = ((Bucket)buckets[pos]).getValue();
				pos++;
				return next;
			}
			throw new NoSuchElementException();
		}
		
	}
}
