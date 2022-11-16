class Solution {
    public int lengthOfLIS(int[] arr) {
        
          ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            
            if(i == 0){
                list.add(arr[i]);
            } else {
                
                if(arr[i] > list.get(list.size() - 1)){
                    list.add(arr[i]);
                } else {
                    
                    int idx = searchIndex(list,arr[i]);
                    
                    list.set(idx,arr[i]);
                    
                }
                
            }
            
        }
        
        return list.size();
    }
    
    private  int searchIndex(ArrayList<Integer> list,int val){
        
        int start = 0;
        int end = list.size() - 1;
        
        int idx = -1;
        
        while(start <= end){
            
            int mid = (start + end) / 2;
            
            if(list.get(mid) >= val){
                end = mid - 1;
                idx =  mid;
            } else {
                start = mid + 1;
            }
            
        }
        
        return idx;
    }
} 