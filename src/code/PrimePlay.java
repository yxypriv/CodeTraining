package code;

import java.util.ArrayList;
import java.util.List;

public class PrimePlay {

	public static void main(String[] args) {
		System.out.println(primeCounter(12)); // 2,2,3
		System.out.println(primeCounter(36)); // 2,2,3,3
		System.out.println(primeCounter(210)); // 2,3,5,7
		System.out.println(primeCounter(100)); // 2,2,5,5
		System.out.println(primeCounter(37)); // 37
	}


	public static int primeCounter(int n) {
		List<Integer> prime = new ArrayList<Integer>();
		return countPrime(n, 2, prime);
	}

	public static int countPrime(int n, int start, List<Integer> prime) {
		if (prime.size() == 0)
			prime.add(start);
		else {                                       
			boolean isPrime = true;
			do {
				isPrime = true;
				for (int i = 0; i < prime.size(); i++) {
					if (start % prime.get(i) == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					prime.add(start);
				} else {
					start++;
				}
			} while (!isPrime && start <= Math.sqrt(n));
			if (!isPrime) {
				start = n;
			}
		}
		int counter = 0;
		while (n % start == 0) {
			n /= start;
			counter++;
		}
		if (n > 1)
			return countPrime(n, start + 1, prime) + counter;
		else
			return counter;
	}
}
