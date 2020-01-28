package AlgorithmsAndDataStructures;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return 2*parentIndex + 1;     }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex -1 ) / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) > 0; }

    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items [indexTwo];
        items[indexTwo] = temp;
    }
 /*If array is full, it creates an array of double that size
 * and copies the array over*/
    private void ensureExtraCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *=2;
        }
    }
    // Returns the first element of the array
    public int peek() {
        // check if the array is empty,
        // if so, there's nothing to return
        if(size == 0) throw new IllegalStateException();
        //otherwise, it returns the first element
        // which will be the first element in our array and the root in the heap
        return items[0];
    }

    /*Extracts the minimum element and removes it from the array*/
    public int poll() {
        if(size == 0) throw new IllegalStateException();
        //Otherwise I need to take the value
        int item = items[0];
        // Take the last elem in the array and move it to the first element
        items[0] = items[size - 1];
        //Then I need to shrink my array
        size--;
        // and then I need to reheapifyDown
        // downshift the element and adjust the heap
        heapifyDown();
        return item;
    }
    //First, I need to ensure there's a capacity

    public void add(int item) {
        ensureExtraCapacity();
        // Then I'm going to add my element into the very last spot
        items[size] = item;
        // Then increase my size
        size++;
        // Then I need to fix the heap looking up
        // Swapping each element with its parent
        heapifyUp();
    }

    public void heapifyUp() {
        // is going to start with a very last element
        int index = size -1;
        // and it's going to walk up as long as there's a parent item
        // and as long as the heap is out of order
        // so I'll put a condition for as long as
        // my parent item is bigger than the current item
        while(hasParent(index) && parent(index) > items[index]) {
            // swap current value with the parent value
            swap(getParentIndex(index), index);
            // and then walk upwards
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        // I'm gonna start at root first
        int index = 0;
        // And then I will walk down as long as I have children
        // and try to fix the heap
        // I only need to check whether there's a left child
        // because if there's no left child, by the heap definition
        // there's no right child
        while(hasLeftChild(index)) {
            // I'm gonna set the smallerChildIndex variable
            // to the smallest index of the left and respectively right child
            int smallerChildIndex = getLeftChildIndex(index);
            // and if there's a right child that is even smaller than the left child
            if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
                //assign the smallerChildIndex variable to this right child index
                smallerChildIndex = getRightChildIndex(index);
            }
            //if the current item is smaller than two of its children
            // then I did a good job and everything now is in order
            if(items[index] < items[smallerChildIndex]) {
                //just exit
                break;
             // but if the heap is still out of order,
            } else {
                //I need to swap my current value with the smallerChildIndex value
                swap(index, smallerChildIndex);
            }
            // and then move down to my smaller child
            index = smallerChildIndex;
        }
    }
}
