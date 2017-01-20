package utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

//import listClasses.BasicLinkedList;

//import listClasses.BasicLinkedList.Node;

//import listClasses.BasicLinkedList.Node;

/**
 * <P>A \code>FunctionalList</code> object supports linked-list operations but, unlike the
 * "standard" implementation that performs \emph{in situ} modifications, e.g., destructively modifies
 * the original list when adding/removing elements, a "functional" list create copies of the original 
 * object with the desired modifications. This has several ramifications---some good, some not so good.
 * <P>
 * <BR>
 * <P>In this assignment, you will implement a functional linked list that provides a subset of useful
 * operations.
 * @author UMD CS Department
 *
 *
 * @param <T>
 */
public class FunctionalList<T> implements Iterable<T> {
	/**
	 * Internal (hidden) class ... define a Node to keep track of values and links.
	 * @author UMD CS Department
	 *
	 * @param <T>
	 */
	private class Node  {
		// properties here:
		public Object data;
		public Node next;
		
		/**
		 * Creates new node with next being null
		 * obj becomes the data that is stored in the node
		 * @param obj
		 */
		public Node (Object obj)
		{
			data = obj;
		}
		
		/**
		 * Copy constructor take in node (copy) and makes a copy
		 * @param copy
		 */
		public Node (Node copy)
		{
			data = copy.data;
			next = copy.next;
		}
		/**
		 * A constructor to set the next element and the next node (after)
		 * @param element
		 * @param after
		 */
		public Node (Object element, Node after) 
		{
			data = element;
			next = after;
		}
	}
	
	private class theIterator implements Iterator<T>
	{
		public Node pos = head;
		
		/**
		 * Checks to see if there is a next item in the list
		 */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return  (pos == null)?(false):(true);
		}
		
