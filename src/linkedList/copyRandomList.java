package linkedList;

public class copyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Clone nodes and interleave
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // jump over copy
        }

        // Step 3: Separate lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next; // restore original list
            copyCurr.next = copy;  // build copied list
            copyCurr = copy;

            curr = curr.next;
        }

        return dummy.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
}}
