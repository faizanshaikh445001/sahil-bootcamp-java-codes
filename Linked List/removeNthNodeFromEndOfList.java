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





// Two Pointer Approach
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
     
        if(head.next==null || head.next == null)
            return null;
        
        ListNode runner = head;
        ListNode follower = head;
        
        for(int i=0; i<n; i++){
            runner = runner.next;
        }
        
        if(runner == null){
            return head.next;
        }
        
        while(runner.next != null){
            runner = runner.next;
            follower = follower.next;
        }
        
        follower.next = follower.next.next;
    
        return head;
        
    }
    
}
