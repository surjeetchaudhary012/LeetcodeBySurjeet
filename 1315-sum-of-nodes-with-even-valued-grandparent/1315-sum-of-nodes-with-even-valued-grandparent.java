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
    public int sumEvenGrandparent(TreeNode root) {
        
        return dfs(root,-1,-1);
    }
    
    private int dfs(TreeNode root,int parent,int grandParent){
        
        if(root == null){
            return 0;
        }
        
        int sum = 0;
        
        if(grandParent % 2 == 0){
            sum = root.val;
        }
        
        return sum + dfs(root.left,root.val,parent) + dfs(root.right,root.val,parent);
    }
}