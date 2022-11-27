//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String pattern, String s)
    {
        
        int  n = s.length();
        int m = pattern.length();
        
        int [][] dp = new int[n][m];
        
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        return find(s,pattern,0,0,dp);
        
    }
    
    private int find(String s , String pattern, int i , int j, int [][] dp){
        
        if(i == s.length() && j == pattern.length()){
            return 1;
        }
        
        if(i == s.length() && j != pattern.length()){
            
            while(j < pattern.length()){
                if(pattern.charAt(j) != '*'){
                    return 0;
                }
                j++;
            }
            
            return 1;
        }
        
        if(i != s.length() && j == pattern.length()){
            return 0;
        }
        
     
        if(i == s.length() || j == pattern.length()){
            return 0;
        }
        
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
       
        if((s.charAt(i) == pattern.charAt(j)) || pattern.charAt(j) == '?'){
            
            int  match  = find(s,pattern,i+1,j+1,dp);
              
              if(match == 1){
                  return dp[i][j] = 1;
              }
            
        } else if (pattern.charAt(j) == '*'){
            
           int starMatch = find(s,pattern,i,j+1,dp) + find(s,pattern,i+1,j,dp);
           
           if(starMatch >= 1){
               return dp[i][j] = 1;
           }
            
        }  
    
         return dp[i][j] = 0;
        
    }
}
