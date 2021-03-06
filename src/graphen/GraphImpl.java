package src.graphen;

class GraphImpl{
  
    public int n;              // number of vertices
    public int m;              // number of edges
    public int[] degrees;      // degrees[i]: the degree of vertex i
    public int[][] edges;      // edges[i][j]: the endpoint of the j-th edge of vertex i
    public int[][] weights;    // weights[i][j]: the weight of the j-th edge of vertex i
    
  
    
    public GraphImpl(int n, int m, int[][] edge_array){
      this.n=n;
      this.m=m;
      degrees=new int[n];
      
      for(int i=0;i<n;i++){
        degrees[i]=0;
      }
     
      for(int i=0;i<m;i++){
        degrees[edge_array[i][0]]++;
        degrees[edge_array[i][1]]++;
      }
      
      edges=new int[n][];
      weights=new int[n][];
        
      for(int i=0;i<n;i++){
        if(degrees[i]!=0){
          edges[i]=new int[degrees[i]];
          weights[i]=new int[degrees[i]];
          degrees[i]=0;
        }
        else{
          edges[i]=null;
          weights[i]=null;
        }
      }
      
      for(int i=0;i<m;i++){
        edges[edge_array[i][0]][degrees[edge_array[i][0]]]=edge_array[i][1];
        edges[edge_array[i][1]][degrees[edge_array[i][1]]]=edge_array[i][0];
        weights[edge_array[i][0]][degrees[edge_array[i][0]]]=edge_array[i][2];
        weights[edge_array[i][1]][degrees[edge_array[i][1]]]=edge_array[i][2];
        degrees[edge_array[i][0]]++;
        degrees[edge_array[i][1]]++;
      } 
    }
}
