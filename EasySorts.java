public class EasySorts {
    public static void BubbleSort (int[] arr) {
        int length = arr.length;
        
        for(int i = 0; i< length; i++){
            for(int j = 0; j < length - i - 1; j++){
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void InsertionSort(int[] arr){

    }

    public void SelectionSort(int[] arr){
        
    }

    

    public static void main(String[] args) {
        int[] test1 = new int[5];

        for(int i = 0; i < test1.length; i++){
            test1[i] = test1.length -i;
        }

        int[] test2 = test1;


        BubbleSort(test1);
        System.out.println(testSorted(test1));
    }
    
    
    public static boolean testSorted(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}