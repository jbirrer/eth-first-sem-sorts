package src;

import java.util.Scanner;

public class ohneSieben {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        int i = 0;
        int j = input;

        String sum1 = "" + i;
        String sum2 = "" + input;

        while (sum1.contains("7") || sum2.contains("7")) {
            i++;
            sum1 = "" + i;
            j--;
            sum2 = "" + j;
        }

        

        

        System.out.println(sum1 + " " + sum2);
    }

}


