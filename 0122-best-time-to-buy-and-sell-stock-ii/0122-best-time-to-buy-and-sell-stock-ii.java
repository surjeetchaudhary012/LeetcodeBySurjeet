class Solution {
    public int maxProfit(int[] prices) {
        
 int [][] dp = new int[prices.length][2];
        
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        
     
        return findMaxProfit(prices,0,1,dp);
        
    }
    
    private static int findMaxProfit(int [] prices, int i , int canBuy, int [][] dp){
        
        if(i == prices.length){
            return 0;
        }
        
        if(dp[i][canBuy] != -1){
            return dp[i][canBuy];
        }
        
        if(canBuy == 1){
            
            int a = -prices[i] + findMaxProfit(prices,i+1,0,dp);
            int b = 0 + findMaxProfit(prices,i+1,1,dp);
            return dp[i][canBuy] = Math.max(a,b);
            
        } else {
            
            int a = prices[i] + findMaxProfit(prices,i+1,1,dp);
            int b = 0 + findMaxProfit(prices,i+1,0,dp);
            return dp[i][canBuy] = Math.max(a,b);
            
        }
        
    }
}
