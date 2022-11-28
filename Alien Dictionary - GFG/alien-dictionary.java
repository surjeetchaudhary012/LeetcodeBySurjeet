//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int n, int k)
    {
       
       HashMap<Integer,Character> map = new HashMap<>();
       
       char ch = 'a';
       
       for(int i = 0; i < 26; i++){
           map.put(i,ch);
           ch++;
       }
       
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
       
       for(int i = 0; i < k; i++){
           
           graph.add(new ArrayList<>());
           
       }
        
        for(int i = 0; i < n - 1; i++){
            
            String one = dict[i];
            String two = dict[i+1];
            
            int kk = 0;
            int j = 0;
            
            while(kk < one.length() && j < two.length()){
                
                char ch1 = one.charAt(kk);
                char ch2 = two.charAt(j);
                
                if(ch1 != ch2){
                    
                    int node = ch1 - 'a';
                    int nbr = ch2 - 'a';
                    
                    graph.get(node).add(nbr);
                    break;
                    
                }
                
                kk++;
                j++;
                
            }
        }
        
          int [] degree = new int[k];
         
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
        
        // System.out.println(graph);
        
       String ans = "";
        
        while(que.size() > 0){
            
            int val = que.remove();
            
             ans += map.get(val);
            
            for(int node : graph.get(val)){
                degree[node] -= 1;
                
                if(degree[node] == 0){
                    que.add(node);
                }
             }
            
        }
        
        // System.out.println(ans);
        
        return ans;
        
    }
}