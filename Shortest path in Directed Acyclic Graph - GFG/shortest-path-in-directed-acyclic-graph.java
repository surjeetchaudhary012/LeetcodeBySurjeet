//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
	    
	    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
	    
	    for(int i = 0; i < n; i++){
	        graph.add(new ArrayList<>());
	    }
	    
	    for(int i = 0;  i < edges.length; i++){
	        graph.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	    }
		
		Stack<Integer> st = new Stack<>();
		
		boolean [] visited = new boolean[n];
		
		for(int i = 0; i < n; i++){
		    
		    if(visited[i] == false){
		        findTopologicalSort(i,graph,st,visited);
		    }
		}
		
		int [] dist = new int[n];
		
		Arrays.fill(dist,(int)1e9);
		
		dist[0] = 0;

       while(st.size() > 0){
           
           int node = st.pop();
           
           for(Pair child : graph.get(node)){
               
               if(dist[child.nbr] > dist[node] + child.wt){
                   dist[child.nbr] = dist[node] + child.wt;
               }
               
           }
       }
       
       for(int i = 0; i < dist.length; i++){
           
           if(dist[i] == 1e9){
               dist[i] = -1;
           }
       }
		
	 return dist;
		
	}
	
	private void findTopologicalSort(int startNode, ArrayList<ArrayList<Pair>> graph , Stack<Integer> st , boolean [] visited){
	    
	    visited[startNode] = true;
	    
	  for(Pair node : graph.get(startNode)){
	      
	      if(visited[node.nbr] == false){
	          findTopologicalSort(node.nbr,graph,st,visited);
	      }
	  }
	  
	  st.push(startNode);
	    
	}
}

class Pair {
    int nbr ; 
    int wt;
    
    Pair(int nbr, int wt){
        this.nbr = nbr;
        this.wt = wt;
    }
}