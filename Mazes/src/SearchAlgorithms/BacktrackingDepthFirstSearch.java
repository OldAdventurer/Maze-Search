package SearchAlgorithms;

import java.util.Stack;
import DataStructures.Graph;

public class BacktrackingDepthFirstSearch {
	    private boolean[] verticesOnPath;        // vertices in current path
	    private Stack<Integer> currentPath;     // the current path
	    private final int start = 0;
	    private final int end = 1;

	    public BacktrackingDepthFirstSearch(Graph graph) {
	        verticesOnPath = new boolean[graph.Vertices()];
	    	currentPath   = new Stack<Integer>();
	        dfs(graph, start, end);
	    }

	    private void dfs(Graph graph, int from, int to) {
	    	currentPath.push(from);
	        verticesOnPath[from] = true;

	        // found path from start to end
	        if (from == to) {
	            printCurrentPath();
	        }
	        else {
	            for (int neighbor : graph.neighbors(from)) {
	                if (!verticesOnPath[neighbor])
	                    dfs(graph, neighbor, to);
	            }
	        }

	        currentPath.pop();
	        verticesOnPath[from] = false;
	    }

	    private void printCurrentPath() {
	        String output = "";
	        
	        for (int x : currentPath){
	        	if(x == end) output += x; 
	        	else output += x + "->";
	        }
	        
	        System.out.println(output);
	    }
}