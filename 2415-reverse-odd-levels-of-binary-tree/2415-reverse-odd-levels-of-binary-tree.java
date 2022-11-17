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
    public TreeNode reverseOddLevels(TreeNode root) {
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        
         Stack<Integer> curr = new Stack<>();
        
        int level = 0;
        
        while(que.size() > 0){
            
            int size = que.size();    
          
          if(level % 2 == 0){
              curr = new Stack<>();
          }  
            
            while(size-- > 0){
                       
                TreeNode node = que.remove();
                
                if(node.left != null){
                    que.add(node.left);
                  if(level % 2 == 0){
                        curr.push(node.left.val);
                    }
                }
                
                if(node.right != null){
                    que.add(node.right);
                    if(level % 2 == 0){
                        curr.push(node.right.val);
                    }
                }
                
                if(level % 2 != 0){
                    node.val = curr.pop();
                }
                
            }
            
            level ++;
        }
        
        return root;
        
    }
}