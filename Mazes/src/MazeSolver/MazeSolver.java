package MazeSolver;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import MazeSolver.IntTuple;
import SearchAlgorithms.BacktrackingDepthFirstSearch;
import SearchAlgorithms.DepthFirstSearch;

public class MazeSolver {
	private static int verticesCount;
	private static int startIndex;
		
	public static void main(String[] args){
		final String dir = System.getProperty("user.dir");
		
		System.out.println("---Maze Solver---");
		System.out.print("Insert file name: ");
		
		Scanner sc = new Scanner(System.in);
		//String fileName = sc.next();
		String fileName = dir + "\\bin\\Mazes\\maze1.txt";
		
		System.out.print("Generate all solutions? (Y/N): ");
		String all = sc.next();
		
		boolean generateAllSolutions = false;
		
		if(all.equals("y"))
		{
			generateAllSolutions = true;
		}
		
		List<IntTuple> maze = LoadMazeFile(fileName);
		
		if(maze == null || verticesCount <= 0 || startIndex < 0) {
			System.out.println("Invalid maze file!");
			return;
		}
		
		Graph graph = InitializeGraph(maze);

		if(!generateAllSolutions) RunDfs(graph);
		else RunBacktrackingDfs(graph);
	}	
	
	private static void RunDfs(Graph graph){
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		
		System.out.print("Solution: 0");
				
		for(int x : dfs.solveMaze()){
			System.out.print("->" + x);
		}
	}
	
	private static void RunBacktrackingDfs(Graph graph){
		System.out.println("all simple paths between 0 and 1:");
		
		BacktrackingDepthFirstSearch dfs = new BacktrackingDepthFirstSearch(graph, 0, 1);
		System.out.println("# paths = " + dfs.numberOfPaths());
	}
	
	private static Graph InitializeGraph(List<IntTuple> maze){
		Graph graph = new Graph(verticesCount);
		
		for(int i =0; i< maze.size(); i++){
			IntTuple current = maze.get(i);
			graph.addEdge(current.first,  current.second);
		}
		
		return graph;		
	}
	
	private static List<IntTuple> LoadMazeFile(String path){
		List<IntTuple> maze = null;
		
		try{			
			MazeFileReader reader = new MazeFileReader(path);
			maze = reader.readMaze();
			 
			startIndex = reader.getStartIndex();
			verticesCount = reader.getVerticesCount();
		} catch(IOException e){
			System.out.println("Error occured! - error message: ");
			e.printStackTrace();
		}
		
		return maze;
	}
}
