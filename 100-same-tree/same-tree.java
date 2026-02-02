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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both null → same
        if (p == null && q == null) {
            return true;
        }

        // one null → different
        if (p == null || q == null) {
            return false;
        }

        // values differ → different
        if (p.val != q.val) {
            return false;
        }

        // compare left and right subtrees
        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}