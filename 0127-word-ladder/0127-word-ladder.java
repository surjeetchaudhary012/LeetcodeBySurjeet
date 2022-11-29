class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        
        String [] list = new String[wordList.size()];
        
        for(int i = 0; i< list.length; i++){
            list[i] = wordList.get(i);
        }
        
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < list.length; i++){
            graph.add(new ArrayList<Integer>());
        }

        int src = -1;
        int target = -1;
        
        for(int i = 0; i < list.length; i++){
            
              String word1 = list[i];
              int m = word1.length();
              
              if(word1.equals(startWord)){
                  src = i;
              }
              
              if(word1.equals(targetWord)){
                  target = i;
              }
            
            for(int j = 0; j < list.length; j++){
                
                int diff = 0;
                String word2 = list[j];
                
                for(int k = 0; k < m; k++){
                    
                    if(word1.charAt(k) != word2.charAt(k)){
                        diff++;
                    }
                }
                
                if(diff == 1){
                graph.get(i).add(j);
                }
                
            }
            
        }
        
        if(src == -1){
            
            graph.add(new ArrayList<Integer>());
            
              String word1 = startWord;
              int m = word1.length();
              src = graph.size() - 1;
             
            for(int j = 0; j < list.length; j++){
                
                int diff = 0;
                String word2 = list[j];
                
                for(int k = 0; k < m; k++){
                    
                    if(word1.charAt(k) != word2.charAt(k)){
                        diff++;
                    }
                }
                
                if(diff == 1){
                    
                    graph.get(src).add(j);
                    graph.get(j).add(src);
                    
                }
                
            }
        }


        int n = graph.size();    
        boolean [] visited = new boolean[n];
        
        Queue<Integer> que = new ArrayDeque<>();
        
        que.add(src);
        int level = 0;
        
        while(que.size() > 0){
            
            int size = que.size();
        
            while(size-- > 0){
            
                int startNode = que.remove();
                 
                if(target == startNode){
                   return level + 1;
                }
                
                visited[startNode] = true;
                
                 for(int node : graph.get(startNode)){
                     
                     if(visited[node] == false){
                         que.add(node);
                     }
                     
                 }
            }
            
             level++;
        }
        
        return 0;
    }
}