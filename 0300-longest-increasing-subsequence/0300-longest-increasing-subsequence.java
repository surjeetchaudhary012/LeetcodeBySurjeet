class Solution {
    public int lengthOfLIS(int[] arr) {
        
         int n = arr.length;
        int [][] dp = new int[n][n];
        
         for(int [] a : dp){
            Arrays.fill(a,-1);
        }
        
        return findLIS(arr,0,-1,dp);
        
    }
    
     private static int findLIS(int [] arr, int idx , int prev , int [][] dp){
        
        if(idx == arr.length){
            return 0;
        }
   
        if(dp[idx][prev + 1] != -1){
            return dp[idx][prev+1];
        }
        int take = 0;
        
        if(prev == -1 || arr[idx] > arr[prev]){
            take = 1 + findLIS(arr,idx + 1,idx,dp);
        }
        
      int  notTake = findLIS(arr,idx+1,prev,dp);
        
        return dp[idx][prev+1] = Math.max(take ,notTake);
    }
    
}