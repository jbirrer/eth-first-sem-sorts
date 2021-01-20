package src.graphen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/graphen/DFS.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] edge_from_array = new int[m];
        int[] edge_to_array = new int[m];
        for (int i = 0; i < m; i++) {
            edge_from_array[i] = scan.nextInt();
            edge_to_array[i] = scan.nextInt();
        }
        AcyclicGraph G = new AcyclicGraph(n, m, edge_from_array, edge_to_array);
        System.out.println(BFSi(G, 0, 1));
    }

    public static boolean BFSi(AcyclicGraph G, int start, int target) {
        LinkedList<Integer> Q = new LinkedList<Integer>();
        boolean[] visited = new boolean[G.n];
        boolean[] active = new boolean[G.n];
        active[start] = true;
        Q.add(start);
        while (!Q.isEmpty()) {
            int w = Q.poll();
            visited[w] = true;
            if (G.out_edges[w] != null) {
                for (int i = 0; i < G.out_edges[w].length; i++) {
                    int x = G.out_edges[w][i];
                    if (!visited[x] && !active[x]) {
                        active[x] = true;
                        Q.add(x);
                    }
                }
            }
        }
        return visited[target] ? true : false;
    }
}
