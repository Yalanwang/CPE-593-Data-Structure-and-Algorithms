// Practice LinkedList

public class LinkedList {
	
	private static class Node{//LinkedList.Node
		int val;
		Node next;// pointer to next one
	}
	
	private Node head;
	
	public LinkedList() { // empty LinkedList O(1)
		 head = null;		
	}
	
	public void addStart(int v) { // O(1)
			Node temp = new Node();
			temp.val = v;
			temp.next = head;
			head = temp;
		
	}
	
	public void addEnd(int v) {
		if (head == null) {
			head = new Node();
			head.val = v;
			head.next = null;
			return;
		}
		Node p;
		for (p = head; p.next != null; p = p.next) { // O(n)
			;// find the end of the list
		}
		Node temp = new Node();
		temp.val = v;
		temp.next = null;
		p.next = temp;		
	}
	
	public void insert(int i, int v) { // O(n)
		Node p = head;
		while(i>0) {
			if(p==null) {
				return;
			}
			p = p.next;
			i--;
		}
		Node temp = new Node();
		temp.val = v;
		temp.next = p.next;
		p.next = temp;		
	}
	
	public void removeStart() { // O(1)
		if (head == null) {
			return;
		}
		head = head.next;
		
	}
	
	public void removeEnd() {// O(n)
		if (head == null) {
			return;
		}
		if (head.next == null) {
			head = null;
			return;
		}
		Node p;
		for(p = head; p.next.next != null; p = p.next) {
			;
		}
		p.next = null;		
	}
	
	public int size() { // O(n)
		int count = 0;
		for (Node p = head; p != null; p = p.next) {
			count ++;
		}
		return count;
	}
	
	public int get(int i) { // O(n)
		
		Node p = head;
		for ( ; i > 0; i--, p = p.next) {
			if(p == null) {
				throw new IndexOutOfBoundsException("LinkedList index" + i);
			}			
		}
		return p.val;
	}
	
	
	
	public String toString() { // 
		// "[1,2,3,4]"
		
		StringBuilder b = new StringBuilder();
		b.append('[');
//		final int SIZE = size();
		for(Node p = head; p != null; p = p.next) { // good one O(n)
			b.append(p.val).append(","); //O(n)
		}
//		for (int i = 0; i < SIZE; i++) { // bad one O(n^2)
//			b.append(get(i)).append(",");
//		}
		b.append(']');
		return b.toString();
	}
	
	public static void main(String[] args){
		LinkedList a = new LinkedList();
		for(int i = 0; i < 10; i++){
			a.addEnd(i);
		}
		System.out.print(a);
		for(int i = 0; i < 10; i++){
			a.addStart(i);
		}
		System.out.print(a);
	}
	
	

}
