import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Sort integers using 3 versions of bubble sort
 * 
 * @author Nadeesha Maduranga (nadeesham332@gmail.com)
 *
 */

public class BubbleSort {

	static int comparisons, swapping;

	/**
	 * display: displays the sorted arrays
	 * 
	 * @param version     - version of bubble sort algorithm
	 * @param sortedarr   - sorted array
	 * @param comparisons - number of comparisons done in each versions
	 * @param swapping    - number of swapping done in each versions
	 */

	static void display(int version, int[] sortedarr, int comparisons, int swapping) {
		System.out.println("Sorted array (using Bubble Sort-V" + version + "): " + Arrays.toString(sortedarr)
				+ "\t\tComparisons: " + comparisons + "\t\tSwapping: " + swapping);
	}

	/**
	 * bubbleSort: sorts integer numbers using version 1 of bubble sort algorithm.
	 * 
	 * @param arr - unsorted array
	 * @return - sorted array
	 */
	static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		comparisons = 0;
		swapping = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				comparisons++; // count comparisons
				if (arr[j] < arr[j - 1]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					swapping++; // count swapping
				}
			}
		}
		display(1, arr, comparisons, swapping);
	}

	/**
	 * bubbleSort2: sorts integer numbers using version 2 of bubble sort algorithm.
	 * 
	 * @param arr - unsorted array
	 * @return - sorted array
	 */
	static void bubbleSort2(int[] arr) {
		int n = arr.length;
		int temp = 0;
		comparisons = 0;
		swapping = 0;
		for (int i = n; i > 0; i--) {
			boolean swapped = false;
			for (int j = 1; j < i; j++) {
				comparisons++; // count comparisons
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					swapped = true;
					swapping++; // count swapping
				}
			}
			if (!swapped) {
				break;
			}
		}
		display(2, arr, comparisons, swapping);
	}

	/**
	 * optimizedBubbleSort: sorts integer numbers using version 3 of bubble sort
	 * algorithm.
	 * 
	 * @param arr - unsorted array
	 * @return - sorted array
	 */
	static void optimizedBuubleSort(int[] arr) {
		int n = arr.length;
		int newLimit = 0, temp = 0;
		comparisons = 0;
		swapping = 0;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				comparisons++; // count comparisons
				if (arr[i - 1] > arr[i]) {
					// swap elements
					temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
					swapping++; // count swapping

					swapped = true;
					newLimit = i;
				}
			}
			n = newLimit;
		} while (swapped);
		display(3, arr, comparisons, swapping);
	}

	/**
	 * main: sorts integer numbers using different versions of bubble sort
	 * algorithms.
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.print("This program will sort integer numbers in given array using bubble sort.\n" + "n - "
				+ "number of integers in input array.\n" + "Enter input array size(n): ");

		// Getting input size from user
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int array[] = new int[n];
		int inputSize = 0;
		String input;

		do {
			System.out.print("Enter " + n + " integers, separated using space, to sort (n1 n2 n3 ...): ");
			input = reader.readLine();
			inputSize = input.split(" ").length;
		} while (inputSize != n);

		String[] numbers = input.split(" ");
		for (int j = 0; j < n; j++) {
			array[j] = Integer.parseInt(numbers[j]);
		}

		System.out.println("\nUnsorted array: " + Arrays.toString(array));
		bubbleSort(array.clone());
		bubbleSort2(array.clone());
		optimizedBuubleSort(array.clone());
	}
}
