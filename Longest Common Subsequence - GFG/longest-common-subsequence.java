//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        
        int n = s1.length();
        int m = s2.length();
        
        int [][] dp = new int[n+1][m+1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                
                    int take = 0;
                    int notTake = 0;
                    
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                       dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                    
                    // dp[i][j] = Math.max(take,notTake);
                
            }
        }
        
        return dp[n][m];
        
        // for(int [] arr : dp){
        //     Arrays.fill(arr,-1);
        // }
        
        // return findLCS(s1,s2,n-1,m-1,dp);
        
        
    }
    
    private static int findLCS(String s1,String s2,int i, int j,int [][] dp){
        
        if(i == -1 || j == -1){
            return 0;
        }
        
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int match = 0;
        int dontMatch = 0;
        
        if(s1.charAt(i) == s2.charAt(j)){
            
            match = 1 + findLCS(s1,s2,i-1,j-1,dp);
            
        } else {
            
            dontMatch = Math.max(findLCS(s1,s2,i-1,j,dp) ,findLCS(s1,s2,i,j-1,dp));
            
        }
        
        return dp[i][j] = Math.max(match,dontMatch);
        
    }
    
}