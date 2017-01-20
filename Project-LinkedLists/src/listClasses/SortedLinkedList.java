package listClasses;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

public class SortedLinkedList<T> extends BasicLinkedList<T>
{
	
	
	private Comparator<T> theComparator;
	
	/**
	 * Passes super from BasicLinkedList class
	 * Stores comparator to be called in add and remove methods
	 * @param comparator
	 */
	public SortedLinkedList(java.util.Comparator<T> comparator)
	{
		super();
		theComparator = comparator;
	}
	
	/**
	 * Passes the element to put in newNode
	 * First checks to see if head is null if (true) then makes newNode head and head.next = tail
	 * Next checks checks to see if the element that is passed is null or if the tail is not null then
	 * 		**Checks to see element is null then puts newNode as tail
	 * 		**Checks to see if element is before the head then sent as head when true
	 * 		**Checks to see if element is after the tail then set as tail when true
	 * 		**Else cycles through compares nodes to find placement in list to add newNode
	 *  
	 * @param element
	 * @return this
	 */
	public SortedLinkedList<T> add(T element)
	{
		Node newNode = new Node(element);
		Node temp = head;

		if (head == null) 
		{
			newNode.next = tail;
			head = newNode;
			tail = newNode;
		} 
		else 
		{
			if (theComparator.compare((T) head.name, element) > 0) 
			{
				newNode.next = head;
				head = newNode;
			} 
			else 
			{
				if (theComparator.compare((T) tail.name, element) < 0) 
				{
					tail.next = newNode;
					tail = newNode;
					tail.next = null;
				} 
				else 
				{
					while (theComparator.compare((T) temp.next.name, element) < 0) 
					{
						temp = temp.next;
					}
					newNode.next = temp.next;
					temp.next = newNode;
				}
			} 
		}
		
		size++;
		return this;
	}
	
	/**
	 * See remove doc in BasicLinkedList
	 * @param targetData
	 * @return
	 */
	public BasicLinkedList<T> remove(T targetData)
	{
		super.remove(targetData, theComparator);
		return this;
		
	}
	
	/**
	 * Cannot be added to specific place if sorted list
	 * @param data
	 * @return this
	 */
	public BasicLinkedList<T> addToEnd(T data)
	{
		if(this instanceof SortedLinkedList)
		{
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}
		
		super.addToEnd(data);
		return this;
		
	}
	
	/**
	 * Cannot be added to specific place if sorted list
	 * @param data
	 * @return this
	 */
	public BasicLinkedList<T> addToFront(T data)
	{
		if(this instanceof SortedLinkedList)
		{
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}
		
		super.addToFront(data);
		return this;	
		
	}
}