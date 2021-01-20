package src.graphen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijkstra {
    public static void main(String[] args) throws FileNotFoundException {
        // Uncomment the following two lines if you want to read from a file
        Scanner scan = new Scanner(new File("src/graphen/dijkstra2.txt"));
        int n=scan.nextInt();     // number of vertices
        int m=scan.nextInt();     // number of edges
        
        
        // The following two arrays stores the information of edges
        int[][] edge_array=new int[m][3];
        
        
        // Read edges
        for(int i=0;i<m;i++){
          edge_array[i][0]=scan.nextInt();  // one endpoint
          edge_array[i][1]=scan.nextInt();  // the other endpoint
          edge_array[i][2]=scan.nextInt();  // weight
        }
        
        
        GraphImpl G= new GraphImpl(n, m, edge_array);
        doDijkstra(G, 0);

        // In.close();
    }

    public static int[] doDijkstra(GraphImpl G, int start){ // does not work yet, i wonder why, i wonder how, lemon treeeeeeeeeeeeeeeEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE. Its working now halleluja
        int[] d = new int[G.n];
        int[] p = new int[G.n];
        for(int i = 0; i<d.length;i++){
            d[i] = Integer.MAX_VALUE;
            p[i] = Integer.MAX_VALUE;
        }
        d[start] = 0;
        p[start] = 0;
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>();
        Q.add(new Pair(start, 0));
        while(!Q.isEmpty()){
            Pair u = Q.poll();
            for(int i = 0; i < G.edges[u.index].length;i++){
                int v = G.edges[u.index][i];
                if(p[v]==Integer.MAX_VALUE){
                    d[v] = d[u.index] + G.weights[u.index][i];
                    p[v] = u.index;
                    Q.add(new Pair(v, d[v]));
                } else if(d[u.index] + G.weights[u.index][i] < d[v]){
                    d[v] = d[u.index] + G.weights[u.index][i];
                    p[v] = u.index;
                    Q.add(new Pair(v, d[v]));
                }
            }
        }
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(p));
        return d;
    }
}
