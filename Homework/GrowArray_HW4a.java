import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class GrowArray { // C++: Vector<int>    Java: ArrayList
	private int[] data; //data.length is our capacity
	private	int used;
	public GrowArray() {
		data = new int[100];
		used = 0;

	}

	//preallocate storage for more speed (how much? 100%)
	public	GrowArray(int initialCapacity) {
		data = new int[initialCapacity];
		used = 0;
	
	}

	public void addEnd(int v) { //O (1)
		data[used] = v;		
		used++;

	}

	public void addStart(int v) { //O (n)
		for(int j = used; j > 0; j--) {
			data[j] = data[j-1];
		}
		data[0] = v;
		used++;
	}

	public void removeEnd() { //O (1)
		used--;
	}
	
	public void removeStart() { //O (n)
		for (int j = 0; j < used; j++) {
			data[j] = data [j+1];
			
		}
		used--;
	}
	

	
	public void manipulate(String s){
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
			
			if(used+(r-p)/q>data.length){
				int[]arr_2=new int [data.length*2];
				data=arr_2;
			}
			
			for(int i =0;p+q*i<=r;i++){
				
				addStart(p+q*i);
				
			}
		}
		
		if(ss[0].equals("ADD_BACK")){
			String [] sss= ss[1].split(":");
			int p = Integer.parseInt(sss[0]);
			int q = Integer.parseInt(sss[1]);
			int r = Integer.parseInt(sss[2]);
			
			if(p+q>r){
				System.out.println("Invalid Input.");
			}
			
			if(used+(r-p)/q>data.length){
				int[]arr_2=new int [data.length*2];
				data=arr_2;
			}
			
			for(int i =0;p+q*i<=r;i++){
				
				addEnd(p+q*i);

			}
			
		}
		
		if(ss[0].equals("REMOVE_FRONT")){
			
			int p = Integer.parseInt(ss[1]);
			
			
			for(int i = 0;i<p;i++){
				
				removeStart();
				
			}
			
		}
		
		if(ss[0].equals("REMOVE_BACK")){
			
			int p = Integer.parseInt(ss[1]);
			
			for(int i = 0;i<p;i++){
				
				removeEnd();
				
				
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
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < used; i++) {
				sb.append(data[i]).append(",");
			}
			String res = sb.toString();
			System.out.println(res.substring(0,res.length()-1));
		}

		
 	}
	
	public static void main(String[]args){
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; 
		
		try {
			
//			fis = new FileInputStream("F:\\2017 fall third semester\\CPE 593\\week5\\HW4a.txt");
			fis = new FileInputStream("HW4a.txt");
		    isr = new InputStreamReader(fis);
		    br = new BufferedReader(isr);
		    
		    GrowArray arr = new GrowArray(100);
		    
		    String str = "";
		    while ((str = br.readLine()) != null) {
		    	arr.manipulate(str);
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
