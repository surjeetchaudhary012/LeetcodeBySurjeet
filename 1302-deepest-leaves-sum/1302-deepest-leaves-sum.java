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
        int sum;
    int max;
    int ht; 
    public int deepestLeavesSum(TreeNode root) {
        
        sum = 0;
        max = 0;
        ht = -1;
        
        int [] arr = new int[2];
        
         findSum(root,arr);
        
            return sum;
    }
    
    public void findSum(TreeNode root, int [] arr){
        
        if(root == null){
            return ;
        }
        
      ht += 1;
        
        if(ht > max){
            sum = 0;
            max = ht;
        }
        
        if(ht == max){
            sum += root.val;
        }
        
        findSum(root.left,arr);
        findSum(root.right,arr);
        
        ht -= 1;
        
    }
}