class Solution {
    public int[][] updateMatrix(int[][] grid) {
        
          int n = grid.length;
          int m = grid[0].length;
        
        boolean [][] visited = new boolean[n][m];
        int [][] ans = new int[n][m];
        
        for(int [] arr : ans){
            Arrays.fill(arr,-1);
        }
        
        Queue<Pair> que = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(grid[i][j] == 0){
                    que.add(new Pair(i,j,0));
                    ans[i][j] = 0;
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
          
            for(int i = 0; i < 4; i++){
                
                int r = row + rdr[i];
                int c = col + cdr[i];
                int d = dist + 1;
                
                if(r < 0 || r == n || c < 0 || c == m || ans[r][c] > 0 || grid[r][c] == 0){
                    continue;
                } else {
                    que.add(new Pair(r,c,d));
                    ans[r][c] = d;
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
    
