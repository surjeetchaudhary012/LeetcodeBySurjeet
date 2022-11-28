class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        
        int n = adj.length;
        
     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        
        
        for(int i = 0; i < adj.length; i++){
            
           for(int val : adj[i]){
               graph.get(val).add(i);
           }
            
        }
        
          

        int [] degree = new int[n];
        
        for(int i = 0; i < graph.size(); i++){
            
            for(int val : graph.get(i)){
                degree[val] += 1;
            }
            
        }
        
      
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < degree.length; i++){
            
            if(degree[i] == 0){
                que.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(que.size() > 0){
            
            int val = que.remove();
            ans.add(val);
            
            for(int node : graph.get(val)){
                degree[node] -= 1;
                
                if(degree[node] == 0){
                    que.add(node);
                }
             }
            
        }
        
         Collections.sort(ans);
         
         return ans;
        
    }
}