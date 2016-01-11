package MazeSolver;

/**
 * @author Miroslav Lukac
 *
 */
public class IntTuple {
	public final int first;
	
	public final int second;
	
	public IntTuple(int first, int second){
		this.first = first;
		this.second = second;
	}
	
	public String toString(){
		return this.first + " " + this.second;
	}
}
