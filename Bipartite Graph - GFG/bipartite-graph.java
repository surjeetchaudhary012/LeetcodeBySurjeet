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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        
        int [] visited = new int[v];
      
        for(int i = 0; i < v; i++){
            
            if(visited[i] == 0){
                
                visited[i] = 1;
                
                  boolean ans =  dfs(i,1,adj,visited);
                  
                  if(ans == false){
                      return false;
                  }
                
            }
            
        }
        
        return true;
        
    }
    
    private boolean dfs(int start,int color,ArrayList<ArrayList<Integer>> adj,int [] visited){
        
         visited[start] = color;
        
        for(int node : adj.get(start)){
            
            if(visited[node] == 0){
                
                 int clr = color == 1 ? 2 : 1;
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

