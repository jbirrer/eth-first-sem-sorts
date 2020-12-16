package src;

public class EasySorts {
    public static void BubbleSort (int[] arr) {
        /*
        * idea: every iteration "bubbles" the largest element to the back
        */

        int length = arr.length;
        
        for(int i = 0; i< length; i++){
            for(int j = 0; j < length - i - 1; j++){
                if(arr[j] > arr[j+1]) {  //check if in wrong order, if so swap
                    int temp = arr[j];  //swap operation
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void InsertionSort(int[] arr){

    }

    public static void SelectionSort(int[] arr){
        /*
        * idea: in every iteration we look for the minimum element and bring it
        * to the end of the already sorted part
        */

        int length = arr.length;

        for(int i = 0;i < length; i++){ //INV(everything until index i is already sorted)
            int minIndex = i;
            int j = i;
            while(j < length){  //find smallest element after i
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            int temp = arr[i];  //swap operation
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
    }

    

    public static void main(String[] args) {
        int[] test1 = generateTest(100);
        int[] test2 = generateTest(100);



        BubbleSort(test1);
        SelectionSort(test2);


        System.out.println(testSorted(test1));
        System.out.println(testSorted(test2));
    }
    
    
    public static boolean testSorted(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    public static int[] generateTest(int length){
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }
}