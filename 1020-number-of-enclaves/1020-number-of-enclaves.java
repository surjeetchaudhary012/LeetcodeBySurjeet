class Solution {
    public int numEnclaves(int[][] arr) {
        
             int n = arr.length;
             int m = arr[0].length;
        
         boolean [][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if( i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(visited[i][j] == false && arr[i][j] == 1){
                       
                        surround(arr,i,j,visited);
                    }
                }
            }
        }
        
        int enclaves = 0;
        
           for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    
                    if(visited[i][j] == false && arr[i][j] == 1){
                       enclaves++;
                    }
                }
            }
        
        return enclaves;
    }
    
    private static void surround(int [][] arr, int row, int col,boolean [][] visited){
        
        if(row < 0 || col < 0 || row == arr.length || col == arr[0].length ||
        visited[row][col] == true || arr[row][col] == 0){
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
