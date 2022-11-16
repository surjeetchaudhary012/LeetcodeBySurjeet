class Solution {
    public int lengthOfLIS(int[] arr) {
        
       int [] nums = new int[arr.length];
        
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            if(i == 0 || arr[i] > nums[idx - 1]){
                
              nums[idx] = arr[i];
              idx++;
              
            } else  {
                
                 setIndex(nums,arr[i],idx-1);
            } 
        
        }
    
        return idx;
    }
    
    private  void setIndex(int [] nums,int val,int i){
        
        int start = 0;
        int end = i;
        
        int idx = -1;
        
        while(start <= end){
            
            int mid = (start + end) / 2;
            
            if(nums[mid] >= val){
                end = mid - 1;
                idx =  mid;
            } else {
                start = mid + 1;
            }
            
        }
        
        nums[idx] = val;
    }
} 