class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        
      int  m = s1.length();
          int n = s2.length();
       
        int [] prev = new int[n+1];
        
         for(int i = 1; i <= m; i++){
             
             int [] curr = new int[n+1];
             
            for(int j = 1; j <= n; j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    
                    curr[j] = prev[j-1] + 1;
                    
                } else {
                    
                    curr[j] = Math.max(prev[j] , curr[j-1]);
                    
                }
            }
            
            prev = curr;
            
        }
      
         return prev[n]; 
    }
}