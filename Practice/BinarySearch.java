import java.util.Arrays;

public class BinarySearch {
	public void search(int[] x, int target) {
		int L = 0;
		int R = x.length-1;
//		for(int i : x) {
//			System.out.println(i);
//		}
		while(L < R) {
			int mid = (L+R)/2;
			System.out.print("Mid is :" + mid);
			System.out.println();
			
			if(x[mid]>target) {
				R = mid;
//				R= mid-1; // Both Okay
				System.out.print("R is :" + R);
				System.out.println();
			} else if (x[mid]<target) {
				L = mid;
//				L = mid+1; //Both okay
				System.out.print("L is:" + L);
				System.out.println();
			} else if (x[mid] == target){
				System.out.println("Target is:" + x[mid] );
				System.out.println();
				break;
			} else {
			
			System.out.println("Not Found");			
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] x = {2,1,4,3,1,5,6,8,9};
		Arrays.sort(x);
		for (int i : x) {
			System.out.print(i+" ");			
		}
		System.out.println();
		BinarySearch BS = new BinarySearch();
		BS.search(x, 5);
	}

}
