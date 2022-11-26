class Solution {
    public int numDistinct(String s, String t) {
        
    int n = s.length();
	  int m = t.length();
	  
	  int [][] dp = new int[n][m];
	  
	  for(int [] arr : dp){
	      Arrays.fill(arr,-1);
	  }
	  
	return   find(s,t,0,0,dp);
	  
    }
    
    private int find(String s , String t , int i , int j,int [][] dp){
        
        if(i == s.length()){
            if(j == t.length()){
                return 1; 
            } else {
                return 0;
            }
        }
        
        int mod = 1000000000 + 7;
        
        if(j == t.length()){
            return 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int match = 0;
        int match2 = 0;
        int notMatch = 0;
        
        if(s.charAt(i) == t.charAt(j)){
         match =  find(s,t,i+1,j+1,dp);
         match2 = find(s,t,i+1,j,dp);
        } else {
            notMatch = find(s,t,i+1,j,dp);
        }
        
        return dp[i][j] = (match + notMatch + match2) % mod;
        
    }
}