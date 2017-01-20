package graphs;

/**
 * Implements a processor that appends the name of a vertex
 * to a result string.  It is used to generate the string
 * associated with a BFS or DFS traversal. We append the 
 * data of the vertex to the vertex's name.
 */

public class PrintCallBack<E> implements CallBack<E> {
	private String result = "";
	
	public void processVertex(String vertex, E vertexData) {
		result += "Vertex: " + vertex + ", Vertex Data: " + vertexData + "\n";
	}
	
	public String getResult() {
		return result;
	}
	
	public void clear() {
		result = "";
	}
}