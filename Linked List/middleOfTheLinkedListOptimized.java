class Solution {
    public ListNode middleNode(ListNode head) {
        
        if(head == null){ // If there are no Nodes present 
            return null; // Here we are given that minimum 1 node will be present
        }
        
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        
        while(fastPtr.next != null && fastPtr.next.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        
        if(fastPtr.next != null){
            return slowPtr.next;
        }
        
        return slowPtr;
        
    }
}
