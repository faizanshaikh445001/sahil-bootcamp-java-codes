/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        
        List<Integer> answer = new ArrayList<>();
        
        preorderTraversal(root, answer);
        
        return answer;
        
    }
    
    private void preorderTraversal(Node root, List<Integer> answer){
        
        if(root == null){
            return;
        }
        
        answer.add(root.val);
        
        for(Node child:root.children){
            preorderTraversal(child, answer);
        }
        
        return;
        
    }
    
}
