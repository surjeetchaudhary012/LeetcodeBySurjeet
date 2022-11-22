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
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < v; i++){
            
            if(visited[i] == 0){
                que.add(i);
            }
            
          boolean ans =  bfs(adj,v,que,visited);
          
          if(ans == false){
              return false;
          }
            
           
        }
        
        return true;
        
    }
    
    private boolean bfs(ArrayList<ArrayList<Integer>> adj,int v,Queue<Integer> que,int [] visited){
        
        while(que.size() > 0){
            
                int node = que.remove();
                
                for(int val : adj.get(node)){
                    
                    if(visited[val] == 0){
                        
                        int clr = visited[node] == 1 ? 2 : 1;
                        visited[val] = clr;
                        que.add(val);
                        
                    } else if(visited[val] == visited[node]){
                       return false;
                    }
                }
        }
        
        return true;
    }
}

