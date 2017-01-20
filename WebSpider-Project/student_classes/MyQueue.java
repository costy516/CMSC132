package student_classes;

import java.util.LinkedList;
import java.util.Queue;


public class MyQueue<T> 
{
	Queue<T> queue;
	
	
	/**
	 * Null Constructor
	 */
	public MyQueue()
	{
		queue = new LinkedList<T>();
	}
	
	/**
	 * Data Constructor (first item already in queue)
	 * @param data
	 */
	public MyQueue(T data)
	{
		queue = new LinkedList<T>();
		this.enqueue(data);
	}
	
	/**
	 * Gets size of queue
	 * @return
	 */
	public int size()
	{
		return queue.size();
	}
	
	/**
	 * Clears queue
	 */
	public void clear()
	{
		queue.clear();
	}
	
	/**
	 * Adds o to end of queue
	 * @param o
	 */
	public synchronized void enqueue(T o)
	{
		queue.add(o);
		notifyAll();
	}
	
	/**
	 * Removes the first item in the queue and returns it
	 * @return
	 * @throws InterruptedException 
	 */
	public synchronized T dequeue()
	{
		while(this.isEmpty())
		{
			try{
			wait();
			} catch (InterruptedException e)
			{
				
			}
		}
		T result = queue.peek();
		queue.poll();
		return result;
	}
	
	public boolean isEmpty()
	{
		return (size()<1);
	}
}
