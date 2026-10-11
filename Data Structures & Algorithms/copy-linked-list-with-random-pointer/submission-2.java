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

        if(head == null){
            return null;
        }

        
        Node curr = head;
        
        
        while(curr != null){
            Node next = curr.next;
            curr.next = new Node(curr.val);
            Node copy = curr.next;
            copy.next = next;
            curr = next;
            
        }
        curr = head;
        
        while(curr != null){
            Node copy = curr.next;

            if(curr.random != null){
                copy.random = curr.random.next;
            }
            else{
                copy.random = null;
            }

            curr = copy.next;
        }

        curr = head;
        Node copyhead = curr.next;

        while(curr != null){
            Node copy = curr.next;
            Node nextOriginal = copy.next;
            if(nextOriginal != null){
               
                copy.next = nextOriginal.next;
            }
            else{
                copy.next = null;
            }
            curr.next = nextOriginal;
            curr = nextOriginal;  
        }

        return copyhead;
        
    }
}
