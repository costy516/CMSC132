package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 *  
 */
 public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> 
 {

	/* Provide whatever instance variables you need */
	 private K theKey;
	 private V theValue;
	 private Tree<K,V> left, right;
	/**
	 * Only constructor we need.
	 * @param key
	 * @param value
	 * @param left
	 * @param right
	 */
	public NonEmptyTree(K key, V value, Tree<K,V> theLeft, Tree<K,V> theRight) 
	{
		theKey = key;
		theValue = value;
		left = theLeft;
		right = theRight;
		//throw new UnsupportedOperationException("You must implement this method.");
	}

	/**
	 * Checks to see which side of the tree the key is on
	 * @param key
	 */
	public V search(K key) 
	{
		if(key.compareTo(this.theKey) > 0)
		{
			return this.right.search(key);
		}
		else if(key.compareTo(this.theKey) < 0)
		{
			return this.left.search(key);
		}
		return this.theValue;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Checks to see which side of the tree the new leaf should go on
	 * @param key
	 * @param value
	 */
	public NonEmptyTree<K, V> insert(K key, V value) 
	{
		if(key.compareTo(this.theKey) > 0)
		{
			right = this.right.insert(key, value);
		}
		else if(key.compareTo(this.theKey) < 0)
		{
			left = this.left.insert(key, value);
		}
		else
		{
			theValue = value; 
		}
		return this;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Removes tree with the key
	 * @param key
	 */
	public Tree<K, V> delete(K key) 
	{
		if(key.compareTo(this.theKey) > 0)
		{
			right = right.delete(key);
		}
		else if(key.compareTo(this.theKey) < 0)
		{
			left = left.delete(key);
		}
		else if(key.compareTo(this.theKey) == 0)
		{
			try
			{
				theValue = this.search(right.min());
				theKey = right.min();
				right = right.delete(right.min());
			} 
			catch(TreeIsEmptyException e)
			{
				return left;
			}
		}
		return this;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Searches through tree to find largest key
	 */
	public K max() {
		try
		{
			K temp = this.right.max();
			return temp;
		}
		catch(TreeIsEmptyException e)
		{
			return theKey;
		}
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Searches through tree to find smallest key
	 * Returns smallest key
	 */
	public K min() {
		try
		{
			K temp = this.left.min();
			return temp;
		}
		catch (TreeIsEmptyException e) 
		{
			return this.theKey;
		}
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * Returns amount of trees that are connected to the root
	 */
	public int size() 
	{
		return left.size() + right.size() + 1;
		//throw new UnsupportedOperationException("You must implement this method.");
	}

	/**
	 * Adds keys to the collection
	 */
	public void addKeysToCollection(Collection<K> c) 
	{
		this.left.addKeysToCollection(c);
		c.add(this.theKey);
		this.right.addKeysToCollection(c);
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	/**
	 * creates a subTree from x key to y key
	 */
	public Tree<K,V> subTree(K fromKey, K toKey) {
		if(theKey.compareTo(toKey) > 0)
		{
			return this.left.subTree(fromKey, toKey);
		}
		if(theKey.compareTo(fromKey) < 0)
		{
			return this.right.subTree(fromKey, toKey);
		}
		return new NonEmptyTree<K,V>(this.theKey, this.theValue, left.subTree(fromKey, toKey), right.subTree(fromKey, toKey));
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public int height() {
		return 1+Math.max(left.height(), right.height());
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public void inorderTraversal(TraversalTask<K,V> p) {
		if (p != null)
		{
			left.inorderTraversal(p);
			p.performTask(theKey, theValue);
			right.inorderTraversal(p);
		}
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public void rightRootLeftTraversal(TraversalTask<K,V> p) {
		if (p != null) 
		{
			right.rightRootLeftTraversal(p);
			p.performTask(theKey, theValue);
			left.rightRootLeftTraversal(p);
		}
		//throw new UnsupportedOperationException("You must implement this method.");
	}	
}