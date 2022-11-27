class Solution {
    public boolean isMatch(String s, String pattern) {
        
           int  n = s.length();
        int m = pattern.length();
        
      boolean [][] dp  = new boolean[n+1][m+1];
      
      dp[0][0] = true;
      
      for(int j = 1; j <= m; j++){
          boolean flag = true;
          
          for(int i = 1; i <= j; i++){
              
              if(pattern.charAt(i-1) != '*'){
                  flag = false;
                  break;
              }
              
             dp[0][i] = flag;
             
          }
      }
      
         for(int i = 1; i <= n; i++){
             for(int j = 1; j <= m; j++){
             
                 if(s.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                     dp[i][j] = dp[i-1][j-1];
                         
                 } else if(pattern.charAt(j-1) == '*'){
                     dp[i][j] = dp[i-1][j] || dp[i][j-1];
                 } 
                 
             }
         }
         
         
         return dp[n][m];
        
    }
    
    private int find(String s , String pattern, int i , int j, int [][] dp){
        
        if(i == s.length() && j == pattern.length()){
            return 1;
        }
        
        if(i == s.length() && j != pattern.length()){
            
            while(j < pattern.length()){
                if(pattern.charAt(j) != '*'){
                    return 0;
                }
                j++;
            }
            
            return 1;
        }
        
        if(i != s.length() && j == pattern.length()){
            return 0;
        }
        
     
        if(i == s.length() || j == pattern.length()){
            return 0;
        }
        
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
       
        if((s.charAt(i) == pattern.charAt(j)) || pattern.charAt(j) == '?'){
            
            int  match  = find(s,pattern,i+1,j+1,dp);
              
              if(match == 1){
                  return dp[i][j] = 1;
              }
            
        } else if (pattern.charAt(j) == '*'){
            
           for(int start = i; start <= s.length(); start++){
              int  starMatch  = find(s,pattern,start,j+1,dp);
                
                if(starMatch == 1){
                    return dp[i][j] = 1;
                }
            }
            
        }  
    
         return dp[i][j] = 0;
        
    }
}

    