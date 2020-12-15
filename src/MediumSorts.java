package src;

public class MediumSorts {
    
    public void MergeSort(int[] arr){

    }

    public void QuickSort(int[] arr){
        
    }


    public static void main(String[] args) {
        int[] test1 = new int[5];

        for(int i = 0; i < test1.length; i++){
            test1[i] = test1.length -i;
        }

        int[] test2 = test1;


        
        System.out.println(testSorted(test1));
    }
    
    
    public static boolean testSorted(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}