package src.graphen;

public class AcyclicGraph{
  
    public int n;              // number of vertices
    public int m;              // number of edges
    public int[] out_degrees;  // out_degrees[i]: the out-degree of vertex i
    public int[][] out_edges;  // out_edges[i][j]: the j-th out_edge of vertex i
    
    
    
    AcyclicGraph(int n, int m, int[] edge_from_array, int[] edge_to_array)
    {
      this.n=n;
      this.m=m;
      out_degrees=new int[n];
      for(int i=0;i<n;i++)
        out_degrees[i]=0;
      for(int i=0;i<m;i++)
        out_degrees[edge_from_array[i]]++;
      out_edges=new int[n][];
        
      for(int i=0;i<n;i++)
      {
        if(out_degrees[i]!=0)
        {
          out_edges[i]=new int[out_degrees[i]];
          out_degrees[i]=0;
        }
        else
        {
          out_edges[i]=null;
        }
      }
      
      for(int i=0;i<m;i++)
        out_edges[edge_from_array[i]][out_degrees[edge_from_array[i]]++]=edge_to_array[i];
    }}
