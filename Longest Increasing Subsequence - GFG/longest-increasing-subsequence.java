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
        int [] nums = new int[arr.length];
        
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            if(i == 0 || arr[i] > nums[idx - 1]){
                
              nums[idx] = arr[i];
              idx++;
              
            } else  {
                
                 setIndex(nums,arr[i],idx-1);
            } 
        
        }
    
        return idx;
    }
    
    private static void setIndex(int [] nums,int val,int i){
        
        int start = 0;
        int end = i;
        
        int idx = -1;
        
        while(start <= end){
            
            int mid = (start + end) / 2;
            
            if(nums[mid] >= val){
                end = mid - 1;
                idx =  mid;
            } else {
                start = mid + 1;
            }
            
        }
        
        nums[idx] = val;
    }
} 