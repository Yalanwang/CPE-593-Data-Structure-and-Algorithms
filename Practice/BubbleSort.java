public class BubbleSort {
	public static void ArraySort(int[] x) {
		for (int i = 0; i< x.length; i++ ) {
			for (int j = 0; j < x.length - 1 - i; j++) {
				if (x[j] > x[j+1]) {
					int temp = x[j];
					x[j] = x[j + 1];
					x[j + 1] = temp;
				}
			}
		}
	}
	
	public static void printArray(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] x = {3, 2, 4, 6, 7, 8};
		ArraySort(x);
		printArray(x);
				
	}
	
}
