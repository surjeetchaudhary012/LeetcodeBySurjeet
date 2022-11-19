class Solution {
    public int orangesRotting(int[][] grid) {
        
      int n = grid.length;
        int m = grid[0].length;
    
        int [][] visited = new int[n][m];
        
        Queue<Pair> que = new ArrayDeque<>();
        
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(grid[i][j] == 2){
                    que.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                } 
            }
        }
        
        int minTime = 0;
        
        int [] rdr = {-1,0,1,0};
        int [] cdr = {0,1,0,-1};
        
        while(que.size() > 0){
            
            Pair p = que.remove();
            
            int row = p.row;
            int col = p.col;
            int time = p.time;
            
            minTime = Math.max(time,minTime);
            
            for(int i = 0; i < 4; i++){
                
                int r = row + rdr[i];
                int c = col + cdr[i];
                int t = time + 1;
                
                if(r < 0 || r == n || c < 0 || c == m || grid[r][c] != 1 || visited[r][c] == 1){
        
                } else {
                    
                    que.add(new Pair(r,c,t));
                    visited[r][c] = 1;
                }
                
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return minTime;
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