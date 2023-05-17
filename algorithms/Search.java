/**
* a utility class that contains only static methods and no fields. The Search class should implement one static method for each searching algorithm (with a wrapper method for recursive algorithms).
*
* @author Visnu Pandian
* @version 1.0
* @since 2023-02-17
*/

package project1.algorithms;

import java.util.List;

import project1.exceptions.NullArgumentException;

public class Search {

	/**
	 * linearSearch
	 * 
	 * searches the given list for a target element using linear search.
	 * 
	 * @param target the element to be searched.
	 * @param input  the list to be searched for index of target.
	 * 
	 * @throws NullArgumentException
	 * 
	 * @return targetIndex the index of the target if it was found, or -1 if the
	 *         target was not found.
	 */

	public static <E extends Comparable<E>> int linearSearch(E target, List<E> input) throws NullArgumentException {
		if (input == null) { // checking for null list.
			throw new NullArgumentException("Error. Input list cannot be null!");
		} else if (target == null) { // checking for null target.
			throw new NullArgumentException("Error. Target to search cannot be null!");
		}

		int targetIndex = -1;
		int i = 0;

		for (E e : input) {
			if (e.compareTo(target) == 0) {
				targetIndex = i;
				return targetIndex;
			}
			i++;
		}
		return targetIndex;
	}

	/**
	 * iterativeBinarySearch
	 * 
	 * searches the given list for a target element using iterative binary search.
	 * 
	 * @param target the element to be searched.
	 * @param input  the list to be searched for index of target.
	 * 
	 * @return targetIndex the index of the target if it was found, or -1 if the
	 *         target was not found.
	 */

	public static <E extends Comparable<E>> int iterativeBinarySearch(E target, List<E> input)
			throws NullArgumentException {
		if (input == null) { // checking for null list.
			throw new NullArgumentException("Error. Input list cannot be null!");
		} else if (target == null) { // checking for null target.
			throw new NullArgumentException("Error. Target to search cannot be null!");
		}
		int n = input.size();
		int targetIndex = -1;

		int lower = 0;
		int upper = n - 1;
		while (lower <= upper) { // iterative loop.
			int mid = (lower + upper) / 2;
			E scan = input.get(mid);

			if (target.compareTo(scan) == 0) {
				targetIndex = mid;
				return targetIndex;
			} else if (target.compareTo(scan) > 0)
				lower = mid + 1; // narrowing list.
			else if (target.compareTo(scan) < 0)
				upper = mid - 1; // narrowing list.
		}
		return targetIndex;
	}

	/**
	 * recursiveBinarySearch
	 * 
	 * The wrapper class for the method which searches the given list for a target
	 * element using recursive binary search.
	 * 
	 * @param target the element to be searched.
	 * @param input  the list to be searched for index of target.
	 * 
	 * @return void
	 */

	public static <E extends Comparable<E>> int recursiveBinarySearch(E target, List<E> input)
			throws NullArgumentException {
		if (input == null) { // checking for null list.
			throw new NullArgumentException("Error. Input list cannot be null!");
		} else if (target == null) { // checking for null target.
			throw new NullArgumentException("Error. Target to search cannot be null!");
		}
		int n = input.size();
		return doRecursiveBinarySearch(target, 0, n - 1, input); // calling recursive method.
	}

	/**
	 * doRecursiveBinarySearch
	 * 
	 * searches the given list for a target element using recursive binary search.
	 * 
	 * @param target the element to be searched.
	 * @param lower  the lower bound of the list to be searched.
	 * @param upper  the higher bound of the list to be searched.
	 * @param input  the list to be searched for index of target.
	 * 
	 * @return targetIndex the index of the target if it was found, or -1 if the
	 *         target was not found.
	 */

	public static <E extends Comparable<E>> int doRecursiveBinarySearch(E target, int lower, int upper, List<E> input) {
		int targetIndex = -1;

		if (lower <= upper) { // checking for valid bounds.
			int mid = (lower + upper) / 2;
			E scan = input.get(mid);
			if (target.compareTo(scan) == 0) {
				targetIndex = mid;
				return targetIndex;
			} else if (target.compareTo(scan) > 0) // if target is greater.
				return doRecursiveBinarySearch(target, mid + 1, upper, input); // recursing with narrower list.
			else if (target.compareTo(scan) < 0) // if target is smaller.
				return doRecursiveBinarySearch(target, lower, mid - 1, input); // recursing with narrower list.
		}
		return targetIndex;
	}

}
