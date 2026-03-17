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
    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        pathSum(root);
        return result;

        
    }
    int pathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left =pathSum(root.left);
        int right =pathSum(root.right);
        int opt1=Math.max(left,right)+root.val;
        int opt2=left+right+root.val;
        int opt3=root.val;

        result = Math.max(result,Math.max(opt1,Math.max(opt2,opt3)));
        return Math.max(opt1,opt3);

    }
}