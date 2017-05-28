/**
 * 
 */
package urllistcompare.util;

import java.util.ArrayList;

/**
 * @author Rocco Barbini
 * @email roccobarbi@gmail.com
 * 
 * A generic LinkedList that can be used to implement both the lists of URLElement contained within the
 * URLNorm instances and the lists of URLNorm that make up the URLMap hashmap.
 *
 */
public class LinkedList<T>{
	private ListNode head;
	private int length;

	public LinkedList() {
		this.head = null;
		this.length = 0;
	}
	
	public LinkedList(T payload) {
		this.head = new ListNode(payload, null);
		this.length = 1;
	}
	
	/**
	 * Adds a new node to the head of the list.
	 * @param payload
	 */
	public void add(T payload){
		ListNode newNode = new ListNode(payload, head);
		head = newNode;
		length++;
	}
	
	// Returns the ListNode that includes the payload passed as argument, or null.
	private ListNode find(T payload){
		ListNode current = head;
		while(current != null && !current.payload.equals(payload)){
			current = current.next;
		}
		return current;
	}
	
	/**
	 * Checks if a specific payload is in the list
	 * @param payload the element that is being searched for
	 * @return true if found, false if not found
	 */
	public boolean isInList(T payload){
		boolean output = false;
		if(find(payload) != null){
			output = true;
		}
		return output;
	}
	
	/**
	 * Outputs the contents of the list as an ArrayList
	 * @return an ArrayList of the payloads of the list nodes, or null if the list is empty
	 */
	public ArrayList<T> toArrayList(){
		if(head == null) return null; // Faster and safer
		ArrayList<T> output = new ArrayList<T>(length);
		ListNode current = head;
		while(current != null){
			output.add(current.payload);
			current = current.next;
		}
		output.trimToSize();
		return output;
	}
	
	// TODO: complete the functionality
	
	// Inner class that represents the list nodes
	private class ListNode{
		T payload;
		ListNode next;
		
		private ListNode(){
			this.payload = null;
			this.next = null;
		}
		
		private ListNode(T payload, ListNode next){
			this.payload = payload;
			this.next = next;
		}
	}

}
