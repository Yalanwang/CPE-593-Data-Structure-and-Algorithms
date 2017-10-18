//have bugs


public class MergeSort {
	public static void merge(int[] a, int low, int high, int mid) {
		int i = low; 
		int k = 0;
		int j = mid +1;
		int[] temp = new int[high-low+1];
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			}
			else temp[k++] = a[j++];
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= high) {
			temp[k++] = a[j++];
		}
		for (i = 0; i< high; i++) {
			a[low+i] = temp[i];
		}
	}
	
	public static void sort(int[] a, int low, int high) {
		int mid;
		if(low < high) {
			mid = (high+low)/2;
			sort(a, low, mid);
			merge(a, low, high, mid);
			sort(a, mid+1,high);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,5,5,7,1,3,6};
		int low = 0;
		int high = a.length-1;
		sort(a, low, high);
		for (int i = 0; i <= high; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
