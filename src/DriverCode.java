package src;



public class DriverCode {
    public static void main(String[] args) {
        int[] test1 = generateTestSorting(100);
        int[] test2 = generateTestSorting(100);
        int[] test3 = generateTestSorting(100);
        int[] test4 = generateTestSorting(100);
        int[] test5 = { 12, 24, 36, 37, 38, 90 };
        int[] test6 = generateTestSorting(100);
        int[] test8 = { 12, 2, 8, 37, 380, 90 };

        EasySorts easySorts = new EasySorts();
        Search search = new Search();

        easySorts.BubbleSort(test1);
        easySorts.SelectionSort(test2);
        HeapSortImpl.heapSort(test3);
        MediumSorts.MergeSort(test4, 0, test4.length-1);
        easySorts.InsertionSort(test6);
        MediumSorts.QuickSort(test8, 0, test8.length-1);

        int searchTester = (int) (Math.random() * 1000);

        System.out.println(search.binarySearch(test1, searchTester) == search.linearSearch(test1, searchTester));
        System.out.println(search.binarySearch(test2, searchTester) == search.linearSearch(test2, searchTester));

        System.out.println(testSorted(test1));
        System.out.println(testSorted(test2));
        System.out.println(testSorted(test3));
        System.out.println(testSorted(test4));
        System.out.println(testSorted(test6));
        System.out.println(testSorted(test8));

        System.out.println(Search.binIterTwo(test5, 13));
    }

    public static boolean testSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static int[] generateTestSorting(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

}
