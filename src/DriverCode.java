package src;

public class DriverCode {
    public static void main(String[] args) {
        int[] test1 = generateTest(100);
        int[] test2 = generateTest(100);
        EasySorts easySorts = new EasySorts();
        easySorts.BubbleSort(test1);
        easySorts.SelectionSort(test2);

        System.out.println(testSorted(test1));
        System.out.println(testSorted(test2));
    }

    public static boolean testSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static int[] generateTest(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }
}
