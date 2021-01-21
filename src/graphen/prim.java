package src.graphen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class prim {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner In = new Scanner(new File("./src/graphen/prim.txt"));

        int n = In.nextInt(); // number of vertices
        int m = In.nextInt(); // number of edges

        // The following two arrays stores the information of edges
        int[][] edge_array = new int[m][3];

        // Read edges
        for (int i = 0; i < m; i++) {
            edge_array[i][0] = In.nextInt(); // one endpoint
            edge_array[i][1] = In.nextInt(); // the other endpoint
            edge_array[i][2] = In.nextInt(); // weight
        }

        Graph G = new Graph(n, m, edge_array);
        doPrim(G, 0);

    }

    public static void doPrim(Graph G, int start) { //does not work yet
        PriorityQueue<Pair> H = new PriorityQueue<Pair>();
        LinkedList<Integer> S = new LinkedList<Integer>();
        int[] d = new int[G.n];

        for (int i = 0; i < G.n; i++) {
            d[i] = Integer.MAX_VALUE;
            H.add(new Pair(i, Integer.MAX_VALUE));
        }

        d[start] = 0;

        H.add(new Pair(start, 0));

        while (!H.isEmpty()) {
            int v = H.poll().index;
            S.add(v);
            for (int e = 0; e < G.degrees[v]; e++) {
                int vstar = G.edges[v][e];
                if (!S.contains(vstar)) {
                    d[vstar] = Math.min(d[vstar], G.weights[v][e]);
                    H.add(new Pair(vstar, d[vstar]));
                }
                
            }
        }
        System.out.println(Arrays.toString(d));
    }
}
