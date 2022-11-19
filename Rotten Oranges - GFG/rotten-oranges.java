//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
    
        int [][] visited = new int[n][m];
        
        int freshCount  = 0;
        
        Queue<Pair> que = new ArrayDeque<>();
        
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(grid[i][j] == 2){
                    que.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                } 
                
                if(grid[i][j] == 1){
                    freshCount++;
                }
                
            }
        }
        
        int minTime = 0;
        int rottedCount = 0;
        
        int [] rdr = {-1,0,1,0};
        int [] cdr = {0,1,0,-1};
        
        while(que.size() > 0){
            
            Pair p = que.remove();
            
            int row = p.row;
            int col = p.col;
            int time = p.time;
            
            minTime = Math.max(time,minTime);
            
            if(grid[row][col] == 1){
                rottedCount++;
            }
            
            for(int i = 0; i < 4; i++){
                
                int r = row + rdr[i];
                int c = col + cdr[i];
                int t = time + 1;
                
                if(r < 0 || r == n || c < 0 || c == m || grid[r][c] != 1 || visited[r][c] == 1){
                    continue;
                } else {
                    
                    que.add(new Pair(r,c,t));
                    visited[r][c] = 1;
                }
                
            }
        }
        
        return rottedCount == freshCount ? minTime : -1;
    }
}

class Pair {
    int row;
    int col;
    int time;
    
    Pair(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}