package randomization;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Shuffle {
	public static void main(String[] args) {
		int[] a = new int[100];
		for (int i = 0; i < a.length; i++)
			a[i] = i;
		displayArray(a);
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			swap(a, i, rand.nextInt(a.length - i) + i);
		}
		displayArray(a);
		Arrays.sort(a);
		displayArray(a);
	}

	public static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	public static void displayArray(int[] array) {
		for (int a : array) {
			System.out.print(a);
			System.out.print(" ");
		}
		System.out.println();
	}
}
