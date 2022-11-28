//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int n, List<List<Integer>> adj) {
        
      
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < adj.size(); i++){
            
           for(int val : adj.get(i)){
               graph.get(val).add(i);
           }
            
        }
        
        //   System.out.println(graph);

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
