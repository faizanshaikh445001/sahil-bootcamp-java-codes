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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode midNode = findMiddleNode(head);
        
        ListNode tempList = midNode.next;
        midNode.next = null;
        
        ListNode l2 = reverseList(tempList);
        
        return compare(head, l2);
        
    }
    
    public boolean compare(ListNode head, ListNode l2){
        while(head != null && l2 != null){
            if(head.val != l2.val){
                return false;
            }
                head = head.next;
                l2 = l2.next;
        }
        
        return true;
    }
    
    public ListNode findMiddleNode(ListNode head){
        ListNode runner = head;
        ListNode follower = head;
        
        while(runner.next != null  && runner.next.next != null){
            runner = runner.next.next;
            follower = follower.next;
        }
        return follower;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        
        return prev;
        
    }
    
}
