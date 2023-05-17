/**
* A utility class that contains only static methods and static constants. It implements two static constant integers, one named ASCENDING and one named DESCENDING, as well as one static method for each sorting algorithm (with a wrapper method for recursive algorithms).
*
* @author Visnu Pandian
* @version 1.0
* @since 2023-02-17
*/

package project1.algorithms;

import java.util.List;

import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;

public class Sort {
	// setting constants used to distinguish sorting types.
	public static final int ASCENDING = 1;
	public static final int DESCENDING = -1;

	/**
	 * bubbleSort
	 * 
	 * sorts the provided list using the bubbleSort algorithm
	 * 
	 * @param input    the list to be sorted via bubbleSort.
	 * @param sortType the preference for either ascending or descending order list
	 *                 when sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @return None
	 */

	public static <E extends Comparable<E>> void bubbleSort(List<E> input, int sortType)
			throws NullArgumentException, InvalidArgumentException {
		if (input == null) { // checking for null list as parameter and throwing exception if true.
			throw new NullArgumentException("Error. Input list cannot be empty!");
		}

		int n = input.size();
		int lastPos;
		int index;

		switch (sortType) {
		case ASCENDING:
			for (lastPos = n - 1; lastPos >= 0; lastPos--) {
				for (index = 0; index <= lastPos - 1; index++) {
					if (input.get(index).compareTo(input.get(index + 1)) > 0) {
						bubbleSwap(index, input);
					}
				}
			}
			break;
		case DESCENDING:
			for (lastPos = n - 1; lastPos >= 0; lastPos--) {
				for (index = 0; index <= lastPos - 1; index++) {
					if (input.get(index).compareTo(input.get(index + 1)) < 0) {
						bubbleSwap(index, input);
					}
				}
			}
			break;
		default:
			throw new InvalidArgumentException("Error. Sort type must either be ASCENDING or DESCENDING.");
		}

	}

	/**
	 * selectionSort
	 * 
	 * sorts the provided array using the selectionSort algorithm
	 * 
	 * @param input    the list to be sorted via selectionSort.
	 * @param sortType the preference for either ascending or descending order list
	 *                 when sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @return None
	 */

	public static <E extends Comparable<E>> void selectionSort(List<E> input, int sortType)
			throws NullArgumentException, InvalidArgumentException {

		if (input == null)
			throw new NullArgumentException("Error. Input list cannot be empty!");

		int startScan;
		int index;
		int minIndex;
		E min;
		int maxIndex;
		E max;
		int n = input.size();

		switch (sortType) {
		case ASCENDING:
			for (startScan = 0; startScan < (n - 1); startScan++) {
				minIndex = startScan;
				min = input.get(startScan);
				for (index = startScan + 1; index < n; index++) {
					if (input.get(index).compareTo(min) < 0) {
						min = input.get(index);
						minIndex = index;
					}
				}
				swapE(startScan, minIndex, input);
			}
			break;
		case DESCENDING:
			for (startScan = 0; startScan < (n - 1); startScan++) {
				maxIndex = startScan;
				max = input.get(startScan);
				for (index = startScan + 1; index < n; index++) {
					if (input.get(index).compareTo(max) > 0) {
						max = input.get(index);
						maxIndex = index;
					}
				}
				swapE(startScan, maxIndex, input);
			}
			break;
		default:
			throw new InvalidArgumentException("Error. Sort type must either be ASCENDING or DESCENDING.");
		}

	}

	/**
	 * insertionSort
	 * 
	 * sorts the provided array using the insertionSort algorithm
	 * 
	 * @param input    the list to be sorted via insertionSort.
	 * @param sortType the preference for either ascending or descending order list
	 *                 when sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @return None
	 */

	public static <E extends Comparable<E>> void insertionSort(List<E> input, int sortType)
			throws NullArgumentException, InvalidArgumentException {

		if (input == null)
			throw new NullArgumentException("Error. Input list cannot be empty!");

		E unsortedValue;
		int scan;
		int n = input.size();

		switch (sortType) {
		case ASCENDING:
			for (int index = 1; index < n; index++) {
				unsortedValue = input.get(index);

				scan = index;
				while (scan > 0 && input.get(scan - 1).compareTo(unsortedValue) > 0) {
					swapE(scan, scan - 1, input);
					scan--;
				}
			}
			break;
		case DESCENDING:
			for (int index = 1; index < n; index++) {
				unsortedValue = input.get(index);

				scan = index;
				while (scan > 0 && input.get(scan - 1).compareTo(unsortedValue) < 0) {
					swapE(scan, scan - 1, input);
					scan--;
				}
			}
			break;
		default:
			throw new InvalidArgumentException(
					"Error. Sort type must be ASCENDING(1) or DESCENDING(-1). Invalid value: " + sortType);
		}

	}

