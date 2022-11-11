//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int arr[], int n)
    {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<Integer,Integer> startPoint = new HashMap<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int length = Integer.MAX_VALUE;
        int maxFreq = 0;
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < arr.length; i++){
        
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
            
            if(startPoint.containsKey(arr[i]) == false){
                startPoint.put(arr[i],i);
            }
    
                if (map.get(arr[i]) == maxFreq){
                    
                     if(i - startPoint.get(arr[i]) + 1 < length){
                         
                       start = startPoint.get(arr[i]);
                       end = i;
                       length = end - start + 1;
                    
                }
                
                } else if  (map.get(arr[i]) > maxFreq){
                    
                    start = startPoint.get(arr[i]);
                    end = i;
                    length = end - start + 1;
                    maxFreq = map.get(arr[i]);
                    
                }
                
            }
            
      
        while(start <= end){
            ans.add(arr[start]);
            start++;
        }
        
      return ans;
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            


// } Driver Code Ends