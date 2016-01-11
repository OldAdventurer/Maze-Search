package MazeSolver;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import DataStructures.Graph;
import DataStructures.IntTuple;
import SearchAlgorithms.BacktrackingDepthFirstSearch;
import SearchAlgorithms.DepthFirstSearch;

public class MazeSolver {
	private static int verticesCount;
    	
	public static void main(String[] args){
		final String dir = System.getProperty("user.dir");
		
		while(true){
			try{
				System.out.println("---Maze Solver---");
				System.out.print("Insert file name (eg. maze1.txt): ");
				
				Scanner sc = new Scanner(System.in);
				String fileName = sc.next();
				fileName = dir + "\\bin\\Mazes\\" + fileName;
				
				System.out.print("Generate all solutions? (Y/N): ");
				String all = sc.next();
				
				boolean generateAllSolutions = false;
				
				if(all.equals("y"))
				{
					generateAllSolutions = true;
				}
				
				List<IntTuple> maze = LoadMazeFile(fileName);
		
				Graph graph = InitializeGraph(maze);
		
				if(!generateAllSolutions) RunDfs(graph);
				else RunBacktrackingDfs(graph);
			} catch(Exception e){
				System.out.println("Please start again");	
			}
			
			System.out.println("END\n");			
		}
	}	
	
	private static void RunDfs(Graph graph){
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		
		System.out.print("Solution: 0");
				
		for(int x : dfs.solveMaze()){
			System.out.print("->" + x);
		}
	}
	
	private static void RunBacktrackingDfs(Graph graph){
		System.out.println("Solution: ");
		
		BacktrackingDepthFirstSearch dfs = new BacktrackingDepthFirstSearch(graph);
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
			verticesCount = reader.getVerticesCount();
		} catch(IOException e){
			System.out.println(e);
			
		}
		
		return maze;
	}
}
