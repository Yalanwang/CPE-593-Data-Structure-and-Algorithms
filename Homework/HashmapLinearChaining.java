import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class HashmapLinearChaining {
	
	private LinkedList<String>[] table;
	private int used;
	private int limit;
	private int[] hist;
	
	private void grow() {
		int len=table.length*2;
		int i;
		for(i=1;i<=len;i*=2) {
			;
		}
		LinkedList<String> table2[]=new LinkedList[i];
		for(int j = 0 ;j < table.length;j++){
			table2[j]=table[j];
		}
		this.limit = table2.length/ 2;
		table=table2;
	}
	 
	public HashmapLinearChaining(int initialSize) {
		
		int i;
		for(i = 1; i<=initialSize;i*=2) {
			;
		}
		table = new LinkedList[i];
		used = 0;
		limit = i /2;
		hist = new int[50];
	}
	
	public HashmapLinearChaining() {
		this(500);// initialSize = 16
	}
	
	public  int hash(int v) {
//      hash function
//		http://burtleburtle.net/bob/hash/integer.html 
//	    return v % table.length;  //not a good hash function
		 v ^= (v >>> 20) ^ (v >>> 12);
//		 System.out.println(v);
		 return v ^ (v >>> 7) ^ (v >>> 4);
		
	}
	
	public void add (String str){
		int s = 0;
    	for (int i = 0;i <str.length();i++){ 
	    	s+=(int)str.charAt(i);
    	}
		
		used++;
		if(used>limit)
			grow();
		int i = hash(s); 
		if(table[i]==null){
			table[i]=new LinkedList();
		}
		
		int count=table[i].size();
		if(count>10){
			count=9;
		}
		hist[count]++;
		table[i].add(str);
		return;
		
	}

	public boolean contains(String str){
		
		int s = 0;
    	for (int i = 0;i <str.length();i++){
	    	s+=(int)str.charAt(i);
    	}
		
		int i = hash(s);
		if(table[i] != null && table[i].contains(str)){
			return true;
		}else{
			return false;
		}
		
	}
	
	public int[] getHist(){
		return hist;
	}
	
public static void main(String[]args){
		
		
		int wordNumber = 0;
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; 
		
		try {
		    
		    String str = "";
		    
		    // check the total number of words in dictionary
//			fis = new FileInputStream("F:\\2017 fall third semester\\CPE 593\\week6\\dict.txt");
			fis = new FileInputStream("dict.txt");
		    isr = new InputStreamReader(fis);
		    br = new BufferedReader(isr);
		    while ((str = br.readLine()) != null) {
		    	wordNumber++;
		    }
		    System.out.println("The number of words in dictionary is: "+wordNumber);
		    System.out.println();
		    
    		// create a new Hashmap and display the histogram
//			fis = new FileInputStream("F:\\2017 fall third semester\\CPE 593\\week6\\dict.txt");
		    fis = new FileInputStream("dict.txt");
		    isr = new InputStreamReader(fis);
		    br = new BufferedReader(isr);
		    HashmapLinearChaining hm = new HashmapLinearChaining(wordNumber);
		    int c = 0;
		    while ((str = br.readLine()) != null) {
		    	// add dictionary to Hashmap
		    	hm.add(str); 
		    	c++;
//		    	System.out.println(c);
		    }

		    
		    // check whether the words in HW8.dat are in dictionary
//			fis = new FileInputStream("F:\\2017 fall third semester\\CPE 593\\week6\\HW8.dat");
			fis = new FileInputStream("HW8.dat");
		    isr = new InputStreamReader(fis);
		    br = new BufferedReader(isr);
		    while ((str = br.readLine()) != null) {
		    	System.out.println(str+"  "+hm.contains(str)); 
		    }
		    System.out.println();
		    
		    
		    // show the histogram
		    System.out.println("insert count");
		    for(int i = 0;i <11;i++){
		    	System.out.println(i+"      "+hm.getHist()[i]);
		    }
		    
		    
		    
		} catch (FileNotFoundException e) {	
			System.out.println("No such file.");
		
		} catch (IOException e) {
			System.out.print("Error when reading file.");
			
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


