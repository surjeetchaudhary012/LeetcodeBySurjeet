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
        
    public int deepestLeavesSum(TreeNode root) {
        
      
        int [] arr = new int[2];
        
         findSum(root,arr,0);
        
            return arr[1];
    }
    
    public void findSum(TreeNode root, int [] arr, int ht){
        
        if(root == null){
            return ;
        }
        
            if(ht == arr[0]){
                arr[1] += root.val;
            }
        
        if(ht > arr[0]){
            arr[1] = root.val;
            arr[0] = ht;
        }
       
        
        findSum(root.left,arr,ht+1);
        findSum(root.right,arr,ht+1);
        
        
    }
}