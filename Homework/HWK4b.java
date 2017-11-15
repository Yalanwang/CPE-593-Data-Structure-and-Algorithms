import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;




//doubleLinkedList with head and tail


public class HWK4b {
	
	class Node{
		int val;
		Node next;
		Node prev;
		public Node(int _val) {
			val = _val;
			next = null;
			prev = null;
		}
	}
	
	
	private Node head, tail;


	
//	public void HWK4b() { // initialize
//		head = null;
//		tail = null;
//	}
	
	public void addEnd(int v) {
		if (tail == null) {
			tail =  new Node(v);
			tail.val = v;
			tail.prev = null;
			tail.next = null;
			head = tail;
			return;
		}
		Node temp = new Node(v);
		temp.val = v;
		temp.next = null;
		temp.prev = tail;
		tail.next = temp;
		tail = temp;
				
	}
	
	public void addStart(int v) {
		if(head == null) {
			head =  new Node(v);
			head.val = v;
			head.next = null;
			head.prev = null;
			tail = head;
			return;
		}
		Node temp = new Node(v);
		temp.val = v;
		temp.next = head;
		temp.prev = null;
		head = temp;		
	}
	
	public void removeStart() {
		if (head == null ) {
			return;
		}else {
			head = head.next;
			
		}
		
		
	}
	
//	public void removeEnd() {
//		if(tail == null) {
//			return;
//		}
//		if (head.next == null) {
//			head = tail = null;
//		}else {
//			Node p = tail.prev;
//			p.next = null;
//			tail = p;			
//		}
//		
//		
//	}
	
	public void removeEnd() {
		if(head == null) {
			return;
		}
		if (head == tail) {
			head = null;
			tail = null;
		}
		Node p;
//		for (p = head; p.next.next != null; p =p.next) {
//			;
//		}
//		p.next = null;
//		p.pre = tail;
//		tail = p;
		p = tail.prev;
		p.next = null;
		tail = p;
		
	}
	
	public int get(int i) {
		Node p = head;
		for ( ;  i>0; i--, p = p.next) {
			if (p == tail) {
				throw new IndexOutOfBoundsException("Linkedlist + index" +i);
			}
		}
		return p.val;
		
	}
	
	public int size() {
		int count = 0;
		for (Node p = head; p!=tail; p = p.next) {
			count ++;
		}
		return count;
		
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
	
	
	public static void manipulate(String s, HWK4b data){
		
		
		//System.out.println(s);
		String s_nor = s.replaceAll("\\s{1,}", " ");
		String [] ss = s_nor.split(" ");
		
		if(ss[0].equals("ADD_FRONT")){
			
//			System.out.println("ADD_FRONT "+ ss[1]);
			String [] sss= ss[1].split(":");
//			System.out.println(sss[0]+" "+sss[1]+" "+sss[2]);
			
			int p = Integer.parseInt(sss[0]);
			int q = Integer.parseInt(sss[1]);
			int r = Integer.parseInt(sss[2]);
			
			if(p+q>r){
				System.out.println("Invalid Input.");
			}
			for(int i =0;p+q*i<=r;i++){
				
				data.addStart(p+q*i);
				
			}
		}
		
		if(ss[0].equals("ADD_BACK")){
			
//			System.out.println("ADD_BACK "+ ss[1]);
			String [] sss= ss[1].split(":");
			int p = Integer.parseInt(sss[0]);
			int q = Integer.parseInt(sss[1]);
			int r = Integer.parseInt(sss[2]);
			
			if(p+q>r){
				System.out.println("Invalid Input.");
			}
			
			for(int i = 0;p+q*i<=r;i++){
//				System.out.println(i);
				data.addEnd(p+q*i);
			
			}
			
		}
		
		if(ss[0].equals("REMOVE_FRONT")){
			
			int p = Integer.parseInt(ss[1]);
			
			
			for(int i = 0;i<p;i++){
				
				data.removeStart();
				
			}
			
		}
		
		if(ss[0].equals("REMOVE_BACK")){
			
			int p = Integer.parseInt(ss[1]);
			
			for(int i = 0;i<p;i++){
				
				data.removeEnd();
				
				
			}
			
		}
//		
//		if(ss[0].equals("OUTPUT")){
//	        for (int i = 0; i < used-1; i++) {  
//	            System.out.print(data[i]+",");  
//	        }
//	        System.out.print(data[used-1]); 
//	        System.out.println();
//			
//		}
		
		if (ss[0].equals("OUTPUT")) {
			System.out.println(data.toString());
		}

		
 	}
	
	public static void main(String[]args){
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; 

		
		try {
			
			fis = new FileInputStream("F:\\2017 fall third semester\\CPE 593\\week5\\HW4a.txt");
//			fis = new FileInputStream("HW4b.txt");
		    isr = new InputStreamReader(fis);
		    br = new BufferedReader(isr);
		    
		    
		    HWK4b data = new HWK4b();
		    
		    String str = "";
		    while ((str = br.readLine()) != null) {
		    	HWK4b.manipulate(str, data);
		    }
		    
		} catch (FileNotFoundException e) {	
			System.out.println("No such file.");
		
		} catch (IOException e) {
			System.out.println("Error when reading file.");
			
		} finally {
			try {
				br.close();
		        isr.close();
		        fis.close();
		        
			} catch (IOException e) {
				e.printStackTrace();
				
			}
			
		}	
	}

	

}
