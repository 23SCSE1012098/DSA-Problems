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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> ans = new ArrayList<>();
            while(size-->0){
                TreeNode curr = queue.remove();
                ans.add(curr.val);
                
                if(curr.left !=null){
                    queue.add(curr.left);
        
                }
                if(curr.right !=null){
                    queue.add(curr.right);
                
                }
            }
            list.add(ans);
        } 
        return list;
        
    }
}