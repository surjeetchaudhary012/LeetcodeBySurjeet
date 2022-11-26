class Solution {
    public int numDistinct(String s, String t) {
        
      int n = s.length();
	  int m = t.length();
        
        int mod = 1000000000  + 7;
	  
	  int [][] dp = new int[n+1][m+1];
        
        for(int i = 0; i < n; i++){
            dp[i][0]  = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                
                int match = 0;
                int notMatch = 0;
                
                if(s.charAt(i-1) == t.charAt(j-1)){
                     match  = (dp[i-1][j-1] + dp[i-1][j]);
                }  else {
                    notMatch = dp[i-1][j] %  mod;
                }
                
                dp[i][j] = (match + notMatch) % mod;
            }
        }
        
    return dp[n][m];
	  
    }
}
    
   