package AlgorithmsAndDataStructures;

public class BinarySearch {
    public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
        // if left side is bigger than the right one,
        // the list we were about to sort through is out of order
        //
        if(left > right) {
            return false;
        }
        // find the mid point
        int mid = (left + right) / 2;

        // Option to prevent the overflow
        // int mid = left +((right - left) / 2);
        // if element we search for is mid
        if(array[mid] == x) {
            return true;
        // if element is on the left side
        } else if(x < array[mid]) {
            return binarySearchRecursive(array, x, left, mid -1);
        } else {
            // otherwise, go search the right side:
            return binarySearchRecursive(array, x, mid +1, right);
        }
    }
    public static boolean binarySearchRecursive(int[] array, int x) {
        return binarySearchRecursive(array, x, 0, array.length-1);
    }

    public static boolean binarySearchIterative(int[] array, int x) {
       int left = 0;
       int right = array.length -1;

       // iterate for as long as left and right are in the correct positions
        while (left <= right) {
                // find the mid point
            int mid = (left + (right-left) / 2);

            // Option to prevent the overflow
            // int mid = left +((right - left) / 2);
            // if element we search for is mid
            if(array[mid] == x) {
                return true;

            } else if(x < array[mid]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }  return false;
            }
        }


