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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseGroups(head, k);
        
    }
    
    public ListNode reverseGroups(ListNode head, int k){
        
        if(head == null){
            return null;
        }
        
        ListNode current = head;
        int currentLength = 1;
        
        while(current.next != null && currentLength < k){
            current = current.next;
            currentLength += 1;
        }
        
        if(currentLength < k){
            return head;
        }
        
        ListNode tempNode = current.next;
        current.next = null;
        
        ListNode tempList = reverseGroups(tempNode, k);
        
        ListNode prev = null;
        current = head;
        
        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        
        head.next = tempList;
        
        return prev;
        
    }
    
}
