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
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode first = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode prev = null;

        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next; 
        }
        ListNode last = prev;

        while(last != null){
            ListNode nextF = first.next;
            ListNode nextL = last.next;
            first.next = last;
            first = nextF;
            if(first == last){
                first = null;
            }
            last.next = first;
            last = nextL;
        }


        
    }
}
