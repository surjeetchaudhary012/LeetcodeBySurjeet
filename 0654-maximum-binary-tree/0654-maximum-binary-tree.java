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
        
        return constructTree(arr,0,arr.length - 1);
        
    }
    
    private TreeNode constructTree(int [] arr, int start, int end){
        
        if(start == arr.length  || end == -1 || start > end){
            return null;
        }
            
        int maxIndex = findMax(arr,start,end);
        TreeNode node = new TreeNode(arr[maxIndex]);
        
        node.left = constructTree(arr,start,maxIndex-1);
        node.right = constructTree(arr,maxIndex+1,end);
        
        return node;
        
    }
    
    private int findMax(int [] arr,int start, int end){
        
        int ans = -1;
        int max = -1;
        
        for(int i = start; i <= end; i++){
            
            if(arr[i] > max){
                max = arr[i];
                ans = i;
            }
            
        }
        
        return ans;
    }
}