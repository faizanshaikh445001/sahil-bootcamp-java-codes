/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node dummyNode = new Node(10001);
        Node runner = dummyNode;
        
        HashMap<Node,Node> map = new HashMap<>();
        
        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            
            map.put(current,newNode);
            
            runner.next = newNode;
            runner = newNode;
            
            current = current.next;
        }
        
        runner = dummyNode.next;
        current = head;
        while(current != null){
            
            if(current.random != null){
                runner.random = map.get(current.random);
            }
            
            current = current.next;
            runner = runner.next;
        }
        
        return dummyNode.next;
        
    }
}
