package graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Implements a graph. We use two maps: one map for adjacency properties 
 * (adjancencyMap) and one map (dataMap) to keep track of the data associated 
 * with a vertex. 
 * 
 * @author cmsc132
 * 
 * @param <E>
 */

public class Graph<E> {
	/* You must use the following maps in your implementation */
	private HashMap<String, HashMap<String, Integer>> adjacencyMap;
	private HashMap<String, E> dataMap;
	
	private boolean lastTimeLowest;
	private int temp;
	
	
	
	/**
	 * Constructor
	 */
	public Graph()
	{
		adjacencyMap = new HashMap<String, HashMap<String, Integer>>();
		dataMap = new HashMap<String, E>();
	}
	
	/**
	 * Adds a vertex to the graph by adding to the adjacency map an entry for the vertex. 
	 * This entry will be an empty map. An entry in the dataMap will store the provided data.
	 * throws IllegalArgumentException if the vertex already exists in the graph.
	 * @param vertexName
	 * @param data
	 */
	public void addVertex(String vertexName, E data)
	{
		if(dataMap.containsKey(vertexName))
		{
			throw new IllegalArgumentException();
		}
		else
		{
			dataMap.put(vertexName, data);
			adjacencyMap.put(vertexName, new HashMap<String, Integer>());
		}
	}
	
	/**
	 * Adds or updates a directed edge with the specified cost.
	 * throws IllegalArgumentException if any of the vertices are not part of the graph. 
	 * @param startVertexName
	 * @param endVertexName
	 * @param cost
	 */
	public void addDirectedEdge(String startVertexName, String endVertexName, int cost)
	{
		if(!dataMap.containsKey(startVertexName) || !adjacencyMap.containsKey(endVertexName))
		{
			throw new IllegalArgumentException();
		}
		else
		{
			getAdjacentVertices(startVertexName).put(endVertexName, cost);
		}
	}
	
	/**
	 * Returns a string with information about the Graph. 
	 * Notice that vertices are printed in sorted order and 
	 * information about adjacent edges is printed in sorted 
	 * order (by vertex name). You may not use Collections.sort 
	 * or Arrays.sort in order to implement this method. See the 
	 * sample output for formatting details. return string with
	 *  graph information
	 */
	@Override
	public String toString()
	{
		// use \n for line breaks
		String str ="";
		
		E[] keys = (E[]) getVertices().toArray();
		E[] adjacentKeys;
		alphabetical(keys);
		
		str += "Vertices: [";
		
		for(int i = 0; i < keys.length; i++)
		{
			str += keys[i];
			if(i != keys.length-1)
			{
				str += ",";
			}
		}
		
		str += "]\n Edges:";
		
		for(int i = 0; i < keys.length; i++)
		{
			str += "\n Vertex("+keys[i]+")--->{";
			
			adjacentKeys = (E[]) getAdjacentVertices((String)keys[i]).keySet().toArray();
			for(int j = 0; j < adjacentKeys.length; j++)
			{
				str += adjacentKeys[j] +"="+ getAdjacentVertices((String)keys[i]).get(adjacentKeys[j]);
				if(j != adjacentKeys.length-1)
				{
					str += ", ";
				}
			}
			str += "}";
		}
		
		
		return str;
	}
	
	/**
	 * Returns a map with information about vertices adjacent 
	 * to vertexName. If the vertex has no adjacents, an empty 
	 * map is returned.
	 * @param vertexName
	 * @return
	 */
	public Map<String,Integer> getAdjacentVertices(String vertexName)
	{
		if(!adjacencyMap.containsKey(vertexName))
		{
			return new HashMap<String,Integer>();
		}
		else
		{
			return adjacencyMap.get(vertexName);
		}
	}
	
	/**
	 * Returns the cost associated with the specified edge.
	 * @param startVertexName
	 * @param endVertexName
	 * @return
	 */
	public int getCost(String startVertexName, String endVertexName)
	{
		if(!getAdjacentVertices(startVertexName).containsKey(endVertexName))
		{
			return 0;
		}
		return getAdjacentVertices(startVertexName).get(endVertexName);
	}

	/**
	 * Returns a Set with all the graph vertices.
	 * @return
	 */
	public Set<String> getVertices()
	{
		return dataMap.keySet();
	}
	
	/**
	 * Returns the data component associated with the specified vertex.
	 * throws IllegalArgumentException if the vertex is not part of the graph
	 * @param vertex
	 * @return
	 */
	public E getData(String vertex)
	{
		if(!dataMap.containsKey(vertex))
		{
			throw new IllegalArgumentException();
		}
		return dataMap.get(vertex);
	}
	
