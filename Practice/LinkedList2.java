//practice the linkedlist with the head and tail

public class LinkedList2 {
	private static class Node{
		int val;
		Node next;
	}
	
	private Node head, tail;
	
	public LinkedList2() {
		head = null;
		tail = null;
	}
	
	public void addStart(int v) {
		if(head == null) {
			head = new Node();
			head.val = v;
			tail = head;
			return;
		}
		Node temp = new Node();
		temp.val = v;
		temp.next = head;
		head = temp;
	}
	
	public void addEnd(int v) {
		if (tail == null) {
			tail = new Node();
			tail.val = v;
			head = tail;
			return;
		}
		Node temp = new Node();
		temp.val = v;
		tail.next = temp;
		temp.next = null;
		tail = tail.next;
	}
	
	public void removeStart() {
		if (head == null) {
			return;
		}
		head = head.next;		
	}
	
	public void removeEnd() {
		if (head == null) {
			return;
		}
		if(head == tail) {
			head = null;
			tail = null;
		}
		Node p;
		for(p = head; p.next.next != null; p = p.next) {
			;
		}
		p.next = null;	
		tail = p;
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
		LinkedList2 a = new LinkedList2();
		for(int i = 0; i < 10; i++){
			a.addEnd(i);
		}
		System.out.println(a.toString());
		LinkedList2 b = new LinkedList2();
		for(int i = 0; i < 10; i++){
			b.addStart(i);
		}
		System.out.println(b.toString());
		
		for (int i = 0; i < 2; i++) {// remove the last two elements
			a.removeEnd();
		}
		System.out.println(a.toString());
		
		b.removeStart();
		System.out.println(b.toString());
	}
	

}