	/**
	 * quickSort
	 * 
	 * wrapper method for doQuickSort.
	 * 
	 * @param input    The list to sorted via quickSort.
	 * @param sortType the preference for either ascending or descending order list
	 *                 when sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @return None
	 */

	public static <E extends Comparable<E>> void quickSort(List<E> input, int sortType)
			throws NullArgumentException, InvalidArgumentException {
		if (input == null) { // checking for null list as parameter and throwing exception if true.
			throw new NullArgumentException("Error. Input list cannot be empty!");
		}
		int n = input.size();

		if (sortType != ASCENDING && sortType != DESCENDING)
			throw new InvalidArgumentException("Error. Sort type must either be ASCENDING or DESCENDING.");

		doQuickSort(input, 0, n - 1, sortType); // calling recursive method.

	}

	/**
	 * doQuickSort
	 * 
	 * uses the QuickSort algorithm to sort a list.
	 * 
	 * @param input    The list to sorted via quickSort.
	 * @param start    The starting index of the list to sort
	 * @param end      The ending index of the list to sort
	 * @param sortType the preference for either ascending or descending order list
	 *                 when sorted.
	 * 
	 * @throws InvalidArgumentException
	 * 
	 * @return None
	 */

	private static <E extends Comparable<E>> void doQuickSort(List<E> input, int start, int end, int sortType)
			throws InvalidArgumentException {
		int pivotPoint;

		if (start < end) {
			pivotPoint = partition(input, start, end, sortType); // getting pivot point.

			doQuickSort(input, start, pivotPoint - 1, sortType); // sorting first sub list.

			doQuickSort(input, pivotPoint + 1, end, sortType); // sorting second sub list.
		}
	}

	/**
	 * The partition method selects a pivot value in an array and arranges the array
	 * into two sub lists. All the values less than the pivot will be stored in the
	 * left sub list and all the values greater than or equal to the pivot will be
	 * stored in the right sub list.
	 * 
	 * @param input    The list to partition.
	 * @param start    The starting index of the area to partition.
	 * @param end      The ending index of the area to partition.
	 * @param sortType the preference for either ascending or descending order list
	 *                 when sorted.
	 * 
	 * @throws InvalidArgumentException
	 * 
	 * @return endOfLeftList The index of pivot value.
	 */

	private static <E extends Comparable<E>> int partition(List<E> input, int start, int end, int sortType)
			throws InvalidArgumentException {

		int endOfLeftList;
		int mid;

		mid = (start + end) / 2; // finding subscript of middle element for pivot value.

		swapE(start, mid, input); // swapping middle element to start.
		endOfLeftList = start;
		E pivotValue = input.get(start); // pivotValue

		switch (sortType) {

		case ASCENDING: // standard loop
			for (int scan = start + 1; scan <= end; scan++) {
				if (input.get(scan).compareTo(pivotValue) < 0) { // move values less than pivot to left sub list.
					endOfLeftList++;
					swapE(endOfLeftList, scan, input);
				}
			}
			break;

		case DESCENDING: // reversed loop
			for (int scan = start + 1; scan <= end; scan++) { // move values more than pivot to left sub list.
				if (input.get(scan).compareTo(pivotValue) > 0) {
					endOfLeftList++;
					swapE(endOfLeftList, scan, input);
				}
			}
			break;
		default: // if any sortType other than ascending or descending is used.
			throw new InvalidArgumentException("Error. Sort type must either be ASCENDING or DESCENDING.");
		}

		swapE(start, endOfLeftList, input); // moving pivotValue to end of left sub list.

		return endOfLeftList; // returning index of pivot value.
	}

	/**
	 * swapE
	 * 
	 * swaps the elements at the specified indexes within the specified list.
	 * 
	 * @param i     the index of the first element.
	 * @param j     the index of the second element.
	 * @param input the list in which the elements have to be swapped.
	 * 
	 * @return None
	 */

	private static <E extends Comparable<E>> void swapE(int i, int j, List<E> input) {

		E temp = input.get(i);
		input.set(i, input.get(j));
		input.set(j, temp);
	}

	private static <E extends Comparable<E>> void bubbleSwap(int i, List<E> input) {

		E temp = input.get(i);
		input.set(i, input.get(i + 1));
		input.set(i + 1, temp);
	}

}
