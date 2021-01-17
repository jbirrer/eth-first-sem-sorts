package src;

public class Search {

    public boolean binarySearch(int[] arr, int elem) { //recursive
        // idea: find middle element, if middle element is @param elem, then return true
        // else apply binarySearch on left subarray and right sub array
        int left = 0;
        int right = arr.length;
        return BSHelper(arr, elem, left, right - 1);
    }

    public boolean BSHelper(int[] arr, int elem, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == elem)
                return true;
            if (arr[mid] > elem)
                return BSHelper(arr, elem, left, mid - 1);
            else
                return BSHelper(arr, elem, mid + 1, right);
        }
        return false;
    }

    public static int binIter(int[] arr, int toFind) { // iterative
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int middle = (left + right) / 2;
            if(arr[middle] == toFind) return middle;
            else if(arr[middle] > toFind) right = middle -1;
            else left = middle + 1;
        }
        return -1;
    }

    public static int binIterTwo(int [] arr, int toFind){
        int left = 0;
        int right = arr.length - 1;
        if(toFind < arr[0]) return 0;
        if(toFind > arr[right]) return arr.length;
        while(left <= right){
            int mid = (left + right) / 2;
            if(toFind >= arr[mid] && toFind <= arr[mid + 1]) return mid + 1;
            if(toFind < arr[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public boolean linearSearch(int[] arr, int elem) {
        // linear seach is only used in order
        // to test binary and interpolation algorithms
        for (int i : arr) {
            if (i == elem)
                return true;
        }
        return false;
    }

    public boolean interpolationSearch(int[] arr, int elem) {
        return false;
    }
}