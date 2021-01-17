package src;

import java.util.Arrays;

public class HeapImpl {

    protected static void makeHeap(int[] arr) {
        for (int k = arr.length / 2; k >= 0; k--) { //builds heap
            heapify(arr, k, arr.length);
        }
    }

    protected static void heapify(int[] arr, int i, int m) {
        while (2 * i + 1 < m) { // if has left child
            int j = 2 * i + 1;
            if (j + 1 < m) { // has right child
                if(arr[j] < arr[j+1])
                j = j + 1;
            }
            if (arr[i] >= arr[j]) {
                return; // heap condition is fulfilled
            }
            int temp = arr[i]; // swaps child and parent
            arr[i] = arr[j];
            arr[j] = temp;
            i = j;
        }
    }
}
