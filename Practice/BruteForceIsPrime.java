
public class BruteForceIsPrime {
	public boolean isPrime(int a) {
		for (int i = 2; i < a-1 ; i++) {
			if (a % i == 0) {
				return false;
			}	
		}
		return true;
	}
	
	public static void main(String[] args) {
		BruteForceIsPrime BrP = new BruteForceIsPrime();
		System.out.println(BrP.isPrime(5));
		System.out.println(BrP.isPrime(2));
		System.out.println(BrP.isPrime(110));
		System.out.println(BrP.isPrime(113));
	}

}
