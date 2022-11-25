//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s)
    {
       int n = s.length();
       int [][] dp = new int[n][n];
       
       for(int [] a : dp){
           Arrays.fill(a,-1);
       }
       
       return  findLPS(s,0,n-1,dp);
    }
    
    private int findLPS(String s , int start, int end, int [][] dp){
        
        if(start > end){
            return 0;
        }
        
        if(start == end){
            return 1;
        }
        
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        
        int match = 0;
        int notMatch = 0;
        
        if(s.charAt(start) == s.charAt(end)){
            match = 2 + findLPS(s,start + 1,end - 1,dp);
        } else {
            notMatch = Math.max(findLPS(s,start + 1,end,dp),findLPS(s,start,end - 1,dp));
        }
        
        return dp[start][end] =  Math.max(match,notMatch);
    }
}