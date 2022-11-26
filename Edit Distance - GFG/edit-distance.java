//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String word1, String word2) {
        
       int n = word1.length();
        int m = word2.length();
        
        int [][] dp = new int[n][m];
        
       for(int [] arr : dp){
           Arrays.fill(arr,Integer.MAX_VALUE);
       }
        
        return findDist(word1,word2,n-1,m-1,dp);
        
    }
    
    private int findDist(String word1,String word2, int i , int j , int [][] dp){
        
        if(i == -1){
            return j + 1;
        } 
        
       if(j == -1){
           return i + 1;
       }
        
        if(dp[i][j] < Integer.MAX_VALUE)  return dp[i][j];
        
      
        int notMatch = 0;
        
        if(word1.charAt(i) == word2.charAt(j)){
              notMatch = findDist(word1,word2,i-1,j-1,dp);
        } else {
            
            int replace = findDist(word1,word2,i-1,j-1,dp);
            int delete =  findDist(word1,word2,i-1,j,dp);
            int insert =  findDist(word1,word2,i,j-1,dp);
            
            notMatch = 1 +  Math.min(replace,Math.min(delete,insert));
        }
        
        return dp[i][j] = notMatch;
    }
}