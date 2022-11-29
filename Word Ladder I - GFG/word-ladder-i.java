//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] list)
    {
        
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