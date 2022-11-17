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
        
        LinkedList<TreeNode> que = new LinkedList<>();
        
        int ans = 0;
        
        que.add(root);
        
        while(que.size() > 0){
            
            int size = que.size();
            ans = 0;
            
            while(size-- > 0){
                
                TreeNode node = que.remove();
                
                ans += node.val;
                
                if(node.left != null){
                    que.add(node.left);
                }
                
                if(node.right != null){
                    que.add(node.right);
                }
                
            }
                    
        }
        
        return ans;
        
    }
}