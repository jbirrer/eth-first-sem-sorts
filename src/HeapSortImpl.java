package src;



public class HeapSortImpl {
    public static void heapSort(int[] arr){
        HeapImpl.makeHeap(arr);
        for(int m = arr.length-1; m >= 0; m--){
            int temp = arr[0];
            arr[0] = arr[m];
            arr[m] = temp;
            HeapImpl.heapify(arr, 0, m);
        }
    }
}