	/**
	 * Computes Depth-First Search of the specified graph.
	 * throws IllegalArgumentException if the vertex is not part of the graph
	 * @param startVertexName
	 * @param callback
	 */
	public void doDepthFirstSearch(String startVertexName, CallBack<E> callback)
	{
		ArrayList<Object> result = new ArrayList<Object>();
		Stack<Object> visited = new Stack<Object>();
		Object currentNode;
		
		if(!dataMap.containsKey(startVertexName))
		{
			throw new IllegalArgumentException();
		}
		
		currentNode = startVertexName;
		visited.push(currentNode);
		result.add(currentNode);
	
		while(!visited.isEmpty())
		{
			dfs_aux(currentNode, visited, result);
			currentNode = visited.pop();
		}
		
		for(Object s: result)
		{
			callback.processVertex((String) s, getData((String) s));
		}
	}
	
	private void dfs_aux(Object currentNode, Stack<Object> visited, ArrayList<Object> result)
	{
		Object[] adjacent;
		
		adjacent = getAdjacentVertices((String) currentNode).keySet().toArray();
		ordered((E[]) adjacent);
		
		for(int i = 0; i < adjacent.length; i++)
		{
			if(!result.contains(adjacent[i]))
			{
				visited.push(adjacent[i]);
				currentNode = adjacent[i];
				result.add(adjacent[i]);
				dfs_aux(currentNode, visited, result);	
			}
		}
	}

	
	/**
	 * Computes Breadth-First Search of the specified graph.
	 * throws IllegalArgumentException if the vertex is not part of the graph
	 * @param startVertexName
	 * @param callback
	 */
	public void doBreadthFirstSearch(String startVertexName, CallBack<E> callback)
    {
		//uses queue
		Queue<String> visited = new LinkedList<String>();
		Queue<String> unvisited = new LinkedList<String>();
		Object [] adjacent;
		
		if(!dataMap.containsKey(startVertexName))
		{
			throw new IllegalArgumentException();
		}
		
		unvisited.add(startVertexName);
		
		while(visited.size() < dataMap.size())
		{
			visited.add(unvisited.peek());
			adjacent = (Object[]) getAdjacentVertices(unvisited.peek()).keySet().toArray();
			alphabetical((E[]) adjacent);
			
			for(int i = 0; i < adjacent.length; i++)
			{
				if(!visited.contains(adjacent[i]) && !unvisited.contains(adjacent[i]))
				{
					unvisited.add((String)adjacent[i]);
				}
			}
			
			unvisited.poll();
		}
		while(!visited.isEmpty())
		{
			if(dataMap.containsKey(visited.peek()))
			{
				callback.processVertex(visited.peek(), dataMap.get(visited.peek()));
			}
			visited.poll();
		}
    }
	
	/**
	 * Computes the shortest path and shortest path cost using 
	 * Dijkstras's algorithm. It initializes shortestPath with the 
	 * names of the vertices corresponding to the shortest path. 
	 * If there is no shortest path, shortestPath will be have 
	 * entry "None".
	 * throws IllegalArgumentException if the vertex is not part of the graph
	 * @param startVertexName
	 * @param endVertexName
	 * @param shortestPath
	 * @return
	 */
	public int doDijkstras(String startVertexName, String endVertexName, ArrayList<String> shortestPath)
	{
		if((!dataMap.containsKey(startVertexName) || !dataMap.containsKey(endVertexName) || getAdjacentVertices(startVertexName).isEmpty() || getAdjacentVertices(endVertexName).isEmpty()))
		{
			shortestPath.add("None");
			return -1;
		}
		else if (startVertexName.equals(endVertexName))
		{
			shortestPath.add(startVertexName);
			return 0;
		}
		ArrayList<String> currentPass = new ArrayList<String>();
		
		Stack<VQEntry> visited = new Stack<VQEntry>();
		
		VQEntry currentNode;
		VQEntry previousNode = new VQEntry();
		
		int lowestCost = -1;
		
		
		currentNode = new VQEntry(startVertexName);
		visited.push(currentNode);
		currentPass.add(currentNode.name);
		
		while(!visited.isEmpty())
		{
			lastTimeLowest = false;
			dijkstra_aux(startVertexName, endVertexName, currentNode, previousNode, visited, shortestPath, currentPass, lowestCost);
			previousNode = visited.peek();
			visited.pop();
			currentPass.clear();
			if(!visited.isEmpty())
			{
				visited.peek().previous.add(previousNode.name);
				currentNode = visited.peek();
				
				for(VQEntry v: visited)
				{
					currentPass.add(v.name);
				}
				temp = 0;
				for(int i = 0; i < currentPass.size() - 2; i++)
				{
					for(int j = i+1; j < currentPass.size()-1; j++)
					{
						temp += getCost(currentPass.get(i), currentPass.get(j));
					}
				}
			}
			
		}
		return lowestCost;
	}
	
