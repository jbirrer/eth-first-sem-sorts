package src;

public class EasySorts {
    public void BubbleSort(int[] arr) {
        /*
         * idea: every iteration "bubbles" the largest element to the back
         */

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // check if in wrong order, if so swap
                    int temp = arr[j]; // swap operation
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void InsertionSort(int[] arr) {
        int length = arr.length;
    }

    public void SelectionSort(int[] arr) {
        /*
         * idea: in every iteration we look for the minimum element and bring it to the
         * end of the already sorted part
         */

        int length = arr.length;

        for (int i = 0; i < length; i++) { // INV(everything until index i is already sorted)
            int minIndex = i;
            int j = i;
            while (j < length) { // find smallest element after i
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            int temp = arr[i]; // swap operation
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }

    
}