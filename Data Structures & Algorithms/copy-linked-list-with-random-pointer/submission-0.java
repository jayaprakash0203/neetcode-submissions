/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> ans = new HashMap<>();

        Node curr = head;

        while(curr != null){
            ans.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while(curr != null){
            Node copy = ans.get(curr);

            copy.next = ans.get(curr.next);

            copy.random = ans.get(curr.random);

            curr = curr.next;

        }

        return ans.get(head);
        
    }
}
