package graph;

import java.util.List;

public interface IUndirectedGraphNode<T> {
	T getValue();
	List<IUndirectedGraphNode<T>> getNeighbors();
}
