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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        rightSideView(root, 1, new HashSet<>(), answer);
        
        return answer;
        
    }
    
    private void rightSideView(TreeNode root, int level, HashSet<Integer> set, ArrayList<Integer> answer){
        
        if(root == null){
            return;
        }
        
        if(!set.contains(level)){
            answer.add(root.val);
            set.add(level);
        }
        
        rightSideView(root.right, level + 1, set, answer);
        rightSideView(root.left, level + 1, set, answer);
        
        
        return;
        
    }
    
    
}
