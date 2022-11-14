class Solution {
    public int[][] merge(int[][] arr) {
        
        Arrays.sort(arr,(a,b) -> {
            return a[0] - b[0];
        });
        
        ArrayList<Pair> container = new ArrayList<>();
             
        int k = 0;
        
        container.add(new Pair(arr[0][0],arr[0][1]));
        
        for(int i = 1; i < arr.length; i++){
            
            Pair pc = container.get(k);
            
            if(arr[i][0] <= pc.end){
                
                Pair p = new Pair(0,0);
                p.start = pc.start;
                p.end = Math.max(arr[i][1],pc.end);
                
                container.set(k,p);
                
            } else {
                container.add(new Pair(arr[i][0],arr[i][1]));
               k++;
                 
            }
                 
        }
                   
         int [][] ans = new int[container.size()][2];
         
         for(int j = 0; j < container.size(); j++){
             
             Pair p = container.get(j);
              ans[j][0] = p.start;
             ans[j][1] = p.end;
         }
          
        return ans;
        
    }
}

class Pair {
    
    int start;
    int end;
    
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    public String toString(){
      return start + "-" + end;
    }
}