	private void dijkstra_aux(Object startNode, Object endNode, VQEntry currentNode, VQEntry previousNode, Stack<VQEntry> visited, ArrayList<String> result, ArrayList<String> currentPass, int lowestCost)
	{
		Object[] adjacent;
		
		adjacent = getAdjacentVertices(currentNode.name).keySet().toArray();
		costOrdered(visited.peek(), (adjacent));
		for(int i = 0; i < adjacent.length; i++)
		{
			if(!(currentPass.contains(adjacent[i])) && !currentNode.previous.contains(adjacent[i]))
			{
				currentNode = new VQEntry((String)adjacent[i]);
				temp += getCost(visited.peek().name, currentNode.name);
				visited.push(currentNode);
				currentPass.add(currentNode.name);
				dijkstra_aux(startNode, endNode, currentNode, previousNode, visited, result, currentPass, lowestCost);	
			}
			else if(i == adjacent.length - 1)
			{
				if(result.isEmpty())
				{
					result.add("None");
					temp = -1;
				}
			}
		}
		if(currentNode.name.equals(endNode))
		{
			
			if((lowestCost > 0 && temp < lowestCost && temp != -1) || lowestCost < 0)
			{
				result.clear();
				lowestCost = new Integer(temp);
				lastTimeLowest = true;
				for(String s: currentPass)
				{
					result.add(s);
				}
				
			}
		}
	}

	
	private E[] alphabetical(E[] adjacentKeys)
	{
		String minimum;
		for(int i = 0; i < adjacentKeys.length - 1; i++)
		{
			minimum = (String) adjacentKeys[i];
			for(int j = i; j < adjacentKeys.length; j++)
			{
				if(((String) adjacentKeys[j]).compareTo(minimum) < 0)
				{
					minimum = (String) adjacentKeys[j];
					adjacentKeys[j] = adjacentKeys[i];
					adjacentKeys[i] = (E) minimum;
				}
			}
		}
		return adjacentKeys;
	}
	
	/**
	 * Ordered by data
	 * @param adjacentKeys
	 * @return
	 */
	private E[] ordered(E[] adjacentKeys)
	{
		E maximum;
		E temp;
		for(int i = 0; i < adjacentKeys.length - 1; i++)
		{
			maximum = getData((String)adjacentKeys[i]);
			for(int j = i; j < adjacentKeys.length; j++)
			{
				if(((Comparable<E>) getData((String) adjacentKeys[j])).compareTo(maximum) > 0)
				{
					maximum = getData((String) adjacentKeys[j]);
					temp = adjacentKeys[j];
					adjacentKeys[j] = adjacentKeys[i];
					adjacentKeys[i] = temp;
				}
			}
		}
		return adjacentKeys;
	}
	/**
	 * Object must be a string
	 * adjacentKeys must be a String[]
	 * @param object
	 * @param adjacentKeys
	 * @return
	 */
	private E[] costOrdered(VQEntry object, Object[] adjacentKeys)
	{
		int minimum;
		Object temp;
		for(int i = 0; i < adjacentKeys.length - 1; i++)
		{
			minimum = getCost(object.name, (String) adjacentKeys[i]);
			for(int j = i; j < adjacentKeys.length; j++)
			{
				if(getCost(object.name, (String) adjacentKeys[j]) < minimum)
				{
					minimum = getCost(object.name, (String) adjacentKeys[j]);
					temp = adjacentKeys[j];
					adjacentKeys[j] = adjacentKeys[i];
					adjacentKeys[i] = temp;
				}
			}
		}
		return (E[]) adjacentKeys;
	}
	
	public static class VQEntry
	{
		String name;
		ArrayList<String> previous;
		
		public VQEntry(String name)
		{
			this.name = name;
			previous = new ArrayList<String>();
		}
		
		public VQEntry()
		{
			name = null;
			previous = new ArrayList<String>();
		}
	
	}

}