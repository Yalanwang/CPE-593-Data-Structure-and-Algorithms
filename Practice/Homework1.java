import java.util.Scanner;


public class Homework1 {
	
	public static void findFactor(int number) {

		int index = 2; // Numbers to test as factors 
		
		// Find and display all the smallest factors in increasing order
		while (number / index != 1) {
		// Test as a factor of number
		if (number % index == 0) {
		System.out.print(index + ", ");
		number /= index; 
		}
		else
		index++; // Increment index
		}
		System.out.println(number + ".");

		
	}
	
	public static void printPrimeNumbers(int numberOfPrimes) {
		final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line
		int count = 0; // Count the number of prime numbers
		int number = 2; // A number to be tested for primeness

		// Repeatedly find prime numbers
		while (number < numberOfPrimes) {
			// Print the prime number and increase the count
			if (isPrime(number)) {
				count++; // Increase the count
			
				if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
					// Print the number and advance to the new line
					System.out.printf("%-5s\n", number);
				}
				else
					System.out.printf("%-5s", number);
			}
	
			// Check whether the next number is prime
			number++;
		}
	}

	/** Check whether number is prime */
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number/2; divisor++) {
			if (number % divisor == 0) { // If true, number is not prime
				return false; // Number is not a prime
			}
		}

		return true; // Number is prime
	}

	
	public static void countNumber() {
		int numberOfPrimes = 0;	// Counts the number of prime numbers

		// Find the number of prime numbers less than 10000
		for (int i = 1; i < 1000; i++) {
			if (isPrime(i))
				numberOfPrimes++; // Increament 
		}

		// Display result
		System.out.println(
			"The number of prime numbers less than 10000: " + numberOfPrimes);
	}
	
	
	public static void main(String[] args) {
		
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter an integer
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		
		findFactor(number);
		
		System.out.println("The first 1000 prime numbers are \n");
		printPrimeNumbers(1000);
		
		System.out.println();
		countNumber();
		input.close();
		
		
	}

		
	}





