package src;

import java.util.Arrays;

public class LAT {
    public static void main(String[] args) {
        int[] dp = { 4, 9, 32, 13, 10, 11, 7, 3, 16 };
        System.out.println(findLAT(dp));
    }

    static String findLAT(int[] arr) {
        int[] lat = new int[arr.length];
        int k = 0;
        lat[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lat[k]) {
                lat[k + 1] = arr[i];
                k++;
            } else {
                int p = k;
                while (arr[i] < lat[p]) {
                    p--;
                    if (p < 0)
                        break;
                }
                lat[p + 1] = arr[i];
            }
        }

        return Arrays.toString(lat);
    }
}
