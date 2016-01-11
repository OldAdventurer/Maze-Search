package MazeSolver;

public class Graph {
	private final int Vertices;
	private int Edges;
	private IntegerBag[] neighbors; // Array of integer bags
	
	/**
	 * Initialize graph with <tt>verticesCount</tt> vertices and 0 edges.
	 * 
	 * @param verticesCount number of vertices
	 * @throws IllegalArgumentException if <tt>verticesCount</tt> <= 0
	 */
	public Graph(int verticesCount){
		if(verticesCount <= 0)
			throw new IllegalArgumentException("Number of vertices have to be more than 0");
		
		Vertices = verticesCount;
		Edges = 0;
		neighbors = new IntegerBag[Vertices];
		
		// Initialize neighbors array of integer bags.
		for( int i = 0; i < Vertices; i++){
			neighbors[i] = new IntegerBag();
		}
	}
	
	/**
	 * Returns the number of vertices in the graph.
	 * 
	 * @return
	 */
	public int Vertices(){
		return Vertices;
	}

	/**
	 * Returns the number of edges in the graph.
	 * 
	 * @return number of edges.
	 */
	public int Edges(){
		return Edges;
	}
	
	public void addEdge(int v, int w){
		Edges++;
		neighbors[v].add(w);
		neighbors[w].add(v);
	}
	
	public Iterable<Integer> neighbors(int vertice){
		return neighbors[vertice];
	}
	
	public int degree(int vertice){
		return neighbors[vertice].size();
	}
}
