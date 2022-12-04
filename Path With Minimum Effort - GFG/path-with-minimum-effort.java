//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
        
       int minEffort = 0;
        
        int n = heights.length;
        int m = heights[0].length;
        
        boolean [][] visited = new boolean[n][m];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a.effort,b.effort);
        });
        
        pq.add(new Node(0,0,0));
      
        int [] rowDir = {0,1,0,-1};
        int [] colDir = {1,0,-1,0};
        
        while(pq.size() > 0){
         
            Node node = pq.remove();
        
            int row = node.row;
            int col = node.col;
            int effortSoFar = node.effort;
            
            minEffort = Math.max(minEffort,effortSoFar);
            
            visited[row][col] = true;
            
            if(row == n-1 && col == m - 1){
               return minEffort;
            }
            
            for(int i = 0; i < 4; i++){
                
                int r = row + rowDir[i];
                int c = col + colDir[i];
                
                if(isPossible(r,c,heights,visited)){
                    
                    int effort = Math.abs(heights[r][c] - heights[row][col]);
                    pq.add(new Node(r,c,effort));    
                }
            }          
            
        }
        
         return 0;
    }
    
    private boolean isPossible(int row, int col, int [][] heights, boolean [][] visited){
        
        if(row < 0 || col < 0 || row == heights.length || col == heights[0].length ||                                                                     visited[row][col] == true){
            return false;
        }
        
        return true;
    }
}

class Node {
    int row;
    int col;
    int effort;
    
    Node(int row, int col, int effort){
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}