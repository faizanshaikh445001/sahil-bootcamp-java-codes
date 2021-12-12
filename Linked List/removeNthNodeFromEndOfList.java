/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = reverseList(head);
        
        head = dummyNode;
        
        ListNode curr = head;
        ListNode prev = null;
        
        for(int i=0;i<n;i++)
        {
            prev=curr;
            curr=curr.next;
        }
        
        prev.next = curr.next;
        
        return reverseList(head.next);
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while(current!=null){
            ListNode tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
        }
        return prev;
    }
    
}
