
public class fischerYatesInPlace {
	public static void shuffle(int[] x) {
		int n = x.length;
		for (int i=0; i<n;i++) {
			int pick = (int)(Math.random()*i);
			int temp = x[pick];
			x[pick] = x[i];
			x[i] = temp;										
		}
		for(int i=0; i<n;i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();		
	}
	
	public static void main(String[] args) {
		int[] x = {1,2,3,4,5,6,7,8,9,10};
		shuffle(x);
	}

}
