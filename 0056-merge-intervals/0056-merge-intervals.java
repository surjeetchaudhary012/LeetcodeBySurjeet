class Solution {
    public int[][] merge(int[][] arr) {
        
          ArrayList<Pair> list = new ArrayList<>();
        
        for(int i = 0;  i < arr.length; i++){
            
            list.add(new Pair(arr[i][0],arr[i][1]));
        }
        
        Collections.sort(list,(a,b) -> {
            return a.start - b.start;
        });
        
        
       
        
        int i = 0;
        
        while(i < list.size() - 1){
            
            Pair first = list.get(i);
            Pair second = list.get(i+1);
        
            if(first.end >= second.start){
                
                list.remove(i+1);
                list.set(i,new Pair(Math.min(first.start,second.start),Math.max(first.end,second.end)));
                
            } else {
                i++;
            }
        
            
        }
        
        
         int [][] ans = new int[list.size()][2];
         
         for(int j = 0; j < list.size(); j++){
             
             Pair p = list.get(j);
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