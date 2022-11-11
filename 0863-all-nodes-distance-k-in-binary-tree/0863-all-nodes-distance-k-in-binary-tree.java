/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
      ArrayList<Integer> ans = new ArrayList<>();
        
        findNode(root,target,k,ans);
    
        return ans;
    }
    
    
    public static int findNode(TreeNode root, TreeNode target, int k , ArrayList<Integer> ans){
        
        if(root == null){
            return -1;
        }
        
        if(root.val == target.val){
            kDown(root,k,null,ans);
            return 1;
        }
        
        int left = findNode(root.left,target,k,ans);
        
        if(left >= 1){
            kDown(root,k-left,root.left,ans);
            return left + 1;
        }
        int right = findNode(root.right,target,k,ans);
        
        if(right >= 1){
            kDown(root,k-right,root.right,ans);
            return right + 1;
        }
        
        return 0;
    }
    
    public static void kDown(TreeNode root , int k , TreeNode blockNode , ArrayList<Integer> ans){
        
        if(root == null || k < 0 || root == blockNode){
            return;
        }
        
        if(k == 0){
            ans.add(root.val);
            return;
        }
            
        kDown(root.left,k-1,blockNode,ans);
        kDown(root.right,k-1,blockNode,ans);
        
    }
};