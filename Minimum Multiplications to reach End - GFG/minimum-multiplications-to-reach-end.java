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
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        
        Queue<Node> que = new ArrayDeque<>();
        
       int [] dist = new int[100000];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[start] = 0;
        
        int mod = 100000;
        
        que.add(new Node(start,0));
        
        while(que.size() > 0){
            
            Node node = que.remove();
            int val = node.val;
            int count = node.count;
            
            for(int i = 0; i < arr.length; i++){
                
                int num = val * arr[i];
                
                num = num % mod;
                
                 if(num == end){
                     return count + 1;
                 }
               
               if(dist[num] > dist[val] + 1){
                   dist[num] = dist[val] + 1;
                   que.add(new Node(num,count + 1));
               }
              
            }
        }
 
      return -1;
    }
}


