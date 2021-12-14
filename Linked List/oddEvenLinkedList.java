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
    public ListNode oddEvenList(ListNode head) {
        
        boolean oddPos = true;
        
        ListNode oddDummyNode = new ListNode(-1);
        ListNode evenDummyNode = new ListNode(-1);
        
        ListNode current1 = oddDummyNode;
        ListNode current2 = evenDummyNode;
        
        ListNode current = head;
        
        while(current != null){
            if(oddPos == true){
                ListNode newNode = new ListNode(current.val);
                current1.next = newNode;
                current1 = newNode;
                oddPos = false;
            }
            else{
                ListNode newNode = new ListNode(current.val);
                current2.next = newNode;
                current2 = newNode;
                oddPos = true;
            }
            current = current.next;
        }
        
        current1.next = evenDummyNode.next;
        
        return oddDummyNode.next;
        
    }
}
