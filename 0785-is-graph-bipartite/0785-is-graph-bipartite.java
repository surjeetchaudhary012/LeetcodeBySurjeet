class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int v = graph.length;
        
         int [] visited = new int[v];
         Queue<Pair> que = new ArrayDeque<>();
        
        for(int i = 0; i < v; i++){
            
            if(visited[i] == 0){
                que.add(new Pair(i,1));
            }
            
          boolean ans =  bfs(graph,v,que,visited);
          
          if(ans == false){
              return false;
          }
               
        }
        
        return true;
        
    }
    
    private boolean bfs(int [][] adj,int v,Queue<Pair> que,int [] visited){
        
        while(que.size() > 0){
            
                Pair p = que.remove();
                
               int color = p.color;
               int node = p.node;
                
                for(int val : adj[node]){
                    
                    if(visited[val] == 0){
                        
                        int clr = color == 1 ? 2 : 1;
                        visited[val] = clr;
                        que.add(new Pair(val,clr));
                        
                    } else if(visited[val] == color){
                       return false;
                    }
                }
        }
        
        return true;
    }
}

class Pair {
    int node;
    int color;
    
    Pair(int node, int color){
        this.node = node;
        this.color = color;
    }
}
 