
public class BinarySearchRecursive {
	public void search(int[] x, int target, int low, int high) {
		int mid = (low + high)/2;
		if (low > high) {
			System.out.println("Not Found");
			System.out.println();
			return;
		}
		if(x[mid] == target) {
			System.out.print("The Target is:"+ x[mid]);
			System.out.println();
		} else if(x[mid] > target){
			search(x, target, low, mid - 1);			
		} else if(x[mid] < target) {
			search(x, target, mid + 1, high);
		} 		
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,7,9,10};
		BinarySearchRecursive BSR = new BinarySearchRecursive();
		BSR.search(a, 8, 0, a.length-1);
		BSR.search(a, 3, 0, a.length-1);
 	}

}
