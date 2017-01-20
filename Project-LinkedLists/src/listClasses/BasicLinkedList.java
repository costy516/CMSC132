package listClasses;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.w3c.dom.Node;


public class BasicLinkedList<T> extends java.lang.Object implements java.lang.Iterable<T>
{
	//TA tips for documentation
	//preconditions
	//postconditions
	//invariant that is true before and after
	
	
	protected Node head;
	protected Node tail;
	
	protected int size;
	
	/**
	 * Sets initial values in constructor to null
	 */
	public BasicLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Allows access to the size 
	 * @return size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Creates a node with the data at the end of the list
	 * If the list is empty makes new node that is both the head and tail
	 * It increments size accordingly
	 * Returns current list
	 * @param data
	 * @return this
	 */
	public BasicLinkedList<T> addToEnd(T data)
	{
		Node newNode = new Node(data);
		if(tail == null)
		{
			tail = newNode;
			if (head == null)
			{
				head = newNode;
			}
			else
			{
				head.next = tail;
			}
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
			tail.next = null;
		}
		size++;
		return this;
		
	}
	
	/**
	 * Creates a node with the data at the front of the list
	 * Increments the size of the list
	 * Returns current list
	 * @param data
	 * @return this
	 */
	public BasicLinkedList<T> addToFront(T data)
	{
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;
		return this;
	}
	
	/**
	 * Returns the data that is stored in the head
	 * @return head.name
	 */
	public T getFirst()
	{
		return (T) head.name;
	}
	
	/**
	 * Returns the data that is stored in the tail
	 * @return tail.name
	 */
	public T getLast()
	{
		return (T) tail.name;
	}
	
	/**
	 * Returns the head.name
	 * Removes first node in list makes second node the new head
	 * @return head.name
	 */
	public T retrieveFirstElement()
	{
		Node temp = ((head.next).next);
		Node result = head;
		head = head.next;
		head.next = temp;
		size--;
		return (T) result.name;
	}
	
	/**
	 * Returns the tail.name
	 * Removes last node in list makes second to last node the new tail
	 * @return tail.name
	 */
	public T retrieveLastElement()
	{
		//need to add in what occurs if tail is null
		Node temp = head;
		Node result;
		boolean found = false;
		while(temp.next.next != null)
		{
				temp = temp.next;
				
		}
		result = tail;
		tail = new Node(temp);
		tail.next = null;
		
		size--;
		return (T) result.name;
	}
	
	/**
	 * Passes in name that needs to be removed and the comparator needed to test it.
	 * Checks to see if head is null, if it is no changes made
	 * Checks to see if the target is at the head if it is removes head
	 * Checks to see if the target is at the tail if it is removes tail
	 * If not the head using a loop cycles through the list to find target to remove makes (previous node).next = (target.next)
	 * Returns current list
	 * @param targetData
	 * @param comparator
	 * @return this
	 */
	public BasicLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator)
    {
		if (head == null) 
		{
			return this;
		} 
		else 
		{
			if (comparator.compare((T) head.name, targetData) == 0) 
			{
				if (getSize() == 2) 
				{
					head = tail;
					size--;
				} 
				else 
				{
					head = head.next;
					size--;
				}
			} 
			if (comparator.compare((T) tail.name, targetData) == 0) 
			{
				retrieveLastElement();
				return this;
			} 
			else 
			{
				if(head != null && (head != tail)) 
				{
					Node temp = head.next;
					Node previous = head;
					boolean change = false;
					while(!change) 
					{
						if(comparator.compare((T) temp.name, targetData) != 0) 
						{
							if(temp.name.equals(tail.name)) 
							{
								change = true;
							} 
							else 
							{
								temp = temp.next;
								previous = previous.next;
							}
						} 
						else 
						{
							previous.next = temp.next;
							size--;
							change = true;
						}
					}
				}
			}
			
		}	
		
		return this;
	}
	
	/**
	 * Creates Iterator where pos is the position of the nodes when cycling through the list
	 *
	 */
	class theIterator implements Iterator<T>
	{
		public Node pos = head;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return  (pos == null)?(false):(true);
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				T element = (T) pos.name;
				pos = pos.next;
				return (T) (element);
			}
		}
		
	}
	
	/**
	 * name is the data type that is stored
	 * next is the following node in the list
	 */
	public class Node <T>
	{
		public Object name;
		public Node next;
		
		public Node (Object obj)
		{
			name = obj;
		}
		
		public Node (Node copy)
		{
			name = copy.name;
			next = copy.next;
		}
	}
	
	/**
	 * called version of iterator
	 */
	@Override
	public Iterator<T> iterator() 
	{
		// TODO Auto-generated method stub
		return new BasicLinkedList.theIterator();
	}
}