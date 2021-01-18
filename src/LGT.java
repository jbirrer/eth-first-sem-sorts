package src;

import java.util.Arrays;

public class LGT {
    public static void main(String[] args) {
        String a = "TIGER";
        String b = "ZIEGE";
        System.out.println(findLGT(a, b));
    }

    private static int findLGT(String a, String b) {
        int[][] DP = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length(); i++) {
            DP[i][0] = 0;
        }
        for (int i = 0; i < b.length(); i++) {
            DP[0][i] = 0;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        return DP[a.length()][b.length()];
    }

}
