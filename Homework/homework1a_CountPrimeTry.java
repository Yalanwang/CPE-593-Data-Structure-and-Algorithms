import java.util.BitSet;
import java.util.Scanner;

public class homework1a  {
	public static void main(String[] args){
		//input
		boolean sign = true;
		long a = -1;
		long b= -1;
		while(sign){
			Scanner s = new Scanner(System.in);
			System.out.print("Enter the minimum interger number:");
			a = s.nextLong();//set the minimum 
			System.out.print("Enter the maximum interger number:");
			b = s.nextLong();//set the maximum
			if(a<b && a>=0 ){
				sign = false;
				System.out.println("Input complete!");
			}
			else{
				System.out.println("Note: a should be less than b!\nBoth of them should be no less than 0!");
			}
			s.close();
		}

		
		BitSet numbers = new BitSet((int)(b - a));//set bit vector "numbers" to store the value
		int i;
		int j;
		

		for(i = 0; i <= (int)(b - a); i++){
			if ( (i + a) % 2 == 1 && i+a != 1){
				numbers.set(i,true);
			}
			if (i+a == 2){
				numbers.set(i,true);
			}
		}
		
		//apply Eratosthenes Algorithms
		for(i = 3; i <= numbers.size();i += 2){
			if (numbers.get(i) == true){
				//handling the sieve numbers
				for(j = 3*i; j<= numbers.size(); j += 2*i){
					numbers.set(j,false);
				}
				
				//handling the original numbers ps: we need to consider j+a because we have used (b-a) to store.
				if (i < a){
					if ( ( (a - (int)(a%i) ) / i ) % 2 == 0 ){
						for (j = i-(int)(a%i); j < numbers.size(); j += 2*i){
							numbers.set(j,false);
						}
					}
				    else{
				    	for (j = 2*i - (int)(a%i); j < numbers.size(); j += 2*i){
				    		numbers.set(j,false);
				    	}
					}
				}
				else{
					for(j = i*i - (int)a; j<= numbers.size(); j += 2*i){
						numbers.set(j,false);
					}
				}
			}
		}
		
		int count = 0;
		for (i =0; i <= numbers.size(); i++){
			if (numbers.get(i) == true){
				count++;
			}
		}
		System.out.println("There are "+count+" prime numbers between "+a+" and "+b+"!");
	}
	
	
}
