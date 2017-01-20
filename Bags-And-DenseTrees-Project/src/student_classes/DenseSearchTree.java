package student_classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * A Binary Search Tree data-structure that maintains a count
 * of repetitive values (as nodes).
 * 
 * @author UMD CS Dept.
 *
 * @param <T>
 */

public class DenseSearchTree <T extends Comparable<T>> implements Iterable<T>
{
	private int duplicates;
	private TNode root;
	
	class TNode
	{
		T value;
		TNode left;
		TNode right;
		int duplicates;
		
		TNode ()
		{
			duplicates = 0;
		}
		
		TNode (T ele)
		{
			value = ele;
			duplicates = 0;
		}
		
		TNode (T ele, TNode l, TNode r)
		{
			value = ele;
			left = l;
			right = r;
			duplicates = 0;
		}
		
		TNode (TNode other)
		{
			value = other.value;
			left = other.left;
			right = other.right;
			duplicates = 0;
		}
	}
	/**
	 * Constructor
	 */
	public DenseSearchTree()
	{
		root = new TNode();
	}
	
	/**
	 * Note: our trees follow a slightly different convention regarding both 
	 * our ordering relation and the placement of duplicates, viz:
	 * 		• Left branch contains all elements < tree.value;
	 * 		
	 * 		• Right branch contains all elements >= tree.value.
	 * 
	 * Rather than place duplicate elements on the right branch, 
	 * each Tree Node maintains a count of copies. For example, 
	 * if we had a tree of Integers containing two instances of the number 1, 
	 * our Tree Node would logically appear as
	 * 
	 * [ left-branch 1:2 right-branch ],
	 * 
	 * where 1:2 means 2 copies of the integer 1.
	 * 
	 * Thus, your add logic will either make a new node and insert it
	 * in the correct position in the tree, or it will find a node with the 
	 * value (key) equal to the value you are adding, and increment its count.
	 *  
	 * This simplifies your remove logic: if the node’s
	 * count is > 0, then decrement by 1, otherwise invoke the remove logic to 
	 * physically remove the node and replace it with a Binary Search Tree.
	 *  
	 * Finally, the "price you pay" for this simplification is that your
	 * Iterator (which presents an "in-order" view of the tree), 
	 * needs to "inflate" or "expand" each node. That is, if you have a node
	 *   
	 *   [ left 3:4 right ]
	 *   
	 *   then 4 instances of the integer 3 need to be created and put into the iteration.
	 */
	public void add(T element) 
	{
		root = add_aux(root, element);
	}
	
	private TNode add_aux (TNode node, T element) 
	{
		if (node == null || node.value == null) 
		{
			node = new TNode (element);
		}
		else if (((Comparable<T>) node.value).compareTo(element) < 0) 
		{
			node.right = add_aux(node.right, element);
		} 
		else if (((Comparable<T>) node.value).compareTo(element) > 0) 
		{
			node.left = add_aux(node.left, element);
		}
		else if (((Comparable<T>) node.value).compareTo(element) == 0)
		{
			node.duplicates++;
		}
		
		return node;
	}
	
	/**
	 * Returns true if at least instance of target is found in tree.
	 * 
	 * @param target
	 * @return
	 */
	public boolean contains (T target)
	{
		if(target == null)
		{
			return false;
		}
		if(target.getClass() != target.getClass())
		{
			return false;
		}
		
		TNode current = root;
		
		while(true)
		{
			if (current == null || current.value == null)
			{
				return false;
			}
			if(current.value.compareTo(target) == 0)
			{
				duplicates = current.duplicates; 
				return true;
			}
			else if(current.value.compareTo(target) > 0)
			{
				current = current.right;
			}
			else if(current.value.compareTo(target) > 0)
			{
				current = current.left;
			}
		}
	}
	
	/**
	 * Returns an int >= 0, indicating how many occurrences 
	 * of target reside in the tree. Note, this function 
	 * returns 0 when the item is not found in tree.
	 * 
	 * @param target
	 * @return
	 */
	public int count (T target)
	{
		if(contains(target))
		{
			return duplicates;
		}
		return 0;
	}
	
	public int size()
	{
		return size_aux(root);
	}
	
	public int size_aux (TNode current)
	{
		if(current == null || current.value == null)
		{
			return 0;
		}
		return ((current.duplicates+1) + size_aux(current.left) + size_aux(current.right));
	}

	public Set<T> asSet()
	{
		Set<T> result = new TreeSet<T>();
		
		asSet_aux(root, result);
		
		return result;
	}
	
	public void asSet_aux(TNode current, Set<T> result)
	{
		if(current == null || current.value == null)
		{
			return;
		}
		else
		{
			asSet_aux(current.left, result);
			result.add(current.value);
			asSet_aux(current.right, result);
		}
	}
	
	public void remove (T value) 
	{
		root = removeHelper(root, value);
	}
	
	private TNode removeHelper(TNode node, T value) 
	{
		if (node == null || node.value == null) 
		{
			return null;
		} 
		else if (((Comparable<T>) node.value).compareTo(value) < 0) 
		{
			node.left = removeHelper(node.left, value);
		} 
		else if (((Comparable<T>) node.value).compareTo(value) > 0) 
		{
			node.right = removeHelper(node.right, value);
		} 
		else if (((Comparable<T>) node.value).compareTo(value) == 0) 
		{
			if(node.duplicates > 1)
			{
				node.duplicates--;
			}
			else 
			{
				node.value = getMin();
				node.right = removeHelper(node.right, (T) node.value);
			}	
		}
		
		return node;
		
	}
	
	public T getMax()
	{
		TNode max = root;
		while (true)
		{
			if(max.right == null || max.right.value == null)
			{
				break;
			}
			else
			{
				max = max.right;
			}
		}
		return max.value;
	}
	
	public T getMin()
	{
		TNode min = root;
		while (true)
		{
			if(min.left == null || min.left.value == null)
			{
				break;
			}
			else
			{
				min = min.left;
			}
		}
		return min.value;
	}
	
	public Iterator<T> iterator()
	{
		return new DenseSearchTree.myIterator();
	}
	
	private class myIterator implements Iterator<T> 
	{
		ArrayList<T> temp = new ArrayList<T> ();
		ArrayList<T> array = toArray(root, temp);

		@Override
		public boolean hasNext() 
		{
			if (array.isEmpty()) 
			{
				return false;
			}
			else 
			{
				return true;
			}
		}

		@Override 
		public T next() 
		{
			if (array.isEmpty()) 
			{
				return null;
			}
			else 
			{
				T temp = array.get(0);
				array.remove(0);
				return temp;
			}
		}
		
		private ArrayList<T> toArray(TNode node, ArrayList<T> array) 
		{
			toArrayList(node, array);	
			return array;			
		}

		private void toArrayList(TNode node, ArrayList<T> array) 
		{
			if (node == null || node.value == null) 
			{
				return;
			} 
			toArrayList(node.left, array);
			array.add((T) node.value);
			toArrayList(node.right, array);		
		}

	}

	

}