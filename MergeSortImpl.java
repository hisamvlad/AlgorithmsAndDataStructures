package AlgorithmsAndDataStructures;
/*Sort the left half, sort the right half and merge them both*/
public class MergeSortImpl {
    public static void mergesort(int[] array) {
        // new temp array where we will copy elements to
        // as we are merging them
        // method to sort the left half
        mergesort(array, new int[array.length], 0, array.length -1);
    }
    //The recursive method
    public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
        // if those things are out of bound
        // exit the method
        if(leftStart >= rightEnd) {
            return;
        }
        // The middle point
        int middle = (leftStart + rightEnd) /2;
        // otherwise we want to do mergesort on the left half
        // from beginning of the left side
        //to the middle
        mergesort(array, temp, leftStart, middle);
        //from middle to the right end
        mergesort(array, temp,middle+1, rightEnd);
        // merge both arrays
        mergeHalves(array, temp, leftStart, rightEnd);
    }

        public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
            // it will divide this array in half
            // and merge them halves

            //Defining the middle point which is left array's end point
            int leftEnd = (rightEnd + leftStart) / 2;
            // defining the beginning of the right array
            int rightStart = leftEnd + 1;
            // total number of elements we are copying over
            // aka full size of the array
            int size = rightEnd - leftStart + 1;

            int left = leftStart;
            int right = rightStart;
            // index of the temp array where elements are
            // going to be copied to
            int index = leftStart;

            //Walking through both halves,
            // Copying smallest elements

            //while they're still unbalanced
            while(left <= leftEnd && right <= rightEnd) {
                if(array[left] <= array[right]) {
                    // copy array of left in
                    temp[index] = array[left];
                    // and then move both pointers

                    left++;
                } else {
                    //otherwise, copy over the right array
                    temp[index] = array[right];
                    // move both pointers

                    right++;
                }
                index++;
            }
            // once one of the pointers goes out of balance,
            // we just need to copy over the remainder of the elements

            //given 2 arrays, copies one array into the other array
            // you can give a specific boundaries

            //In this case, we copy from the array, starting at the left pointer
            // to temp array, starting from its index
            // and we specify, how many elements we want to copy
            System.arraycopy(array, left, temp, index, leftEnd - left + 1);
            //and that will copy all the elements from the left side

            //and then we do the same thing on the right side
            System.arraycopy(array, right, temp, index, rightEnd - right + 1);
            // and then we copy everything from temp, back into the array

            //our source is temp, we copy from left starting position
            // into array, starting at its left starting position
            // and we want to copy a size number of elements
            System.arraycopy(temp, leftStart, array, leftStart, size);

            // because the while loop condition, only the left or the right
            // side will have remaining  elements
            // one of them will be out of boundary
            // and the other will not
        }

    public static void main(String[] args) {

    }
}
