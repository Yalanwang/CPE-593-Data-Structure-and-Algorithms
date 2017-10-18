
public class EratosthenesPrime {
//	public static boolean IsPrime(int a) {
//		for (int i = 2; i <= Math.sqrt(a); i++) {
//			if (a % i == 0)
//				return false;
//		}
//		return true;
//	}
	
	public static void Era(int n) {
		boolean[] numbers = new boolean[n+1];
		for (int i = 0; i < n; i++) {
			numbers[i] = true;
		}
		
		for (int i = 2; i < n; i++) {
			if (numbers[i]) {
				System.out.print(i+" ");
			}
			for (int j = i * 2; j < n; j+=i) {
				numbers[j] = false;
			}
		}
	}
	
	public static void ModifiedEra(int a) {
		boolean[] numbers = new boolean[a+1];
		for (int i = 0; i < a; i++) {
			numbers[i] = true;
		}
		
		for (int i = 2 * 2; i < a; i+=2) {
			numbers[i] = false;
			}
		for (int i = 3; i < a; i+=2) {
			if (numbers[i]) {
//				System.out.print(i+ " ");
				for (int j = i * i; j < a ; j+=2*i) {
					numbers[j] = false;
				}	
//				System.out.print(i+ " ");	
			}
			System.out.print(i+ " ");
		}
		
	}
	
	public static void main(String[] args) {
		Era(20);
//		System.out.print(IsPrime(9));
		System.out.println();
		ModifiedEra(20);
	}

}
