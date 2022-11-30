//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            
            int node = edges[i][0];
            int nbr = edges[i][1];
            int wt = edges[i][2];
            
            graph.get(node).add(new Pair(nbr,wt));
            graph.get(nbr).add(new Pair(node,wt));
            
        }
        
        int src = 1;
        int target = n;
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            
             if(a.wt == b.wt){
                 return a.nbr - b.nbr;
             }
             
             return a.wt - b.wt;
        });
        
        pq.add(new Pair(src,0));
       
    
        int [] dist = new int[n+1];
        
        int [] arr = new int[n+1];
        
        Arrays.fill(dist,10000000);
        
         dist[src] = 0;
        
    
        while(pq.size() > 0){
            
            Pair p = pq.remove();
            
            int startNode = p.nbr;
            int wsf = p.wt;
        
            for(Pair rem : graph.get(startNode)){
                
                int node = rem.nbr;
                int wt = rem.wt;
                
                 if(dist[node] > wsf + wt){
                     
                   dist[node] = wsf + wt;
                   pq.add(new Pair(node,dist[node]));
                   
                   arr[node] = startNode;
                   
               }
                
            }
            
        }
        
        List<Integer> list = new ArrayList<>();
        
         if(dist[target] == 10000000){
             list.add(-1);
             return list;
         }
         
         int node = target;
         
         while(arr[node] != node){
             list.add(node);
             node = arr[node];
             
             if(node == 0){
                 break;
             }
         }
         
         Collections.reverse(list);
         
         return list;
        
    }
}

class Pair {
    int nbr; 
    int wt;
    
    Pair(int nbr, int wt){
        this.nbr = nbr;
        this.wt = wt;
    }
}