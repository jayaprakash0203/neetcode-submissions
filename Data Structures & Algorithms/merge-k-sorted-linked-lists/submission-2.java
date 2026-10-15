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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0,null);
        ListNode tail = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));

       
        for(int i = 0 ; i < lists.length; i++)
        { 
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
           
            
        }
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            tail.next = curr;
            

            if(curr.next != null){
                pq.offer(curr.next);
            }
            
            tail = tail.next;
        }


        return result.next;

        

    }
}
