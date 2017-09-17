import java.util.ArrayList;
import java.util.List;

public class Naiveshuffle {
	
	public static void shuffle(int[] x) {
		List<Integer> result = new ArrayList<>();
		int pick = 0;
		for(int i = 0; i < x.length; i++){
			while(x[pick] < 0) {
				pick = (int)(Math.random()*10);
			}
			result.add(x[pick]);
			x[pick] = -1;
		}
		for (int i: result) {
			System.out.print(i +" ");
		}
		System.out.println();		
	}

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffle(array);
        
       
    }
}