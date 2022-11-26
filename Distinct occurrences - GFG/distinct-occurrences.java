//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int  subsequenceCount(String s, String t)
    {
	  
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
        int notMatch = 0;
        
        if(s.charAt(i) == t.charAt(j)){
            
         match =  find(s,t,i+1,j+1,dp) + find(s,t,i+1,j,dp);
        
        } else {
            
            notMatch = find(s,t,i+1,j,dp);
        }
        
        return dp[i][j] = (match + notMatch) % mod;
        
    }
}