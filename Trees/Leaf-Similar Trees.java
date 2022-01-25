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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        isSimilar(root1,list1);
        isSimilar(root2,list2);
        
        return list1.equals(list2);
    }
    public void isSimilar(TreeNode root,ArrayList<Integer> list)
    {
        
        if(root.left==null && root.right==null)
        {
            list.add(root.val);
            return;
        }
        
        if(root.left!=null)
            isSimilar(root.left, list);
        
        if(root.right!=null)
            isSimilar(root.right, list);
        
    }
}
