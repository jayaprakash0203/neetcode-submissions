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
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        if(slow == null || slow.next == null){
            return false;
        }

        while(slow != null && fast !=null){
            slow = slow.next != null ? slow.next: null;
            fast = (fast.next != null)? (fast.next.next != null ? fast.next.next : null): null;

            if(slow == fast){
                return true;
            }
        }

        return false;
        
        
    }
}
