import java.io.File;
import java.util.Scanner;

public class julia {
    public static void main(String[] args) {
        Scanner scannerForFile = new Scanner(new File(".src/graphen/julia.txt")); //list ganzes dokument

        while(scannerForFile.hasNextLine()){ 
            Scanner lineScanner = new Scanner(scannerForFile.nextLine()); //liest nächste zeile
            lineScanner.nextDouble(); // lese tokens der zeile
        }
    }
}
