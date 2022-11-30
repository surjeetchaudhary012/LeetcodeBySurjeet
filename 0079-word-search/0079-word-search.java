class Solution {
    public boolean exist(char[][] grid, String word) {
        
        int n = grid.length; 
        int m = grid[0].length;
        
        String s = "";
        
        boolean [][] visited = new boolean[n][m];
        
        for(int i = 0; i < n ;i++){
            for(int j = 0; j < m; j++){
                
                boolean ans = find(i,j,0,grid,word,visited);
                
                if(ans){
                    return true;
                }
                
            }
        }
        
      return false;
        
    }
    
    private boolean find(int i ,int j ,int k, char [][] grid,
                                                         String word,boolean [][] visited){
    
          if(k == word.length()){
            return true;
        }
        
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] == true){
            return false;
        }
        
      
        
        visited[i][j] = true;
        
        if(word.charAt(k) == grid[i][j]){
            
            int [] row = {-1,0,1,0};
            int [] col = {0,1,0,-1};
            
            for(int a = 0; a < 4; a++){
                
                boolean ans = find(i + row[a],j + col[a],k + 1,grid,word,visited);
                
                if(ans == true){
                    return true;
                }
                
            }
            
        }
        
        visited[i][j] = false;
        
        return false;
        
    }
}