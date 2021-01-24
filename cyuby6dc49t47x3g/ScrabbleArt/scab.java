package cyuby6dc49t47x3g.ScrabbleArt;

import java.util.Scanner;

public class scab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        name = name.toUpperCase();
        String b = "   ";
        for (int i = 0; i < name.length()-3; i++) {
            b += "    ";
        }
        for (int i = 0; i < name.length()-1; i++) {
            System.out.print("+---");
        }
        System.out.print("+---+");
        System.out.println();
        for (int i = 0; i < name.length()-1; i++) {
            System.out.print("| "+name.charAt(i) + " ");
        }
        System.out.print("| " + name.charAt(name.length()-1) + " |");
        System.out.println();
        for (int i = 0; i < name.length()-1; i++) {
            System.out.print("+---");
        }
        System.out.print("+---+");
        System.out.println();

        for(int i = 1; i < name.length()-2;i++){
            System.out.print("| " + name.charAt(i)+ " |");
            System.out.print(b);
            System.out.print("| " + name.charAt(name.length()-i-1)+ " |");
            System.out.println();
            System.out.print("+---+");
            System.out.print(b);
            System.out.print("+---+");
            System.out.println();
        }
        System.out.print("| " + name.charAt(name.length()-2)+ " |");
            System.out.print(b);
            System.out.print("| " + name.charAt(1)+ " |");
            System.out.println();
            
            for (int i = 0; i < name.length()-1; i++) {
                System.out.print("+---");
            }
            System.out.print("+---+");
            System.out.println();

            for (int i = 0; i < name.length()-1; i++) {
                System.out.print("| "+name.charAt(name.length()-i-1) + " ");
            }
            System.out.print("| " + name.charAt(0) + " |");
            System.out.println();
            for (int i = 0; i < name.length()-1; i++) {
                System.out.print("+---");
            }
            System.out.print("+---+");
        //-----------------------------------------------

        

        

    }
}