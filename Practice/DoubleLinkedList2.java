

// practice doubleLinkedList with head and tail
public class DoubleLinkedList2 {
	
	public class Node {
		int val;
		Node next;
		Node pre;
	}
	
	private Node head, tail;
	
	public DoubleLinkedList2() {
		
		head = null;
		tail = null;
	}
	
	public void addStart(int v) {
		if (head == null) {
			head  =  new Node();
			head.val = v;
			tail = head;
			return;				
		}
		Node temp = new Node();
		temp.val = v;
		temp.next = head;
		head.pre = temp;
		head = temp;		
	}

	
	public void addEnd(int v) {
		if (tail == null) {
			tail =  new Node();
			tail.val = v;
			tail.pre = null;
			tail.next = null;
			head = tail;
			return;
		}
		Node temp = new Node();
		temp.val = v;
		temp.next = null;
		temp.pre = tail;
		tail.next = temp;
		tail = temp;
				
	}
	
	public void removeStart() {
		if (head == null) {
			return;
		}
		head = head.next;		
	}
	
	public void removeEnd() {
		if(head == null) {
			return;
		}
		if (head == tail) {
			head = null;
			tail = null;
		}
		Node p;
		for (p = head; p.next.next != null; p =p.next) {
			;
		}
		p.next = null;
		p.pre = tail;
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
		DoubleLinkedList2 b = new DoubleLinkedList2();
		for(int i = 0; i < 10; i++){
			b.addEnd(i);
		}
		System.out.println(b.toString());
		
		DoubleLinkedList2 a = new DoubleLinkedList2();
		for(int i = 0; i < 10; i++){
			a.addStart(i);
		}
		System.out.println(a.toString());
		
		b.removeStart();
		System.out.println(b.toString());
		
		a.removeEnd();
		System.out.println(a.toString());
	}
	
}
