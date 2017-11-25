import java.util.Random;

// linear program
public class Hashmap {
	private int[] table;
	private int used;
	private int limit;
	private int[] hist;  
	private void grow() {
		 int[] temp = table;
		 int[] table = new int[limit*2];
		 for (int i=0;i<temp.length;i++) {
			 table[i] = temp[i];
			 
		 }	
	}
	public Hashmap(int initialSize) { //build constructor
		
		int i;
		
		for (i=1; i<= initialSize; i*=2) {
			;
		}
		table = new int[initialSize];	
		used = 0;
		limit = i / 2; // 
		hist = new int[50];
	}
	
	public Hashmap() {
		this(16);// initialSize = 16
	}
	
	public static int hash(int v) {
//      hash function
//		http://burtleburtle.net/bob/hash/integer.html 
//		return v % table.length;  //not a good hash function
		 v ^= (v >>> 20) ^ (v >>> 12);
		 return v ^ (v >>> 7) ^ (v >>> 4);
		
	}
	public void add(int v) {//put the value into hash table
		
		used++;
		if(used > limit) {
			grow();
		}
		int i = hash(v);
		int count = 0;
		while (table[i] != 0) {
			i = (i+1) % table.length;
//			count ++;
			if (count >= 50) {
				count = 49;
			}
			hist[count++]++;
		}
		
		table[i] = v;
		return;
		}
	
	public void remove(int v) {
		
		int i = hash(v);
		int count = 0;
		while(table[i] != v) {
			i = (i+1) % table.length;
			if (count >= 50) {
				count = 49;
			}
			hist[count++]++;
		}
		table[i] = 0;
		return;
	}
	
	public boolean contains (int v) {//test the value in the hashmap
		int i = hash(v);
		while(table[i] != 0) {
			if (table[i] == v) {
				return true;
			}
			i = (i + 1) % table.length;
		}
		return false;
	}
	
	public static void main(String[] args){
		Hashmap a = new Hashmap();
//		for(int i = 0; i < 10; i++){
//			a.add(i);
//		}
		
		Random r = new Random();
		for(int i = 0;i<10;i++) {
			int b = r.nextInt(10);
//			System.out.println(b);
			a.add(b);
		}
		

//		int min  = 1;
//		int max = 10;
//		System.out.println("The random number: ");
//		for (int i = 0; i < 10; i++) {//check random number
//			int b = (int)(Math.random() * (max-min+1));
//			System.out.print(b + " ");
//			a.add(b);
//		}
//		System.out.println();
		
//		a.add(3);
//		a.add(3);
//		System.out.println(a.contains(3));
//		a.remove(3);
//		a.add(5);
//		a.remove(5);
//		System.out.println(a.contains(7));

		
		System.out.println("The hashmap:");
		for(int i = 0; i < a.table.length; i++){
			System.out.print(a.table[i] + " ");
		}
		System.out.println();
		
		System.out.println("Check the hash map contain 3: " + a.contains(3));
		System.out.println("Check the hash map contain 7: " + a.contains(7));
		
//		System.out.println("The count times: ");
//		
//		for(int i = 0; i < a.table.length; i++){
//			System.out.print(i + " ");
//			
//		}
		
		System.out.println();
		System.out.println("The histogram: ");
		for(int i = 0; i < 50; i++){

			System.out.printf("%d %d\n",i,a.hist[i]);
//			System.out.print(a.hist[i] + " ");
		}
		
		
	}

	
}
	

