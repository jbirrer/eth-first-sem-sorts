package src;

public class DriverCode {
    public static void main(String[] args) {
        int[] test1 = generateTestSorting(100);
        int[] test2 = generateTestSorting(100);
        int[] test3 = generateTestSorting(100);

        EasySorts easySorts = new EasySorts();
        Search search = new Search();

        easySorts.BubbleSort(test1);
        easySorts.SelectionSort(test2);
        HeapSortImpl.heapSort(test3);

        int searchTester = (int) (Math.random() * 1000);

        System.out.println(search.binarySearch(test1, searchTester) == search.linearSearch(test1, searchTester));
        System.out.println(search.binarySearch(test2, searchTester) == search.linearSearch(test2, searchTester));

        System.out.println(testSorted(test1));
        System.out.println(testSorted(test2));
        System.out.println(testSorted(test3));
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
