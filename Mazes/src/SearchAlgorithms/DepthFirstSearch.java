package SearchAlgorithms;

import MazeSolver.Graph;
import MazeSolver.IntegerBag;

import java.util.Stack;

public class DepthFirstSearch {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path
	private final int start = 0; // source vertex
	private final int end = 1;
	
	public DepthFirstSearch(Graph graph){
		edgeTo = new int[graph.Vertices()];
		marked = new boolean[graph.Vertices()];
		depthFirstSearch(graph, start);
	}
	
	private void depthFirstSearch(Graph graph, int v){
		marked[v] = true;
		
		for(int w : graph.neighbors(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				depthFirstSearch(graph, w);
			}
		}
	}
	
	public boolean pathExists(int v){
		return marked[v];
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
