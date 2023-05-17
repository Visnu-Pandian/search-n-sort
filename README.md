# search-n-sort

Objectives:
  - To implement generic sorting and searching algorithms.
  - To use Junit testing for Test Driven Development.
  - To use packages to organize your code.
  - To reinforce software engineering principles.

Overview:
Searching and sorting data structures is a very common task in computer science. As we have seen in class, searching aand sorting can be implemented in many ways. Through generics and interfaces, Java allows us to implement these algorithms in general ways that can sort any object we desire, as long as we implement the Comparable interface.

Sorting Algorithms
  - Bubble Sort
  - Insertion Sort
  - Selection Sort
  - Quick Sort

Searching Algorithms
  - Linear Search
  - Iterative Binary Search
  - Recursive Binary Search

Project Organization:
  - project1.algorithms: contains the classes Search.java, Sort.java
  - project1.exceptions: contains the classes InvalidArgumentException, NullArgumentException
  - project1.test: contains the (provided) classes Dog, SearchTest, SortTest, Utils

Search.java - A utility class that contains only static methods and fields. The Search class should implement one static method for each searching algorithm (with a wrapper method for recursive algorithms). The static methods should all take as input:

1. a generic List of a given Type parameter that extends Comparable, and
2. an instance of the same Type parameter to search for.

Each method should return either the index of the target or -1 if the target is not in the List. The searching methods should also be able to handle incorrect input, with a custom exception that will be thrown if:

1. the target is null, or
2. the List to search is null.

Sort.java - A utility class that contains only static methods and static constants. The Sort class should implement two static constant integers, one named ASCENDING and one named DESCENDING, as well as one static method for each sorting algorithm (with a wrapper method for recursive algorithms). The static methods should all take as input:

1. a generic List of a given Type parameter that extends Comparable, and
2. a constant integer identifying whether to sort the algorithm in ascending or descending order.

Each sorting algorithm should sort the given List into the order indicated by the passed
parameter. The sorting methods should also be able to handle incorrect input, with two
custom exceptions that will be thrown if:

1. the List to sort is null, or
2. an incorrect value is detected for the sorting order parameter.

NullArgumentException - A  custom exception class that is thrown to indicate that a null argument was detected. This class should extend the Exception class and have a custom message.

InvalidArgumentExeption - A custom exception class that is thrown to indicate that a number other than Sort.ASCENDING or Sort.DESCENDING was detected. This class shoul extend the Exception class and have a custom message.
