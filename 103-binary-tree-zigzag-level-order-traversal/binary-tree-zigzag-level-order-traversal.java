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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        return  bfs(root,ans);
            
    }
    static List<List<Integer>>  bfs(TreeNode curr, List<List<Integer>> ans){
        Queue<TreeNode> qu = new LinkedList<>();
        boolean flag = true;
        qu.add(curr);
        while(!qu.isEmpty()){
            int size = qu.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node = qu.poll();
                if(flag){
                    level.addLast(node.val);
                }
                else{
                    level.addFirst(node.val);
                }
                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
            ans.add(level);
            flag =!flag;
        }
        return ans;

    }
}