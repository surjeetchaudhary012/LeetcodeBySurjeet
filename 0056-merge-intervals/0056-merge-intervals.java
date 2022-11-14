class Solution {
    public int[][] merge(int[][] arr) {
        
          ArrayList<Pair> list = new ArrayList<>();
        
        for(int i = 0;  i < arr.length; i++){
            
            list.add(new Pair(arr[i][0],arr[i][1]));
        }
        
        Collections.sort(list,(a,b) -> {
            return a.start - b.start;
        });
        
        ArrayList<Pair> container = new ArrayList<>();
             
        int k = 0;
        
        container.add(list.get(0));
        
        for(int i = 1; i < list.size(); i++){
            
            System.out.println(list.get(i));
            
            Pair pl = list.get(i);
            Pair pc = container.get(k);
            
            if(pl.start <= pc.end){
                
                Pair p = new Pair(0,0);
                p.start = pc.start;
                p.end = Math.max(pc.end,pl.end);
                
                container.set(k,p);
                
            } else {
                container.add(pl);
               k++;
                 
            }
           
            
        }
        
         System.out.println(container);
              
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