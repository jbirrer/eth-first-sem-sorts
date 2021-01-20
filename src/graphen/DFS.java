package src.graphen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
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
        System.out.println(DFSi(G, 0, 1));
    }

    public static boolean DFSi(AcyclicGraph G, int start, int target) { // todo: post order
        boolean[] visited = new boolean[G.n];
        int[] preOrder = new int[G.n];
        int[] postOrder = new int[G.n];
        Stack<Integer> S = new Stack<Integer>();
        S.push(start);
        int index = 0;
        int indix = 0;
        while (!S.isEmpty()) {
            int w = S.pop();
            boolean post = false;
            if (!visited[w]) {
                visited[w] = true;
                preOrder[index++] = w;
                if (G.out_edges[w] != null) {
                    for (int i = 0; i < G.out_edges[w].length; i++) {
                        int x = G.out_edges[w][i];
                        if (!visited[x]) {
                            S.push(x);
                            post = true;
                        }
                    }
                }
                if(!post){
                    postOrder[indix++] = w;
                }
                post = false;
            }
        }
        System.out.println(Arrays.toString(preOrder));
        System.out.println(Arrays.toString(postOrder));
        return visited[target] ? true : false;
    }
}
