
public class InsertionSort {
	public static void ArraySort(int[] x) {
		for(int i = 1; i < x.length; i++) {
			int temp = x[i];
			int j;
			for (j = i-1; j >= 0; j--) {
				if (x[j] >= temp) {
					x[j+1] = x[j];
				}
				else {
					x[j+1] = temp;
					break;
				}
			}
			if (j == -1 && x[0] > temp) {
				x[0] = temp;
			}
		}
	}
	
	public static void printArray(int[] x) {
		for (int i=0; i<x.length;i++) {
			System.out.print(x[i] +" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] x = {2,4,6,9,1,8,7};
		ArraySort(x);
		printArray(x);
	}

}
