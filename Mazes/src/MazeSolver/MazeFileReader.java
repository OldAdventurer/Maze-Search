package MazeSolver;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DataStructures.IntTuple;

public class MazeFileReader {
	private Path filePath;
	private int verticesCount;
	
	public MazeFileReader(String fileName) throws IOException {
		if(fileName.isEmpty())
		{
			throw new IOException("Enter file name!");
		}
		
		this.filePath = Paths.get(fileName);
	}
	
	public List<IntTuple> readMaze() throws IOException {
		Charset charset = Charset.defaultCharset();
		List<String> lines = Files.readAllLines(this.filePath, charset);
		
		// Count 
		List<IntTuple> result = new ArrayList<IntTuple>();
				
		for(Iterator<String> j = lines.iterator(); j.hasNext();){
			String current = j.next();
			
			// Skipping empty strings
			// if(!current.isEmpty()) continue;
			
			String[] splitted = current.split("\\s");

			String first = splitted[0];
			String second = splitted[1];
			
			int foo = Integer.parseInt(first);
			int goo = Integer.parseInt(second);
			
			verticesCount = Math.max(verticesCount, Math.max(foo,goo));			
			IntTuple relation = new IntTuple(foo,goo);
			result.add(relation);
		}
		
		verticesCount++;
		
		return result;
	}
	
	public int getVerticesCount(){
		return this.verticesCount;
	}
}
