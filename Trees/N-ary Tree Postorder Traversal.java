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
    public List<Integer> postorder(Node root) {
        
        List<Integer> answer = new ArrayList<>();
        
        postOrderTraversal(root, answer);
        
        return answer;
        
    }
    
    private void postOrderTraversal(Node root, List<Integer> answer){
        
        if(root == null){
            return;
        }
        
        for(Node child:root.children){
            postOrderTraversal(child, answer);
        }
        
        answer.add(root.val);
        
        return;
        
    }
    
}
