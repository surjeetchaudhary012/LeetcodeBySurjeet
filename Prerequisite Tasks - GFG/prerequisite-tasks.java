//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int n, int[][] graph)
    {
        
        int [] degree = new int[n];
        
       HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < graph.length; i++){
            
            degree[graph[i][1]] += 1; 
           
           int node = graph[i][0];
           int nbr = graph[i][1];
           
           if(map.containsKey(node)){
               map.get(node).add(nbr);
           } else {
               ArrayList<Integer> list = new ArrayList<>();
               list.add(nbr);
               map.put(node,list);
           }
            
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < degree.length; i++){
            
            if(degree[i] == 0){
                que.add(i);
            }
            
        }
        
        int count = 0;
        
        while(que.size() > 0){
            
            int node = que.remove();
            count++;
            
           if(map.containsKey(node)){
               
               for(int child : map.get(node)){
                
               degree[child] -= 1;
               
               if(degree[child] == 0){
                   que.add(child);
               }
                   
               }
               
           }
           
           
        }
        
        return count == n;
        
    }
    
}