/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        
        ListNode pointer = head;
        
        while(pointer!=null){
            if(set.contains(pointer))
                return true;
            set.add(pointer);
            pointer = pointer.next;
        }
        
        return false;
        
    }
}


// O(1) Approach
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public boolean hasCycle(ListNode head) {
        
//         if(head==null){
//             return false;
//         }
        
//         ListNode slowPtr = head;
        
//         ListNode fastPtr = head;
        
//         while(fastPtr.next != null && fastPtr.next.next != null){
            
//             slowPtr = slowPtr.next;
//             fastPtr = fastPtr.next.next;
            
//             if(slowPtr == fastPtr){
//                 return true;
//             }
//         }
        
//         return false;
        
//     }
// }
