//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] list)
    {
        
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
    
    //   System.out.println(graph);

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