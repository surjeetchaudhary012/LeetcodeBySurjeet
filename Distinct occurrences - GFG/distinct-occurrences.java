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
        
        int mod = 1000000000  + 7;
	  
	  int [][] dp = new int[n+1][m+1];
        
        for(int i = 0; i < n; i++){
            dp[i][0]  = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                
                int match = 0;
                int notMatch = 0;
                
                if(s.charAt(i-1) == t.charAt(j-1)){
                     match  = (dp[i-1][j-1] + dp[i-1][j]);
                }  else {
                    notMatch = dp[i-1][j] %  mod;
                }
                
                dp[i][j] = (match + notMatch) % mod;
            }
        }
        
    return dp[n][m];
	  
    }
}