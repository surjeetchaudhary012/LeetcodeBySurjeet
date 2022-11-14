class Solution {
    public int[][] merge(int[][] arr) {
        
        Arrays.sort(arr,(a,b) -> {
            return a[0] - b[0];
        });
        
        ArrayList< int [] > list = new ArrayList<>();
             
        int i = 0;
        
        for(int [] interval : arr){
            
            if(list.size() == 0){
                list.add(interval);
            } else {
                
                int [] prevInterval = list.get(list.size() - 1);
                
                if(interval[0] <= prevInterval[1]){
                    prevInterval[1] = Math.max(interval[1],prevInterval[1]);
                } else{
                    list.add(interval);
                }
                
            }
            
            
            
        }
        
       return list.toArray(new int[list.size()][]); 
        
    }
}

 