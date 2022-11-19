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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean [][] visited = new boolean[n][m];
        int [][] ans = new int[n][m];
        
        Queue<Pair> que = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(grid[i][j] == 1){
                    que.add(new Pair(i,j,0));
                     visited[i][j] = true;
                }
            }
        }
        
        int [] rdr = {-1,0,1,0};
        int [] cdr = {0,1,0,-1};
        
        while(que.size() > 0){
            
            Pair p = que.remove();
            
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            
            ans[row][col] = dist;
          
            for(int i = 0; i < 4; i++){
                
                int r = row + rdr[i];
                int c = col + cdr[i];
                int d = dist + 1;
                
                if(r < 0 || r == n || c < 0 || c == m || visited[r][c] == true || grid[r][c] == 1){
                    continue;
                } else {
                    que.add(new Pair(r,c,d));
                    visited[r][c] = true;
                }
            }
        }
        
        return ans;
    }
}

class Pair {
    int row;
    int col;
    int dist;
    
    Pair(int row,int col,int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}