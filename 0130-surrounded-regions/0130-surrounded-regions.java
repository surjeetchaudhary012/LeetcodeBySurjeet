class Solution {
    public void solve(char[][] arr) {
        
        int n = arr.length;
        int m = arr[0].length;
        
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
