class Solution {
    public int minInsertions(String s) {
        
         int n = s.length();
       int [][] dp = new int[n+1][n+1];
       
       String rs = reverse(s);
        
       for(int i = 1; i <= n; i++){
           for(int j = 1; j <= n; j++){
               
               if(s.charAt(i-1) == rs.charAt(j-1)){
                   dp[i][j] = 1 + dp[i-1][j-1];
               } else {
                   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
               }
           }
       }
       
       return n - dp[n][n];       
    }
    
    private String reverse(String s){
        
        String rev = "";
        
        for(int i = 0; i < s.length(); i++){
            rev = s.charAt(i) + rev;
        }
        
        return rev;
    }
}