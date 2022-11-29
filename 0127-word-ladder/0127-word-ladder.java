class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        
        String [] list = new String[wordList.size()];
        
        for(int i = 0; i< list.length; i++){
            list[i] = wordList.get(i);
        }
        
         int n = list.length;
        HashSet<String> set = new HashSet<>();
        set.add(startWord);
        
        for(int i = 0; i < n; i++){
            
            set.add(list[i]);
        }
        
        Queue<String> que = new ArrayDeque<>();
        que.add(startWord);
        set.remove(startWord);
        int m = startWord.length();
        
        int level = 0;
        
        while(que.size() > 0){
            
            int size = que.size();
            
            while(size-- > 0){
                
                String node = que.remove();

                if(node.equals(targetWord)){
                    return level + 1;
                }
                
            
                for(int i = 0; i < m; i++){
                    
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        
                        StringBuilder word = new StringBuilder(node);
                    
                         word.setCharAt(i,ch);
                         
                         String newWord = word.toString();
                         
                        if(set.contains(newWord)){
                            que.add(newWord);
                            set.remove(newWord);
                        }
                        
                    }
                    
                }
            }
            
            level++;
        }
        return 0;
    }
}