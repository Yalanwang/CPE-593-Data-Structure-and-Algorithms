
public class QuickSort {
	public static void quickSort(int[] x, int L, int R) {
		int pivot = (x[L]+x[R]) /2 ;
		int i = L; 
		int j = R;
		while (i < j) {
			while(x[i] <= pivot) {
				i++;
				if (i == j) {
					break;
				}
			}
			while(x[j] > pivot) {
				j--;

			}
			if (i < j) {
				int temp = x[j];
				x[j] = x [i];
				x[i] = temp;
			}
			
		}
		//System.out.println("i:" + i + " j: " + j);
		if(L < i - 1){
			quickSort(x, L, i - 1);
		}
		if(R > i){
			quickSort(x,i, R);
		}
	}
	
	public static void printArray(int[] x){
		for (int i=0; i < x.length; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] x = {2,1,4,5,3,8,9};
		quickSort(x,0,x.length-1);
		printArray(x);
	}

}
