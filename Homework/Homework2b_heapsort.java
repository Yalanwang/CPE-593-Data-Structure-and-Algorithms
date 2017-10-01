// heapsort homework2 Yalan Wang


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Homework2b {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("E:/eclipse/workspace/Sort/src/hw2b.txt"));
		BufferedReader br = new BufferedReader(new FileReader("hw2b.dat"));
		String s;
		while ((s = br.readLine()) != null) {
//			hlc.add(s);
//			System.out.println(s);
			if (s.contains(" ")) {
				String[] strs = s.split(" ");
				int[] nums = new int[strs.length];
				for (int i=0; i<strs.length;i++) {
					nums[i] = Integer.parseInt(strs[i]);
				}
				insertionSort(nums);
				printArray(nums);
			}
		}
		br.close();
	}
	
	public static void printArray(int[] x){
		for (int i=0; i < x.length; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	
	public static void insertionSort(int[] x) {
		for (int i = 1; i < x.length; i++) {
			heapSortAsc(x, i + 1);
		}
	}

	public static void heapSortAsc(int[] a, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(a, i, n - 1);
		}
		for (int i = n - 1; i > 0; i--) {
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			maxHeapDown(a, 0, i - 1);
		}
	}

	public static void maxHeapDown(int[] a, int start, int end) {
		int c = start;
		int tmp = a[start];

		for (int l = 2 * c + 1; l <= end; c = l, l = 2 * l + 1) {
			if (l < end && a[l] < a[l + 1])
				l++;
			if (a[start] > a[l])
				break;
			else {
				a[c] = a[l];
				a[l] = tmp;
			}
		}
	}
}

