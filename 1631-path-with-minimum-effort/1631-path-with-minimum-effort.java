class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int minEffort = 0;
        
        int n = heights.length;
        int m = heights[0].length;
        
        boolean [][] visited = new boolean[n][m];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a.effort,b.effort);
        });
        
        pq.add(new Node(0,0,0));
        visited[0][0] = true;
        
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