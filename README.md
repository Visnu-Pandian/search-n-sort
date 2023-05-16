# search-n-sort

Objectives:
  - To implement generic sorting and searching algorithms.
  - To use Junit testing for Test Driven Development.
  - To use packages to organize your code.
  - To reinforce software engineering principles.

Overview:
Searching and sorting data structures is a very common task in computer science. As we have seen in class, searching aand sorting can be implemented in many ways. Through generics and
interfaces, Java allows us to implement these algorithms in general ways that can sort any Object
we desire, as long as we implement the Comparable interface.

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

Search.java - A utility class that contains only static methods and fields. The Search class
should implement one static method for each searching algorithm (with a wrapper method
for recursive algorithms). The static methods should all take as input:

1. a generic List of a given Type parameter that extends Comparable, and
2. an instance of the same Type parameter to search for.

Each method should return either the index of the target or -1 if the target is not in the List. The searching methods should also be able to handle incorrect input, with a custom
exception that will be thrown if:
1. the target is null, or
2. the List to search is null.
