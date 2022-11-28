class Solution {
    public boolean canFinish(int n, int[][] graph) {
        
         int [] degree = new int[n];
        
       HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < graph.length; i++){
            
            degree[graph[i][1]] += 1; 
           
           int node = graph[i][0];
           int nbr = graph[i][1];
           
           if(map.containsKey(node)){
               map.get(node).add(nbr);
           } else {
               ArrayList<Integer> list = new ArrayList<>();
               list.add(nbr);
               map.put(node,list);
           }
            
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < degree.length; i++){
            
            if(degree[i] == 0){
                que.add(i);
            }
            
        }
        
        int count = 0;
        
        while(que.size() > 0){
            
            int node = que.remove();
            count++;
            
           if(map.containsKey(node)){
               
               for(int child : map.get(node)){
                
               degree[child] -= 1;
               
               if(degree[child] == 0){
                   que.add(child);
               }
                   
               }
               
           }
           
           
        }
        
        return count == n;
        
    }
    
}
        
