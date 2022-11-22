class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int v = graph.length;
        
         int [] visited = new int[v];
      
        for(int i = 0; i < v; i++){
            
            if(visited[i] == 0){
                
                visited[i] = 1;
                
                  boolean ans =  dfs(i,1,graph,visited);
                  
                  if(ans == false){
                      return false;
                  }
                
            }
            
        }
        
        return true;
        
    }
    
    private boolean dfs(int start,int color,int [][] adj,int [] visited){
        
        for(int node : adj[start]){
            
            if(visited[node] == 0){
                
                 int clr = color == 1 ? 2 : 1;
                 visited[node] = clr;
                 
                 boolean ans = dfs(node,clr,adj,visited);
                 
                 if(ans == false){
                     return false;
                 }
                 
            } else if (visited[node] == visited[start]){
                return false;
            }
            
        }
       
        return true;
    }
}
 