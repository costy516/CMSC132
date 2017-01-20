package student_classes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * When you do a web search, the results page shows you a 
 * <a href="http://searchengineland.com/anatomy-of-a-google-snippet-38357">snippet</a> 
 * for each result, showing you search terms in context. For purposes of this project, a
 * snippet is a subsequence of a document that contains all the search terms.
 * 
 * For this project, you will write code that, given a document (a sequence of
 * words) and set of search terms, find the minimal length subsequence in the
 * document that contains all of the search terms.
 * 
 * If there are multiple subsequences that have the same minimal length, you may
 * return any one of them.
 * 
 */
public class MinimumSnippet {

	/**
	 * Compute minimum snippet.
	 * 
	 * Given a document (represented as a <code>List<String></code>), and a set of terms
	 * (also represented as a <code>List<String></code>), find the shortest subsequence of the
	 * document that contains all of the terms.
	 * 
	 * This constructor should find the minimum snippet, and store information
	 * about the snippet in fields so that the methods can be called to query
	 * information about the snippet. All significant computation should be done
	 * during construction.
	 * 
	 * @param document
	 *            The Document is an <code>Iterable<String></code>. Do not change the
	 *            document. It is an <code>Iterable</code>, rather than a <code>List</code>, to allow for
	 *            implementations where we scan very large documents that are
	 *            not read entirely into memory. If you have problems figuring
	 *            out how to solve it with the document represented as an
	 *            <code>Iterable</code>, you may cast it to a <code>List<String></code>; in all but a very
	 *            small number of test cases, in will in fact be a <code>List<String></code>.
	 * 
	 * @param terms
	 *            The terms you need to look for. The terms will be unique
	 *            (e.g., no term will be repeated), although you do not need to
	 *            check for that. There should always be at least one term and 
	 *            your code should
	 *            <code>throw</code> an <code>IllegalArgumentException</code> if "terms" is
	 *            empty.
	 * 
	 * 
	 */
	
	private List<String> snippet;
	
	private int[][] positions;
	private int[][] shortestPositions;

	private int docPosition;
	private int indexOfPos;
	private static int startPos;
	private static int endPos;
	private int lastStoredMinimum;
	
	private boolean inDoc;
	private boolean first;
	private boolean firstTerm;
	//private boolean endCheck;
	
	/**
		 * Constructor
		 * Checks to make sure terms is not null
		 * goes through document in for each loop and stores the positions of the terms
		 * docPosition keeps track of index in the document
		 * indexOfPos keeps track of how many times the term in found in document
		 * Creates a 2D array that will keep track of the terms and the multiple places they reside in the document
		 * Searches the document to find each term and where it is located
		 * shortestPositions is a 2D array that will store the positions of two minimum snippets and compare them for size.  The smaller will be written in shortestPositions [0].
		 * Takes indexes in shortestPositions to create the snippet from the document
		 */
	public MinimumSnippet(Iterable<String> document, List<String> terms) 
	{
		
		if(terms == null || terms.size() == 0)
		{
			throw new IllegalArgumentException();
		}
		//endCheck = false;
		
		//Populates positions array; Positions keeps track of all of the indexes of each term (positions[term][timesInDocument])
		positions = new int [terms.size()] [15];  //15 is an arbitrary number; could sub size of doc
		for(int t = 0; t < terms.size(); t++)
		{
			docPosition = 0;
			indexOfPos = 0;
			inDoc = false;
			for(String s: document)
			{
				if(terms.get(t).equals(s))
				{
					positions[t][indexOfPos] = docPosition;
					indexOfPos++;
					inDoc = true;
				}
				docPosition++;
			}
			if(!inDoc)
			{
				positions[t][0] = -1;
			}
		}
		
		//Takes data form shortestPositions
		shortestPositions = new int [2] [terms.size() + 2];  //last two spots are length of snippet and terms in snippet
		shortestPositions[0][shortestPositions[0].length-1] = -1; 
		firstTerm = true;
		for(int r = 0; r < positions.length; r++)
		{
			shortestPositions[0][r] = -1;
			shortestPositions[1][r] = -1;
			if(positions[r][0] == -1)
			{
				shortestPositions[0][r] = -1;
				shortestPositions[1][r] = -1;
			}
			else
			{
				for(int v = 1; v < positions[r].length; v++)
				{
					if(positions[r][v] == 0)
					{
						positions[r][v] =-1;
					}
				}
				if (firstTerm)
				{
					shortestPositions[0][shortestPositions[0].length-1]++;
					firstTerm = false;
				}
				shortestPositions[0][r] = positions[r][0];
				shortestPositions[0][shortestPositions[0].length-1]++;
			}
		}
		shortestPositions[0][shortestPositions[0].length-2] = checkLength(shortestPositions, 0);
		lastStoredMinimum = -1; // prevents terms not in document from being added
		first = true;		
		for(int i = 0; i < positions[0].length; i++)
		{
			for(int j = 0; j < positions.length; j++)
			{
				if (positions[j][i] != -1)
				{
					shortestPositions[1][j] = positions[j][i];
					
				}
				shortestPositions[1][shortestPositions[1].length-1] = numberOfTerms(shortestPositions, 1);
				shortestPositions[1][shortestPositions[1].length-2] = checkLength(shortestPositions, 1);
				compareSnippets(shortestPositions);
			}
		}
		minMax(shortestPositions);
		docPosition = 0;
		snippet = new ArrayList<String>(shortestPositions[0][shortestPositions[0].length-2]);
		for(String s: document)
		{
			if(docPosition >= startPos && docPosition <= endPos 
					|| (shortestPositions[0][shortestPositions[0].length-1] == 1 && shortestPositions[0][0] == docPosition))
			{
				snippet.add(s);
				if(shortestPositions[0][shortestPositions[0].length-1] == 1)
				{
					break;	
				}
			}
			docPosition++;
		}
		
		//throw new UnsupportedOperationException("YOU MUST IMPLEMENT THIS!");
	}
	
