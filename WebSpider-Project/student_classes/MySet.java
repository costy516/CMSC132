package student_classes;

import java.util.ArrayList;

public class MySet<T>
{
	ArrayList<T> data;
	private boolean adding;
	
	public MySet()
	{
		data = new ArrayList<T>();
	}
	
	public int size()
	{
		return data.size();
	}
	
	public void clear()
	{
		data.clear();
	}
	
	public synchronized boolean add(T o)
	{
		if(this.contains(o))
		{
			return false;
		}
		else
		{
			data.add(o);
			return true;
		}
	}
	
	
	public synchronized boolean remove(T o)
	{
		boolean result = data.remove(o);
		return result;
	}
	
	public boolean contains(T o)
	{
		return data.contains(o);
	}
}