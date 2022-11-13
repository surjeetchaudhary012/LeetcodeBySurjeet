class Solution {
    public int findCircleNum(int[][] adj) {
        
        int n = adj.length;
        
          int ans = 0;
        
        boolean [] visited = new boolean [n];
        
        for(int i = 0; i < n; i++){
            
            if(visited[i] == false){
                
                dfs(i,adj,visited,n);
                ans += 1;
                
            }
            
        }
        
        return ans;
    }
    
     private static void dfs(int startNode , int [][] arr, boolean [] visited, int n){
        
        
        visited[startNode] = true;
        
       for(int i = 0; i < n; i++){
           
           if(arr[startNode][i] == 1){
               
               if(visited[i] == false){
                   
                     dfs(i,arr,visited,n);
                     
               }
              
           }
           
       }
        
    }
}