	/**
	 * Created to populate the last term in shortestPositions (the last term keeps track of terms in snippet)
	 * @param shortestPositions
	 * @param index
	 * @return number of terms found in document
	 */
	public int numberOfTerms(int[][] shortestPositions, int index)
	{
		int result = 0;
		for(int i = 0; i < shortestPositions[index].length - 2; i++)
		{
			if(shortestPositions[index][i] > 0)
			{
				result++;
			}
			else if (shortestPositions[index][i] == 0 && positions[i][0] == 0)
			{
				result++;
			}
		}
		return result;
	}
	
	/**
	 * Created to populate the second to last term in shortestPositions (the second to last term keeps track of size of snippet)
	 * @param sizeTest
	 * @param index
	 * @return
	 */
	public int checkLength(int[][] sizeTest, int index)
	{
		//Made only for shortestPositions[]
		int min = sizeTest[index][0];
		int max = sizeTest[index][0];
		for(int i = 1; i < sizeTest[index].length-2; i++)
		{
			if(sizeTest[index][i] > max)
			{
				max = sizeTest[index][i];
			}
			else if (sizeTest[index][i] < min)
			{
				if((sizeTest[index][i] == 0) && (positions[i][0] >= 0))
				{
					min = sizeTest[index][i];
				}
				else if(sizeTest[index][i] != 0)
				{
					min = sizeTest[index][i];
				}
			}
		}
		return max-min+1;
	}
	/**
	 * Compares the shortestPositions[0] to shortestPositions[1]
	 * if shortestPositions[1] is a shorter snippet with the same number or more terms as shortestPositions[0]
	 * 		then re-populates shortestPositions[0] with  shortestPositions[1]
	 * @param shortestPositions
	 */
	public static void compareSnippets(int[][] shortestPositions)
	{
		if(((shortestPositions[0][shortestPositions[0].length-1] < shortestPositions[1][shortestPositions[1].length-1]) 
					&& (shortestPositions[0][shortestPositions[0].length-1] != -1))
				|| (shortestPositions[0][shortestPositions[0].length-1] == shortestPositions[1][shortestPositions[1].length-1] 
						&& shortestPositions[0][shortestPositions[0].length-2] > shortestPositions[1][shortestPositions[1].length-2])
				|| ((shortestPositions[0][shortestPositions[0].length-1] == -1) 
						&& (shortestPositions[0][shortestPositions[0].length-1]+1 < shortestPositions[1][shortestPositions[1].length-1])))
		{
			for(int i = 0; i < shortestPositions[0].length; i++)
			{
				shortestPositions[0][i] = shortestPositions[1][i];
			}
		}
	}
	/**
	 * Finds the startPos and endPos in the snippet
	 * @param shortestPositions
	 */
	public static void minMax (int[][] shortestPositions)
	{
		startPos = shortestPositions[0][0];
		endPos = shortestPositions[0][0];
		if(shortestPositions[0][shortestPositions[0].length-1] != 1)
			{
			for(int i = 0; i < shortestPositions[0].length-2; i++)
			{
				if(shortestPositions[0][i] <= startPos && shortestPositions[0][i] > -1)
				{
					startPos = shortestPositions[0][i];
				}
				else if(shortestPositions[0][i] >= endPos)
				{
					endPos = shortestPositions[0][i];
				}
			}
		}
	}
	
