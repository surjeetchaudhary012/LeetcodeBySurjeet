class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        int [][] dp = new int[n][m];
        
       for(int [] arr : dp){
           Arrays.fill(arr,-1);
       }
        
        return findDist(word1,word2,0,0,dp);
        
    }
    
    private int findDist(String word1,String word2, int i , int j , int [][] dp){
        
        if(i == word1.length()){
            return word2.length() - j;
        } 
        
        if(j == word2.length()){
            return word1.length() - i;
        }
        
        if(dp[i][j] > -1)  return dp[i][j];
        
       int ans = 0;
        
        if(word1.charAt(i) == word2.charAt(j)){
             ans = findDist(word1,word2,i+1,j+1,dp);
        } else {
            
            int replace = findDist(word1,word2,i+1,j+1,dp);
            int delete =  findDist(word1,word2,i+1,j,dp);
            int insert =  findDist(word1,word2,i,j+1,dp);
            
            ans = 1 +  Math.min(replace,Math.min(delete,insert));
        }
        
        return dp[i][j] = ans;
    }
}