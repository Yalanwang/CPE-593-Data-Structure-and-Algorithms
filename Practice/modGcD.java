//gcd(a,b) = gcd(b, b mod a) -> gcd(b, b-a)
public class modGcD {
	public static void ModGcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		System.out.print(a);
		System.out.println();
	}
	
	public static void main (String[] agrs) {
		ModGcd(55, 34);
		ModGcd(32, 18);
	}

}
