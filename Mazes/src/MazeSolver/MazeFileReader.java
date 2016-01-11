package MazeSolver;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MazeFileReader {
	private Path filePath;
	private int startIndex;
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
		
		int i = 0;
		
		
		for(Iterator<String> j = lines.iterator(); j.hasNext();){
			String current = j.next();
			
			
			// Skipping empty strings
			// if(!current.isEmpty()) continue;
			
			String[] splitted = current.split("\\s");

			String first = splitted[0];
			String second = splitted[1];
			
			int foo = Integer.parseInt(first);
			int goo = Integer.parseInt(second);
			
			if(foo == 1)
			{
				this.startIndex = i;
			}
			
			verticesCount = Math.max(verticesCount, Math.max(foo,goo));
						
			i++;			
			IntTuple relation = new IntTuple(foo,goo);
			result.add(relation);
		}
		
		verticesCount++;
		
		return result;
	}
	
	public int getVerticesCount(){
		return this.verticesCount;
	}
	
	public int getStartIndex(){
		return this.startIndex;
	}
}
