package src.graphen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class topoSort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/graphen/topo.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] edge_from_array = new int[m];
        int[] edge_to_array = new int[m];
        for (int i = 0; i < m; i++) {
            edge_from_array[i] = scan.nextInt();
            edge_to_array[i] = scan.nextInt();
        }
        AcyclicGraph G = new AcyclicGraph(n, m, edge_from_array, edge_to_array);
        System.out.println(Arrays.toString(topologicalSort(G)));
    }

    public static int[] topologicalSort(AcyclicGraph G) {
        Stack<Integer> S = new Stack<Integer>();

        int[] indegs = new int[G.n];
        int[] ord = new int[G.n];

        for (int i = 0; i < G.out_edges.length; i++) {
            if (G.out_edges[i] != null) {
                for (int j = 0; j < G.out_edges[i].length; j++) {
                    int wh = G.out_edges[i][j];
                    indegs[wh] = indegs[wh] + 1;
                }
            }
        }
        for (int i = 0; i < G.n; i++) {
            if (indegs[i] == 0) {
                S.push(i);
            }
        }
        int i = 0;
        while (!S.isEmpty()) {
            int v = S.pop();
            ord[i] = v;
            i++;
            if (G.out_edges[v] != null) {
                for (int j = 0; j < G.out_edges[v].length; j++) {
                    int k = G.out_edges[v][j];
                    indegs[k] = indegs[k] - 1;
                    if (indegs[k] == 0) {
                        S.push(k);
                    }
                }
            }
        }
        if (i == G.n)
            return ord;
        else
            return null;
    }

}
