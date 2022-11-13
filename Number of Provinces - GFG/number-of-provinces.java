//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int n) {
        
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
    
    
    private static void dfs(int startNode , ArrayList<ArrayList<Integer>> arr, boolean [] visited, int n){
        
        
        visited[startNode] = true;
        
       for(int i = 0; i < n; i++){
           
           if(arr.get(startNode).get(i) == 1){
               
               if(visited[i] == false){
                   
                     dfs(i,arr,visited,n);
                     
               }
              
           }
           
       }
        
    }
    
};