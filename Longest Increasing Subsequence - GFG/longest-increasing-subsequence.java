//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int arr[])
    {
        int n = arr.length;
        int [][] dp = new int[n+1][n+1];
        
        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = i - 1; j >= -1; j--){
                
                int take = 0;
                if(j == -1 || arr[i] > arr[j]){
                    take = 1 + dp[i+1][i+1];
                }
                
              int notTake = dp[i+1][j+1];
                
                dp[i][j+1] = Math.max(take,notTake);
                
            }
        }
        
        return dp[0][0];
        
        // for(int [] a : dp){
        //     Arrays.fill(a,-1);
        // }
        
        // return findLIS(arr,0,-1,dp);
        
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