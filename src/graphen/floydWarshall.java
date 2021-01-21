package src.graphen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class floydWarshall {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/graphen/floyd.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] edge_from_array = new int[m];
        int[] edge_to_array = new int[m];
        for (int i = 0; i < m; i++) {
            edge_from_array[i] = scan.nextInt();
            edge_to_array[i] = scan.nextInt();
        }
        AcyclicGraph G = new AcyclicGraph(n, m, edge_from_array, edge_to_array);
        doFloyd(G);
    }

    public static void doFloyd(AcyclicGraph G) {
        int[][][] FW = new int[G.n][G.n][G.n];

        for (int i = 0; i < G.n; i++) {
            for (int j = 0; j < G.n; j++) {
                for (int k = 0; k < G.n; k++) {
                    FW[i][j][k] = 10; // base case
                }
            }
        }
        for (int i = 0; i < G.n; i++) {
            FW[0][i][i] = 0;
        }
        for (int i = 0; i < G.n; i++) {
            for (int j = 0; j < G.out_degrees[i]; j++) {
                FW[0][i][G.out_edges[i][j]] = 1;
            }
        }
        for (int i = 1; i < G.n; i++) {
            for (int u = 0; u < G.n; u++) {
                for (int v = 0; v < G.n; v++) {
                    FW[i][u][v] = Math.min(FW[i - 1][u][v], FW[i - 1][u][i] + FW[i - 1][i][v]);
                }
            }
        }
        System.out.println(Arrays.deepToString(FW));

    }
}
