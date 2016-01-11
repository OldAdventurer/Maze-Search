package SearchAlgorithms;

import java.util.Stack;
import MazeSolver.Graph;

public class BacktrackingDepthFirstSearch {
	    private boolean[] onPath;        // vertices in current path
	    private Stack<Integer> path;     // the current path
	    private int numberOfPaths;       // number of simple path

	    // show all simple paths from s to t - use DFS
	    public BacktrackingDepthFirstSearch(Graph G, int s, int t) {
	        onPath = new boolean[G.Vertices()];
	        path   = new Stack<Integer>();
	        dfs(G, s, t);
	    }

	    // use DFS
	    private void dfs(Graph G, int v, int t) {

	        // add v to current path
	        path.push(v);
	        onPath[v] = true;

	        // found path from s to t
	        if (v == t) {
	            processCurrentPath();
	            numberOfPaths++;
	        }

	        // consider all neighbors that would continue path with repeating a node
	        else {
	            for (int w : G.neighbors(v)) {
	                if (!onPath[w])
	                    dfs(G, w, t);
	            }
	        }

	        // done exploring from v, so remove from path
	        path.pop();
	        onPath[v] = false;
	    }

	    // this implementation just prints the path to standard output
	    private void processCurrentPath() {
	        Stack<Integer> reverse = new Stack<Integer>();
	        for (int v : path)
	            reverse.push(v);
	        if (reverse.size() >= 1)
	            System.out.print(reverse.pop());
	        while (!reverse.isEmpty())
	        	System.out.print("-" + reverse.pop());
	        System.out.println();
	    }

	    // return number of simple paths between s and t
	    public int numberOfPaths() {
	        return numberOfPaths;
	    }
}
