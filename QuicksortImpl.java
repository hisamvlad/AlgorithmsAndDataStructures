package AlgorithmsAndDataStructures;

// We will implement quicksort recursively

public class QuicksortImpl {
    // initial method
    public static void quicksort(int[] array) {
        // with a call to the recursive method
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(int[] array, int left, int right) {
        // quick bounce check
        if (left >= right) {
            // then there's nothing to be done
            return;
        }
        // first, pick a pivot element right in the center
        int pivot = array[(left + right) / 2];
        // partition the array around this pivot
        // and it will return the dividing point
        // between the left and the right side
        int index = partition(array, left, right, pivot);
        // then, sort on the left
        quicksort(array, left, index-1);
        //and the right side
        quicksort(array, index, right);
        // and this is the basic framework we are gonna be working with

    }
    // it's gonna take in the array, left side, right side and the pivot value
    public static int partition(int[] array, int left, int right, int pivot) {
    //it's gonna move pointers simultaniosly, starting form the left and the right side towards each other
        while(left <= right) {
            // move left until I find elements out of order
            // idea: look for an element on the left part that is bigger than the pivot
            // because it should be on the right side
            // and mirror this action for the right side
            while(array[left] < pivot) {
                //keep moving left
                left++;
            }
            while(array[right] > pivot) {
                right--;
            }
            if(left <= right) {
                // swap arrays at these 2 indexes
                // and move left and right over
                swap(array, left, right);
                left++;
                right--;
            }
        }
        // return the partition ( the dividing point from the left and the right side)
        // and that is gonna be where left is:
        return left;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
