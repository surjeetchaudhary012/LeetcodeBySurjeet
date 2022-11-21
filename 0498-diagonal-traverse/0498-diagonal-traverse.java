class Solution {
    public int[] findDiagonalOrder(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int td = n + m - 1;
        
        for(int i = 0; i < n + m -1; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                list.get(i + j).add(grid[i][j]);
                
            }
        }
        
        System.out.println(list);
        
        int [] arr = new int[n * m];
        
        int i = 0;
        int j = 1;
        
        for(ArrayList<Integer> l : list){
            
            if(j % 2 != 0){
                Collections.reverse(l);
            }
            
            for(int val : l){
                arr[i] = val;
                i++;
            }
            
            j++;
        }
        
        return arr;
    }
}