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
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] arr)
    {
        
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
        
        // System.out.println(list);
        
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