package src;

import java.util.Arrays;

public class MediumSorts {

    public static void Merge(int[] arr, int left, int middle, int right) { // not working yet
        int[] B = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                B[k] = arr[i];
                i++;
            } else {
                B[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= middle)
        {
            B[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right) {
            B[k] = arr[j];
            j++;
            k++;
        }
        for (k = left; k < right; k++) {
            arr[k] = B[k - left + 1];
        }
    }

    public static void MergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            MergeSort(arr, left, middle);
            MergeSort(arr, middle + 1, right);
            Merge(arr, left, middle, right);
        }

    }

    public static void QuickSort(int[] arr, int left, int right) {
        if(left < right){
            int k = Partition(arr, left, right);
            QuickSort(arr, left, k - left);
            QuickSort(arr, k + 1, right);
        }
    }

    public static int Partition(int[] arr, int left,int right){
        int i = left;
        int j = right -1;
        int p = arr[right];
        do {
            while (i < right && arr[i] < p) {
                i++;
            }
            while (j > left && arr[j] > p) {
                j++;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[right];
                arr[right] = temp;
            }
        } while (i >= j);
        return i;
    }

    public static void main(String[] args) {
        int[] test1 = new int[5];

        for (int i = 0; i < test1.length; i++) {
            test1[i] = test1.length - i;
        }

        int[] test2 = test1;

        System.out.println(testSorted(test1));
    }

    public static boolean testSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}