class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int [] ans  = new int[k];
        
        HashMap<Integer,Integer> map =  new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            
        }
           
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return map.get(a) - map.get(b);
        });
        
        for(Integer val : map.keySet()){
             
            pq.add(val);
                
            if(pq.size() > k) {
                
               pq.remove();
        
            }
    
        }
        
       
        int i = 0;
        
        while(pq.size() > 0){
            
            ans[i] = pq.peek();
            pq.remove();
            i++;
            
        }
        
        return ans;
    }

}

