class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int [] ans  = new int[k];
        
        HashMap<Integer,Integer> map =  new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            
        }
       
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            return a.frequency - b.frequency;
        });
        
        for(Integer val : map.keySet()){
            
            if(pq.size() < k){
                
                pq.add(new Pair(val,map.get(val)));
                
            } else {
                
                if(map.get(val) > pq.peek().frequency){
                    pq.remove();
                     pq.add(new Pair(val,map.get(val)));
                    
                }
            }
    
        }
        
        
        
        int i = 0;
        
        while(pq.size() > 0){
            ans[i] = pq.peek().element;
            pq.remove();
            i++;
        }
        
        return ans;
    }

}

class Pair {
    
    int element;
    int frequency;
    
    Pair(int element , int frequency){
        this.element = element;
        this.frequency = frequency;
    }
    
}