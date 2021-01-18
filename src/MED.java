package src;

import java.util.Arrays;

public class MED {
    public static void main(String[] args) {
        String a = "TIGER";
        String b = "ZIEGE";
        System.out.println(findMED(a, b, 1));
    }

    static int findMED(String a, String b, int cost){
        int[][] DP = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            DP[i][0] = i;
        }
        for (int i = 0; i <= b.length(); i++) {
            DP[0][i] = i;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    DP[i][j] = DP[i - 1][j - 1];
                } else {
                    DP[i][j] = Math.min(Math.min(DP[i - 1][j], DP[i][j - 1]), DP[i-1][j-1]) + cost;
                }
            }
        }
        System.out.println(Arrays.deepToString(DP));
        return DP[a.length()][b.length()];
    }
}
