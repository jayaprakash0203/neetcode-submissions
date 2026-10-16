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


        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode groupPrev = dummy;
        
        
        

        while(true){
            ListNode knode = groupPrev;
            for(int i = 0; i<k; i++){

                knode = knode.next;
                if(knode == null){
                    return dummy.next;
                }
                           
            }
            ListNode groupNext = knode.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            ListNode groupStart = curr;
            for(int i = 0; i<k; i++){
                ListNode next = (curr.next != null) ? curr.next : null;
                curr.next = prev;
                prev = curr;
                curr = next;   
            }
            groupPrev.next = knode;
            groupPrev = groupStart;

            
        }
        
    }
}
