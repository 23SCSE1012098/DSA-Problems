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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return maxDepth(root.right)+1;
        }
        if(root.right==null){
            return maxDepth(root.left)+1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int ans=Math.max(left,right)+1;
        return ans;
    }
}