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
        
        HashSet<Integer> set = new HashSet<>();
        
        
        int mod = 100000;
        
        que.add(new Node(start,0));
        set.add(start);
        
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
               
                 if(set.contains(num)){
                     continue;
                 }
                 
                 if(set.size() >= mod){
                     return -1;
                 }
                 
                 set.add(num);
                 que.add(new Node(num,count + 1));
                
            }
        }
 
      return -1;
    }
}

class Node {
    int val;
    int count;
    
    Node(int val , int count){
        this.val = val;
        this.count = count;
    }
}
