
public class SelectionSort {
	public static void SortArray(int[] x) {
		for (int i = x.length - 1; i > 0; i--) {
			int pos = 0;
			for(int j = 1; j <= i; j++) {
				if(x[j] > x[pos])
					pos = j;
			}	
			int temp = x[pos];
			x[pos] = x[i];
			x[i] = temp;
		}
		
	}
	
	public static void printArray(int[] x) {
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	
	public static void main (String[] args) {
		int[] x = {3,2,5,6,1,7,9};
		SortArray(x);
		printArray(x);
		
		
	}
}
