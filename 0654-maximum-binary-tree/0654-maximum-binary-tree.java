/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] arr) {
        
          TreeNode root = new TreeNode(-1);
        
        return constructTree(arr,null,0,arr.length - 1);
        
    }
    
    private TreeNode constructTree(int [] arr, TreeNode node, int start, int end){
        
        if(start > end){
            return null;
        }
        
        if(start == end){
            return new TreeNode(arr[start]);
        }
        
         node = new TreeNode();
        
        int maxIndex = findMax(arr,start,end);
        
        node.val = arr[maxIndex];
        
        node.left = constructTree(arr,node.left,start,maxIndex-1);
        node.right = constructTree(arr,node.right,maxIndex+1,end);
        
        return node;
        
    }
    
    private int findMax(int [] arr,int start, int end){
        
        int ans = -1;
        int max = 0;
        
        for(int i = start; i <= end; i++){
            
            if(arr[i] > max){
                max = arr[i];
                ans = i;
            }
            
        }
        
        return ans;
    }
}