package graphs;

/**
 * Represents the processing we apply to a vertex of a graph.
 */
public interface CallBack<E> {
	public void processVertex(String vertex, E vertexData);
}
