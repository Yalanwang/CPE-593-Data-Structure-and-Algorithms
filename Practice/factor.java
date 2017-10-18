import java.util.ArrayList;
import java.util.List;

public class factor {
	public static void Factor(int a) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		for(int i = 2; i < a; i++) {
			if (a % i == 0) {
				result.add(i);
//				a /= i;
			}
		}
		result.add(a);
		
		for (int i: result) {
			System.out.print(i+" ");
		}
		System.out.println();	
	}	
		
	public static void main(String[] args) {
		Factor(20);
		Factor(34);
		Factor(113);
		
	}
}
