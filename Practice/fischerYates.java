import java.util.ArrayList;
import java.util.List;

public class fischerYates {
	public static void fischer(int[] x) {
		List<Integer> result = new ArrayList<>();
		for (int i = x.length-1; i>0; i--) {
			int pick = (int)(Math.random()*i);
			result.add(x[pick]);
			x[pick] = x[i];
		}
		for (int i: result) {
			System.out.print(i+" ");
		}
		System.out.println();				
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		fischer(array);
	}

}
