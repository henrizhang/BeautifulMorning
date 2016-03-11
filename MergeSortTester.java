/*======================================
  class MergeSortTester
  ALGORITHM:
  
  This implementation of mergesort uses basic recursion and an algorithm to sort ordered lists.
  The algorithm to sort an ordered array creates a new array with a length of the sum of the lengths of the two parameter arrays
    Three counters are used in this iterative algorithm:
        cA records the location of the merge in array A
        cB records the location of the merge in array B
        counter records how many elements have been sorted (where in the new array merge is at)
    Every loop the algo compares the current first elements of each array:
        if a[cA] is smaller than b[cB], then a[cA] goes into newArray[counter]
            otherwise the opposite.
    The conditional for the while loop is if one of the counters cA/cB has reached the end of the array
        the while loop then terminates if the conditional is true
    The algo then checks which counter cA or cB has reached the end of its array
        if cA has reached the end, it appends the rest of b into the newArray
            otherwise the opposite
    
  
  BIG-OH CLASSIFICATION OF ALGORITHM: O(nlogn)
  
  Based on our diagram, we concluded that merge sort indeed has a time complexity of O(nlogn).

    Explanation:

    -the iterations required to divide the array down to single-elements arrays would be the lowest power of 2 greater than the number of arrays in the list: thus, log n
    
    -in the merging steps, each merge is O(n), as the elements are compared to each other, and comparisons add up in linear fashion.

    To merge back after the division, the levels are clearly the same from top to the turning point, and from there to the bottom. 
    Thus, it is still logn, but since after each level, we also have a merge step, we multiply n by log n and get n log n
    
  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 0
  n=10      time: 0
  n=100     time: 0
  ...
  n=100001  time: 59 ms
  n=200001 time: 171 ms
  n=300001 time: 158 ms
  n=400001 time: 208 ms
  n=500001 time: 276 ms
  n=600001 time: 349 ms
  n=700001 time: 421 ms
  n=800001 time: 478 ms
  n=900001 time: 551 ms
  n=1000001 time: 642 ms
  ANALYSIS:
  
  The results of our time test supports the nlogn complexity. 
  The increase in ms becomes almost linear as n gets very high. Between points closer 
  to 0 on the x axis, the average rate of change seems to increase while going up.
  However, this change levels off and soon becomes close to linear, reflecting 
  the behaviour of an n * (log n) function
  ======================================*/

public class MergeSortTester {
    
    public static int[] fillArray(int size) {
        int[]res = new int[size];
        for (int x = 0; x < size; x++) res[x] = (int) (Math.random() * size);
        return res;
    }
    
    public static int[] sort( int[] arr ) {
        if ( arr.length > 1) {
            int med = (int) (arr.length / 2);
            int[] arr1 = new int[med];
            int[] arr2 = new int[arr.length - med];
            for (int x = 0; x < med; x++) arr1[x] = arr[x];
            for (int x = 0; x < arr.length - med; x++) arr2[x] = arr[x + med];
            return merge( sort(arr1), sort(arr2));
        }
        return arr;
    }
    
    public static int[] merge( int[] a, int[] b ) {
        int[] r = new int[a.length + b.length];
        int A, B, counter;
        A = B = counter = 0;
        while (A < a.length && B < b.length) {
            if ( a[A] < b[B] ) {
                r[counter] = a[A];
                A++;
            }
            else {
                r[counter] = b[B];
                B++;
            }
            counter++;
        }
        if (A == a.length) {
            while (counter < r.length) {
                r[counter] = b[B];
                counter++;
                B++;
            }
        }
        else {
            while (counter < r.length) {
                r[counter] = a[A];
                counter++;
                A++;
            }
        }
        return r;
    }
    
    public static String Timer(int[] array) {
        int len = array.length;
        long startTime = System.currentTimeMillis();
        sort( array );
        long endTime = System.currentTimeMillis();
        return len + " elements: " + (endTime - startTime) + " ms";
    }

    /******************************
     * execution time analysis 
     * The results of our time test supports the nlogn complexity. 
  The increase in ms becomes almost linear as n gets very high. Between points closer 
  to 0 on the x axis, the average rate of change seems to increase while going up.
  However, this change levels off and soon becomes close to linear, reflecting 
  the behaviour of an n * (log n) function
     * We created a method of filling arrays, a method of timing arrays in ms
     * using currentTimeMillis, and recorded values up to 1000001 starting from 1
     ******************************/
    public static void main( String[] args ) {
        for (int x = 1; x < 100000000; x+=10000) {
            System.out.println(Timer(fillArray(x)));
        }
    }//end main

}//end class
