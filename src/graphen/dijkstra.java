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
        Scanner scan = new Scanner(new File("src/graphen/dijkstra.txt"));
        

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
        System.out.println(Arrays.toString(doDijkstra(G, 0)));

        //System.out.println(G.m);
        //System.out.println(G.n);
        //System.out.println(Arrays.toString(G.degrees));
        //System.out.println(Arrays.deepToString(G.edges));
        //System.out.println(Arrays.deepToString(G.weights));

        // Uncomment the following line if you want to read from a file
        // In.close();
    }

    public static int[] doDijkstra(GraphImpl G, int start){ // does not work yet
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
        ArrayList<Integer> S = new ArrayList<Integer>();

        int[] d = new int[G.n];
        d[start] = 0;

        for(int i = 0; i < G.n; i++){
            if(i!=start){
                d[i] = Integer.MAX_VALUE;
            }
        }
        
        heap.add(new Pair(start, 0));

        while(S.size()!=G.n){
            int v = heap.remove().index;
            S.add(v);
            for(int i = 0; i < G.edges[v].length;i++){
                d[G.edges[v][i]] = Math.min(d[G.edges[v][i]], d[v] + G.weights[G.edges[v][i]][v]);
                heap.add(new Pair(i, d[i]));
            }
        }
        return d;
    }
}
