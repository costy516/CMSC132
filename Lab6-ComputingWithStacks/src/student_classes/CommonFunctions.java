package student_classes;

import java.util.Stack;

/*
 * You must implement the following methods using Java's Stack object to 
 * replace the iteration/recursion in the original functions with a series
 * of stack operations, including push, pop, peek and isEmpty. Use no other
 * special library functions or classes; in other words, your code should use
 * standard arithmetic operators and in the case of the reverse function, only
 * push and pop and the default constructor for whichever Java collection
 * class you choose to represent lists.
 */

public class CommonFunctions 
{
	private static Stack<Integer> stack;
	private static Stack<String> stack2;
	private static Stack<String> stack3;

	/**
	 * Checks to see if n is 1 if so returns 1
	 * If not multiplies n to the stack and degrades n by 1 until n == 1
	 * Returns item at top of stack
	 * @param n
	 * @return
	 */
	public static int factorial( int n ) 
	{
		stack = new Stack<Integer>();
		stack.push(1);
		if(n != 1)
		{
			while(n > 1)
			{
				stack.push(stack.peek()*n);
				n--;
			}
		}
		return stack.peek();
		//throw new UnsupportedOperationException("you must implement this method" );
	}
	/**
	 * Creates a stack with the first 2 digits of fibonacci sequence
	 * If n == 0 --> returns 0
	 * If n == 1||2 --> returns 1
	 * If n > 2 --> cycles through a loop that adds previous digits together
	 * 				after each cycle decrements n by 1
	 * 				returns when n == 2
	 * @param n
	 * @return
	 */
	public static int fibonacci( int n ) 
	{
		stack = new Stack<Integer>();
		stack.push(1);
		stack.push(1);
		int temp1, temp2 = 0;
		if(n == 0)
		{
			return 0;
		}
		else if(n == 1 || n == 2)
		{
			return 1;
		}
		while(n > 2)
		{
			temp1 = stack.pop();
			temp2 = stack.peek();
			stack.push(temp1);
			stack.push(temp1+temp2);
			
			n--;
		}
		return stack.peek();
		//throw new UnsupportedOperationException("you must implement this method" );
	}
	/**
	 * Your documentation here
	 * @param theStack
	 * @return
	 */
	public static <T extends Comparable< T> > T min( Stack< T > theStack ) 
	{
		T minimum = theStack.pop();
		while(!theStack.isEmpty())
		{
			if(theStack.peek().compareTo(minimum) <= 0)
			{
				minimum = theStack.peek();
			}
			theStack.pop();
		}
		return minimum;
		//throw new UnsupportedOperationException("you must implement this method" );
	}
	/**
	 * Your documentation goes here
	 * @param text
	 * @return
	 */
	public static boolean isBalanced( String text ) 
	{
		stack2 = new Stack<String>();
		if (text == null)
		{
			return false;
		}
		else
		{
			for(int i = 0; i < text.length(); i++)
			{
				if(text.substring(i, i+1).equals("("))
				{
					stack2.push("(");
				}
				else if(text.substring(i, i+1).equals(")"))
				{
					if(stack2.isEmpty())
					{
						return false;
					}
					else
					{
						stack2.pop();
					}
				}
			}
		}
		return stack2.isEmpty();
		//throw new UnsupportedOperationException("you must implement this method" );
	}
	
	/**
	 * 
	 * Your documentation here
	 * @param str
	 * @return
	 */
	public static boolean isPalindrome( String str ) 
	{
		stack2 = new Stack<String>();
		stack3 = new Stack<String>();
		str = str.replaceAll(" ", "");
		for(int i = 0; i < str.length(); i++)
		{
			stack2.push(str.substring(i, i+1));
		}
		for(int i = 0; i < str.length()/2; i++)
		{
			stack3.push(stack2.pop());
		}
		if(str.length()%2 == 1)
		{
			stack2.pop();
		}
		while(!stack2.isEmpty() && !stack3.isEmpty())
		{
			if(!stack2.pop().equals(stack3.pop()))
			{
				return false;
			}
				
		}
		return true;
		//throw new UnsupportedOperationException("you must implement this method" );
	}
}
