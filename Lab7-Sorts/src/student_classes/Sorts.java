package student_classes;
import static student_collections.SList.*;
import student_collections.SList;

/**
 * Common location to contain the quicksort and mergesort routines. Note, you will also
 * create public methods that are required to support (implement) these sorts, such as
 * "append," "merge," and maybe others.
 * 
 * <h1>Important Considerations here!</h1>
 * Please read through these carefully:
 * <ul>
 * <li>No iterative constructions should be used here.</li>
 * <li>No exception handling will be permitted.</li>
 * <li>Use the special "NULL" from the SList package in place of Java's 
 * <code>null</code>, or, better, return the original argument if it 
 * has been reduced to null.</li>
 * <li><b>DO NOT</B> import anything from java.util.* in this file.</li>
 * <li>Do not mess with the imports at the top of this file, or in the
 * StudentTests file.</li>
 * </ul>
 * 
 * @author UMD CS Department.
 *
 */
public class Sorts {
	/**
	 * your documentation here
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static <T> SList<T> append( SList<T> list1, SList<T> list2 ) 
	{
		SList<T> list3 = list();
		if(isEmpty(list1) && isEmpty(list2))
		{
			return NULL;
		}
		else if(isEmpty(list1))
		{
			return list2;
		}
		else if(isEmpty(list2))
		{
			return list1;
		}
		return cons(first(list1), append(rest(list1), list2));
		
		//throw new UnsupportedOperationException("implement this method!");
	}
	/**
	 * your documentation here
	 * @param list
	 * @param index
	 * @return
	 */
	public static< T > SList<T> take( SList<T> list, int pos ) {
		if(pos > length(list))
		{
			throw new IllegalStateException();
		}
		else if(pos == 0)
		{
			return NULL;
		}
		else
		{
			return cons(first(list), take(rest(list), pos-1));
		}
		//throw new UnsupportedOperationException("implement this method!");
	}
	/**
	 * your documentation here
	 * Note: <code>drop( someList, 0 )</code> returns the original list.
	 * @param list
	 * @param pos
	 * @return
	 */
	public static < T > SList< T > drop( SList< T > list, int pos ) {
		if(pos > length(list))
		{
			throw new IllegalStateException();
		}
		else if (isEmpty(list))
		{
			return NULL;
		}
		else if (pos == 0)
		{
			return list;
		}
		return drop(rest(list), --pos);
		
		//throw new UnsupportedOperationException("implement this method!");
	}
	/**
	 * Your documentation here.
	 * @param list
	 * @return
	 */
	public static <T extends Comparable< T >> SList<T> mergeSort(SList<T> list ) 
	{
		if(isEmpty(list))
		{
			return NULL;
		}
        if (length(list) == 1)
        {
            return list;
        }
        else
        {
        	//Need to change order of append and mergeSort
            SList<T> list1 = mergeSort(take(list, length(list)/2));
            SList<T> list2 = mergeSort(drop(list, length(list)/2));
            SList <T> temp = list(first(list));
         
            //Cant figure out where to call the checker
        	if (first(temp).compareTo(first(rest(list))) >= 0) 
            {
            	return (append(list, temp));
            }
            else
            {
            	return (append(temp, list));
            }
        }
		//throw new UnsupportedOperationException("implement this method!");
	}
	/**
	 * your documentation here.
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<T>> SList<T> qSort(SList<T> list ) {
		if(length(list)<2)
		{
			return list;
		}
		T pivot = first(list);
		SList<T> leftSort = lessThan(pivot,list);
		SList<T> rightSort = greaterThan(pivot,list);
		SList<T> middleSort = equalTo(pivot, list);
		SList<T> leftSide = append(qSort(leftSort), middleSort);
		return append(leftSide, qSort(rightSort));
		
	//	throw new UnsupportedOperationException("implement this method!");
	}
	private static <T extends Comparable <T>> SList<T> lessThan(T pivot, SList<T> list){
		if(length(list)<1)
		{
			return list;
		}
		else if(first(list).compareTo(pivot)<0)
		{
			return cons(first(list),lessThan(pivot,rest(list)));
		}
		else
		{
			return lessThan(pivot, rest(list));
		}
	}
	private static <T extends Comparable <T>> SList<T> greaterThan(T pivot, SList<T> list){
		if(length(list)<1)
		{
			return list;
		}
		else if(first(list).compareTo(pivot)>0)
		{
			return cons(first(list),greaterThan(pivot,rest(list)));
		}
		else
		{
			return greaterThan(pivot, rest(list));
		}
	}
	private static <T extends Comparable <T>> SList<T> equalTo(T pivot, SList<T> list){
		if(length(list)<1)
		{
			return list;
		}
		else if(first(list).compareTo(pivot)==0)
		{
			return cons(first(list),equalTo(pivot,rest(list)));
		}
		else
		{
			return equalTo(pivot, rest(list));
		}
	}
}