	/**
	 * Returns whether or not all terms were found in the document. If all terms
	 * were not found, then none of the other methods should be called.
	 * 
	 * @return whether all terms were found in the document.
	 */
	public boolean foundAllTerms() {
		for(int i = 0; i < shortestPositions[0].length; i++)
		{
			if(shortestPositions[0][i] == -1 || shortestPositions[0][shortestPositions[0].length-1] != shortestPositions[0].length-2)
			{
				return false;
			}
		}
		return true;
		//throw new UnsupportedOperationException("YOU MUST IMPLEMENT THIS!");

	}

	/**
	 * Return the starting position of the snippet
	 * 
	 * @return the index in the document of the first element of the snippet
	 */
	public int getStartingPos() {
		//Return -1 if no items in snippet
		if(shortestPositions[0][shortestPositions[0].length-1] == 0)
		{
			return -1;
		}
		else if (!this.foundAllTerms())
		{
			throw new UnsupportedOperationException();
		}
		return startPos;
		//throw new UnsupportedOperationException("YOU MUST IMPLEMENT THIS!");

	}

	/**
	 * Return the ending position of the snippet
	 * 
	 * @return the index in the document of the last element of the snippet
	 */
	public int getEndingPos() 
	{
		//Return -1 if no items in snippet
		if(shortestPositions[0][shortestPositions[0].length-1] == 0)
		{
			return -1;
		}
		else if (!this.foundAllTerms())
		{
			throw new UnsupportedOperationException();
		}
		return endPos;
		//throw new UnsupportedOperationException("YOU MUST IMPLEMENT THIS!");

	}

	/**
	 * Return total number of elements contained in the snippet.
	 * 
	 * @return
	 */
	public int getLength() 
	{
		if(!this.foundAllTerms())
		{
			throw new UnsupportedOperationException();
		}
		else if(shortestPositions[0][shortestPositions[0].length-2] < 0)
		{
			return 0;
		}
		else if(shortestPositions[0][shortestPositions[0].length-2] == 0)
		{
			return 1;
		}
		return shortestPositions[0][shortestPositions[0].length-2];
		
		//throw new UnsupportedOperationException("YOU MUST IMPLEMENT THIS!");
	}

	/**
	 * Returns the position of one of the search terms as it appears in the original document
	 * 
	 * @param index index of the term in the original list of terms.  For example, if index
	 * is 0 then the method will return the position (in the document) of the first search term.
	 * If the index is 1, then the method will return the position (in the document) of the
	 * second search term.  Etc.
	 *  
	 * @return position of the term in the document
	 */
	public int getPos(int index) {
		//Return -1 if index is too large
		if(!this.foundAllTerms())
		{
			throw new UnsupportedOperationException();
		}
		else if(index >= shortestPositions[0].length-2 || index < 0)
		{
			throw new UnsupportedOperationException();
		}
		else if(shortestPositions[0][shortestPositions[0].length-1] == 1)
		{
			return shortestPositions[0][index];
		}
		return shortestPositions[0][index];
		//throw new UnsupportedOperationException("YOU MUST IMPLEMENT THIS!");

	}
	
	public String toString()
	{
	 	String str ="";
	 	for(String s: snippet)
	 	{
	 		str += s;
	 	}
	 	return (str);
	}
}
