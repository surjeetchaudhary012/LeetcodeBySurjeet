class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        
        int [][][] dp = new int[grid.length][grid[0].length][50];
        
        for(int i = 0; i < dp.length; i++){
            
            for(int j = 0; j < dp[i].length;j++){
                
                Arrays.fill(dp[i][j],-1);
                
            }
        }
        
        return findPaths(0,0,grid,k,0,dp);
        
    }
    
    private int findPaths(int i , int j, int [][] grid, int k,int sum,int [][][] dp){
        
        
        
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length){
            
            return 0;
        }
  
        
           if(dp[i][j][sum%k] >= 0){
               
            return dp[i][j][sum%k];
        }
        
        sum += grid[i][j];
        
        if(i == grid.length - 1 && j == grid[0].length - 1 && sum % k == 0){
            return 1;
        }
        
     
        
        int right = findPaths(i,j+1,grid,k,sum,dp);
        int down = findPaths(i+1,j,grid,k,sum,dp);
        
        sum -= grid[i][j];
        
        return dp[i][j][sum%k] = (right + down) % 1000000007;
    }
}