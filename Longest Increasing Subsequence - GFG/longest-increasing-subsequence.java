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
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            
            if(i == 0){
                list.add(arr[i]);
            } else {
                
                if(arr[i] > list.get(list.size() - 1)){
                    list.add(arr[i]);
                } else {
                    
                    int idx = searchIndex(list,arr[i]);
                    
                    list.set(idx,arr[i]);
                    
                }
                
            }
            
        }
        
        return list.size();
    }
    
    private static int searchIndex(ArrayList<Integer> list,int val){
        
        int start = 0;
        int end = list.size() - 1;
        
        int idx = -1;
        
        while(start <= end){
            
            int mid = (start + end) / 2;
            
            if(list.get(mid) >= val){
                end = mid - 1;
                idx =  mid;
            } else {
                start = mid + 1;
            }
            
        }
        
        return idx;
    }
} 