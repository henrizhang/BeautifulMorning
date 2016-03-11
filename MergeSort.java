/*======================================
  class MergeSort
  Implements mergesort on array of ints.
  Summary of Algorithm: 
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) {
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
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
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
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};
	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );
	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );
	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );
	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );

    }//end main()

}//end class MergeSort