		/**
		 * Return the data of the next node
		 * @return element
		 */
		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				T element = (T) pos.data;
				pos = pos.next;
				return (T) (element);
			}
		}
		
	}
	
	public Node head;
	// define additional properties here.
	
	
	// define ctor(s) here:
	/**
	 * Creates new empty FunctionalList
	 */
	public FunctionalList() {
		head = null;
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	/**
	 * Copies the FunctionalList that is passed in the param
	 * @param copy
	 */
	public FunctionalList (FunctionalList<T> copy)
	{
		this.head = copyConstructor_aux(copy.head);
	}
	
	/**
	 * Cycles through the list that needs to be copied
	 * Creates a deep copy of each node
	 * @param temp
	 * @return List of nodes
	 */
	private Node copyConstructor_aux(Node temp) 
	{	
		if (temp == null) 
		{
			return null;
		} 
		else 
		{
			return new Node(temp.data, copyConstructor_aux(temp.next));
		}
		
	}
	
	// public interface:
	/**
	 * Creates new node with element
	 * @param element
	 * @return the new list
	 */
	public FunctionalList<T> add( T element ) 
	{
		FunctionalList<T> result = new FunctionalList<T> (this);
		
		result.head = result.add_aux(element, result.head);
		
		return result;
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	
	/**
	 * Adds new node to the end of the deep copied list
	 * @param data
	 * @param temp
	 * @return new deep copied list
	 */
	public Node add_aux(T data, Node temp)
	{
		if (temp == null) 
		{
			temp = new Node(data);
		} 
		else
		{	
			temp.next = add_aux(data, temp.next);
		}
		return temp;
	}
	
	/**
	 * Combines two FunctionalLists together
	 * @param other
	 * @return
	 */
	public FunctionalList<T> append( FunctionalList<T> other ) 
	{
		FunctionalList<T> result = new FunctionalList<T> (this);
		FunctionalList<T> toAdd = new FunctionalList<T> (other);
		
		result.head = append_aux(result.head, toAdd.head);
		
		return result;
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	
	/**
	 * Finds the end of the first FunctionalList
	 * Adds toAdd.head to the list, successfully combining the two
	 * @param pos
	 * @param toAdd
	 * @return
	 */
	private Node append_aux(Node pos, Node toAdd) 
	{
		
		if (pos == null) 
		{
			pos = copyConstructor_aux(toAdd);
		} 
		else 
		{
			pos.next = append_aux(pos.next, toAdd);
		}
		return pos;
			
	}
	/**
	 * Removes requested element
	 * Searches through list to find the element that needs to be removed
	 * @param element
	 * @return result
	 */
	public FunctionalList<T> remove( T element ) 
	{
		FunctionalList<T> result = new FunctionalList<T> (this);
		
		if (result.head.data == element && result.size() == 1) 
		{
			return null;
		} 
		else 
		{
			result.head = remove_aux(element, result.head);
			return result;			
		}
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	
	/**
	 * Searches through list
	 * If node to be removed is found links previous node skips the removed node and connects the next node
	 * @param data
	 * @param temp
	 * @return New List with removed node
	 */
	private Node remove_aux (T data, Node temp) 
	{
		if(temp == null)
		{
			return null;
		}
		if (temp.data == data) 
		{
			if (temp.next == null)
			{
				return null;
			} 
			else 
			{
				return temp.next;
			}
		} 
		else 
		{
			return new Node(temp.data, remove_aux(data, temp.next));
		}
		
	}
	/**
	 * Produces the reversed version of the List
	 * @return newList
	 */
	public FunctionalList<T> reverse() 
	{
		FunctionalList<T> result = new FunctionalList<T> (this);
		
		result.head = reverse_aux(result.head);
		
		return result;
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	
	/**
	 * Goes node by node to reverse the list
	 * @param temp
	 * @return
	 */
	private Node reverse_aux(Node temp) 
	{	
		if (temp == null) 
		{
			return null;
		} 
		else 
		{
			if (temp.next == null) 
			{
				return temp;
			} 
			else 
			{
				Node tempNext = temp.next;
				temp.next = null;
				Node reversedNode = reverse_aux(tempNext);
				tempNext.next = temp;
				temp = reversedNode;
			}
		}
		return  temp;
		
	}
	
	/**
	 * Finds the size of the list
	 * @return
	 */
	public int size() 
	{
		return size_aux(head);
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	/**
	 * Counts how many nodes are in the list
	 * @param temp
	 * @return
	 */
	public int size_aux(Node temp)
	{
		if(temp == null)
		{
			return 0;
		}
		else
		{
			return (size_aux(temp.next) + 1);
		}
	}

	/**
	 * Finds the position of an element
	 * @param element
	 * @return
	 */
	public int positionOf( T element ) 
	{
		FunctionalList<T> result = new FunctionalList<T> (this);
		
		return position_aux(element, 0, result.head);
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	
	/**
	 * Finds the position of an element by checking each node
	 * @param element
	 * @param index
	 * @param list
	 * @return
	 */
	private int position_aux(T element, int index, Node temp) {
		
		if (this == null || temp == null) 
		{
			return -1;
		} 
		else 
		{
			if (temp.data.equals(element)) 
			{
				return index;
			} 
			else 
			{
				temp = temp.next;
				return position_aux(element, index + 1, temp);
			}
		}
	}
	
	/**
	 * Find the element at the nth index
	 * @param index
	 * @return
	 * @throws IllegalAccessException
	 */
	public T nth ( int index) throws IllegalAccessException 
	{
		if (this == null) 
		{
			throw new IllegalAccessException();
		}
		
		FunctionalList<T> newList = new FunctionalList<T> (this);
		
		if (index >= this.size()) 
		{
			throw new IllegalArgumentException();
		}
		
		return nth_aux(index, 0, newList);
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	
	/**
	 * Cycles to index to find element
	 * @param index
	 * @param position
	 * @param list
	 * @return
	 */
	private T nth_aux (int index, int position, FunctionalList<T> list) 
	{
		
		if (index == position) 
		{
			return (T) list.head.data;
		}
		else 
		{
			list.head = list.head.next;
			return nth_aux(index, (position + 1), list);
		}
		
	}
	
	/**
	 * Checks to see if list is empty
	 * @return
	 */
	public boolean isEmpty() 
	{
		return size() <= 0;
	}
	// override(s):
	/**
	 * Creates a toString
	 * Puts elements in brackets and seperates by commas
	 */
	@Override
	public String toString() 
	{
		if(!this.isEmpty()) 
		{
			Node current = head;
			String str = new String("[");
			while (current.next != null) 
			{
				str += (current.data.toString() + ", ");
				current = current.next;
			}
			str += current.data.toString() + "]";
			return str;
		}
		return "[]";
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	
	/**
	 * Changes list to array
	 * @return
	 * @throws IllegalAccessException
	 */
	public Object[] toArray() throws IllegalAccessException 
	{
		Object[] result = new Object[this.size()];
		for (int i = 0; i < result.length; i++) 
		{
			result[i] = this.nth(i);
		}

		return result;
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	
	/**
	 * Changes key to value
	 * @param key
	 * @param value
	 * @return
	 */
	public FunctionalList<T> subst( T key, T value ) {
		FunctionalList<T> result = new FunctionalList<T> (this);
		
		result.head = result.subst_aux(key, value, result.head);
		
		return result;
		//throw new UnsupportedOperationException("You need to implement this method.");
	}
	/**
	 * Cycles through each node to change key to value
	 * @param key
	 * @param value
	 * @param head
	 * @return
	 */
	public Node subst_aux(T key, T value, Node temp)
	{
		if (temp == null) 
		{
			return null;
		}
		if (temp.data == key) 
		{
			temp.data = value;
			temp.next = subst_aux(key, value, temp.next);
		} 
		else 
		{
			temp.next = subst_aux(key, value, temp.next);
		}
		return temp;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new FunctionalList.theIterator();
	}

}
