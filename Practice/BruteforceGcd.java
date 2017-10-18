
public class BruteforceGcd {
	public void bruteforceGcd(int a, int b) {
		int min = Math.min(a, b);
		for(int i = min; i >=2; i--) {
			if (a % i == 0 & b % i == 0) {
				System.out.print(i+" ");
			}
//			System.out.print(1);
		}
		System.out.print(1);
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		BruteforceGcd BrG = new BruteforceGcd ();
		BrG.bruteforceGcd(12,20);
		BrG.bruteforceGcd(12,0);
		BrG.bruteforceGcd(3025,1025);
	}


}
