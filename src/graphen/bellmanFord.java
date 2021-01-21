package src.graphen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class bellmanFord {
    public static void main(String[] args) throws FileNotFoundException {
        // Uncomment the following two lines if you want to read from a file
        Scanner scan = new Scanner(new File("src/graphen/bellmanFord.txt"));
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
       // System.out.println(Arrays.toString(doBellmanFord(G, 0)));
        doBellmanFord(G, 0);

        // In.close();
    }

    public static int[] doBellmanFord(GraphImpl G, int start){ //does not work, because I implemented it with unweighted edges :clown:
        int[] d = new int[G.n]; //distance
        int[] p = new int[G.n]; //parent
    
        for(int i = 0; i < G.n; i++){
            d[i] = Integer.MAX_VALUE;
        }

        d[start] = 0;

        for(int i = 0; i < G.n; i++){ // do for every edge
            for (int u = 0; u < G.edges.length; u++) {
                if (G.edges[u] != null) {
                    for (int j = 0; j < G.edges[u].length; j++) {
                        int v = G.edges[u][j];
                        if((d[v] > d[u] + G.weights[u][j])){
                            d[v] = d[u] + G.weights[u][j];
                            p[v] = u;
                        }
                    }
                }
            }

        }
        for (int k = 0; k < G.edges.length; k++) {
            if (G.edges[k] != null) {
                for (int j = 0; j < G.edges[k].length; j++) {
                    int w = G.edges[k][j];
                    if(d[w] > d[k] + G.weights[k][j]){
                        return null;
                    }
                }
            }
        }
        return d;
    }
}
