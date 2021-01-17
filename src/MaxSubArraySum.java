package src;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] test = { 7, -11, 15,110, -23, -3, 127, -12, 1 };
        System.out.println(MSASInductive(test));
    }

    static int MSASInductive(int[] arr) {
        int randmax = 0;
        int maxS = 0;
        for (int i = 0; i < arr.length; i++) {
            randmax += arr[i];
            if(randmax > maxS) maxS = randmax;
            if(randmax < 0) randmax = 0;
        }
        return maxS;
    }

}
