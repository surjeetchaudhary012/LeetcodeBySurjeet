//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            
            int node = edges[i][0];
            int nbr = edges[i][1];
            
            graph.get(node).add(nbr);
            graph.get(nbr).add(node);
        }
        
       
        
        Queue<Pair> que = new ArrayDeque<>();
        boolean [] visited = new boolean[n];
        
        que.add(new Pair(src,0));
        
        int [] dist = new int[n];
        Arrays.fill(dist,1000000);
        
        dist[src] = 0;
        
        while(que.size() > 0){
            
            Pair startNode = que.remove();
            visited[startNode.node] = true;
            
            int wt = startNode.wsf;
            
            for(int nbr : graph.get(startNode.node)){
            
                if(visited[nbr] == false){
             
                 if(dist[nbr] > wt + 1){
                    dist[nbr] = wt + 1;
                }
                    
                  que.add(new Pair(nbr,dist[nbr]));
                }
                
            }
            
        }
        
        for(int i = 0; i < dist.length; i++){
            
            if(dist[i] == 1000000){
                dist[i] = -1;
            }
        }
        
        return dist;
        
    }
}

class Pair {
    int node;
    int wsf;
    
    Pair(int node, int wsf){
        this.node = node;
        this.wsf = wsf;
    }
    
    public String toString(){
        return node + "--:" + wsf;
    }
}