package SearchAlgorithms;

import DataStructures.Graph;
import DataStructures.IntegerBag;

public class DepthFirstSearch {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path
	private final int start = 0;
	private final int end = 1;
	
	public DepthFirstSearch(Graph graph){
		edgeTo = new int[graph.Vertices()];
		marked = new boolean[graph.Vertices()];
		depthFirstSearch(graph, start);
	}
	
	private void depthFirstSearch(Graph graph, int from){
		marked[from] = true;
		
		for(int neighbor : graph.neighbors(from)){
			if(!marked[neighbor]){
				edgeTo[neighbor] = from;
				depthFirstSearch(graph, neighbor);
			}
		}
	}
	
	public boolean pathExists(int from){
		return marked[from];
	}
	
	public Iterable<Integer> solveMaze(){
		if(!pathExists(end)) return null;
		
		IntegerBag path = new IntegerBag();

		for(int x = end; x != start; x = edgeTo[x]){
			path.add(x);
		}
		
		return path;
	}
}
