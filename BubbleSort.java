package AlgorithmsAndDataStructures;

public class BubbleSort {
    public static void bubblesort(int[] array) {
        // walk through for as long as the array is not sorted
        boolean isSorted = false;
        int lastUnsorted = array.length -1;
        while(!isSorted) {
            // assumption that the array is sorted
            // before walking thourh the array
            isSorted = true;
            // Preventing ArrayOutOfBound exception by length-1
            for(int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i + 1]) {
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

    }
}
