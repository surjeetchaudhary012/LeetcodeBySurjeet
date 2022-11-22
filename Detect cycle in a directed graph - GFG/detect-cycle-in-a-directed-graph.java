//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int n = V;
        
        int [] visited = new int[n];
    
        
        for(int i = 0; i < n; i++){
            
            if(visited[i] == 0){
                if(detectCycle(adj,i,visited)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
     private boolean detectCycle(ArrayList<ArrayList<Integer>> graph,int startNode, 
     int [] visited){
         
         visited[startNode] = 1;
         visited[startNode] += 1;
         
         for(int adjNode : graph.get(startNode)){
             
             if(visited[adjNode] == 0){
                 if(detectCycle(graph,adjNode,visited)){
                     return true;
                 }
             } else if (visited[adjNode] == 2){
                 return true;
             }
         }
         
         visited[startNode] -= 1;
         return false;
     }
}