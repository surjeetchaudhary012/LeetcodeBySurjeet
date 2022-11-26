class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        int [] dp = new int[m+1];
        
        for(int j = 0; j <= m; j++){
            dp[j] = j;
        }
        
        for(int i = 1; i <= n; i++){
            
            int [] curr = new int[m + 1];
            
            curr[0] = i;
            
            for(int j = 1; j <= m; j++){
                
               if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] =  dp[j-1];
                } else {
                    
                   curr[j] = 1 + Math.min(dp[j],Math.min(dp[j-1],curr[j-1]));
                }
                
            }
            
            dp = curr;
        }
         
        return dp[m];
        
    }
    
}
    
   