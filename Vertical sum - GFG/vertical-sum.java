//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    public ArrayList <Integer> verticalSum(Node root) {
        
        int [] dist = new int[2];
        
        dist[0] = Integer.MAX_VALUE;
        dist[1] = Integer.MIN_VALUE;
        
        findWidth(root,0,dist);
        
        int start = 0;
        int end = dist[1] - dist[0] + 1;
     
       ArrayList<Integer> list = new ArrayList<>();
       
       for(int i = 0; i < end; i++){
           list.add(0);
       }
       
         
        findVerticalSum(root,Math.abs(dist[0]),list);
        
        return list;
        
    }
    
    private void findVerticalSum(Node root,int start,ArrayList<Integer> list){
        
        if(root == null){
            return;
        }
        
        list.set(start,list.get(start) + root.data);
        
        findVerticalSum(root.left,start - 1,list);
        findVerticalSum(root.right,start + 1,list);
        
    }
    
    
    private void findWidth(Node root,int width,int [] dist){
        
        if(root == null){
            return;
        }
        
        dist[0] = Math.min(dist[0],width);
        dist[1] = Math.max(dist[1],width); 
        
        findWidth(root.left,width - 1,dist);
        findWidth(root.right,width + 1,dist);
      
    }
}

class Pair {
    Node node;
    int width;
    
    Pair(Node node,int width){
       this.node = node;
       this.width = width;
    }
}
