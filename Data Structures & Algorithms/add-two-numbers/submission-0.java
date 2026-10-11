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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0, null);
        ListNode curr = ans;

        int carr = 0;

        while(l1!=null || l2!=null || carr != 0){
            int val1 = (l1 ==null) ? 0 : l1.val;
            int val2 = (l2 ==null) ? 0 : l2.val;

            int sum = val1 + val2 + carr;

            int nodeVal = sum % 10;
            carr = sum/10;

            ListNode node = new ListNode(nodeVal);
            curr.next = node;
            curr = curr.next;

            l1 = (l1==null)? null : l1.next;
            l2 = (l2==null)? null : l2.next;
        }

        return ans.next;
        
    }
}
