class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1){
            return -1;
        }
        
        int n = grid.length;
        
        int [] row = {0,0,1,-1,1,-1,-1,1};
        int [] col = {1,-1,0,0,-1,1,-1,1};
      
        Queue<Pair> que = new ArrayDeque<>();  
        boolean [][] visited = new boolean[n][n];
        
        que.add(new Pair(0,0,1));
        visited[0][0] = true;
    
        while(que.size() > 0){
            
            Pair node = que.remove();
            
            int i = node.row;
            int j = node.col;
            int d = node.dist;
            
            if(i == n-1 && j == n-1){     
                return d;
            }
            
           for(int a = 0; a < 8; a++){
               
               int r = i + row[a];
               int c = j + col[a];
               
               if(isPossible(r,c,grid,visited)){
                   que.add(new Pair(r,c,d + 1));
                   visited[r][c] = true;
               }
               
           }
            
        }
        
        return -1;
        
        
    }
    
    private boolean isPossible(int i ,int j, int [][] grid, boolean [][] visited){
        
        int n  = grid.length;
        
        if( i < 0 || j < 0 || i == n || j == n || grid[i][j] == 1 || visited[i][j] == true){
            return false;
        }
        
        return true;
    }
}

class Pair {
    int row;
    int col;
    int dist;
    
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
