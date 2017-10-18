// have bugs


public class HeapSort {
	public static void MakeHeap(int[] x) {
		int n = x.length-1;
		for(int i = n/2; i>=0; i--) {
//			System.out.print(i);
			makeSubheap(x,i);
		}
	}
	
	public static void makeSubheap(int[] x, int i) {
		if (2*i+2 > x.length-1) 
			return;
		if (x[2*i+1] > x[2*i+2]) {
			if (x[i] < x[2*i+1]) {
				int temp = x[2*i+1];
				x[2*i+1] = x[i];
				x[i] = temp;
				makeSubheap(x, 2*i+1);
			} 
			if(x[i] < x[2*i+2]) {
				int temp1 = x[2*i+2];
				x[2*i+2] = x[i];
				x[i] = temp1;
				makeSubheap(x, 2*i+2);				
			}
		}
	
	}
	
	public static void heapsort(int[] x) {
		MakeHeap(x);
		for( int i = x.length-1; i>=0; i--) {
			int temp2 = x[0];
			x[0] = x[i];
			x[i] = temp2;
			makeSubheap(x,0);
		}
	}
	
	public static void main(String[] args) {
		int[] x = {1,3,9,2,4};
		heapsort(x);
		for (int i: x) {
			System.out.print(i+" ");
		}
		
	}

}
