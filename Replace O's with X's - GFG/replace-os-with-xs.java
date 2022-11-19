//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char arr[][])
    {
        
        boolean [][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if( i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(visited[i][j] == false && arr[i][j] == 'O'){
                       
                        surround(arr,i,j,visited);
                    }
                }
            }
        }
        
           for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    
                    if(visited[i][j] == false && arr[i][j] == 'O'){
                        arr[i][j] = 'X';
                    }
                }
            }
            
        return arr;
    }
    
    private static void surround(char [][] arr, int row, int col,boolean [][] visited){
        
        if(row < 0 || col < 0 || row == arr.length || col == arr[0].length ||
        visited[row][col] == true || arr[row][col] == 'X'){
            return;
        }
        
        visited[row][col] = true;
        
        int [] rdr = {-1,0,1,0};
        int [] cdr = {0,1,0,-1};
        
        for(int i = 0; i < 4; i++){
            surround(arr,row + rdr[i] , col + cdr[i], visited);
        }
    
     }
}