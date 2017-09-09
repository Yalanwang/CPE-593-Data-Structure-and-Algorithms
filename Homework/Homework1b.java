/* First homework 1b
 * Yalan Wang
 * Sep 08 2017
 */


import java.util.Random;

public class Homework1b {
	public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        Random rand = new Random();
        
        int num1;
        int num2;
        while (true) {
        	num1 = rand.nextInt(100);
        	num2 = rand.nextInt(50);
        	if (num1 > num2) {
        		break;
        	}
        }
        System.out.println("inpute:"+ num1 + " " + num2);
        System.out.println("output: "+ choose(num1, num2));
        long endtime = System.currentTimeMillis();
        System.out.printf("runtime: ");
        System.out.println(endtime - starttime + " milliseconds");

	}

	public static double choose(int n, int r) {
		double[] dp = new double[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] * i;
		}
		return dp[n] / dp[r] / dp[n - r];
	}
}
