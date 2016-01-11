package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Removing items is not supported. Provides ability to collect integers and iterate through them.
 * Using Linked list approach
 * 
 * @author Miroslav Lukac
 *
 */
public class IntegerBag implements Iterable<Integer> {
	private Node firstNode; // first node
	private int count; // count of items in bag
	
	private static class Node {
		private int value;
		private Node next;
	}

	/**
	 * Creates an empty bag.
	 */
	public IntegerBag(){
		this.firstNode = null;
		count = 0;
	}
	
	/**
	 * Add item into bag.
	 * 
	 * @param item
	 */
	public void add(Integer newValue){
		Node oldFirst = firstNode;
		this.firstNode = new Node();
		this.firstNode.value = newValue;
		this.firstNode.next = oldFirst;
		this.count++;
	}
	
    /**
     * Returns true if this bag is empty.
     *
     * @return <tt>true</tt> if this bag is empty;
     *         <tt>false</tt> otherwise
     */
	public boolean isEmpty(){
		return firstNode == null;
	}
	
	public int size(){
		return this.count;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new ListIterator(firstNode);
	}
	
	private class ListIterator implements Iterator<Integer>{
		private Node current;
		
		public ListIterator(Node first){
			this.current = first;
		}
		
		public boolean hasNext(){
			return this.current != null;
		}
		
		public void remove(){ throw new UnsupportedOperationException(); }
		
		public Integer next(){
			if(!hasNext()) throw new NoSuchElementException();
			Integer value = current.value;
			current = current.next;
			return value; 
		}
	}
}
