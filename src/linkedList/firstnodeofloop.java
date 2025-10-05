package linkedList;

public class firstnodeofloop {


    public int cycleStart(LinkedList.Node head) {
        if (head == null || head.next == null) return -1;

        LinkedList.Node slow = head;
        LinkedList.Node fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop detected
                // Step 2: Find first node of loop
                LinkedList.Node entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry.data; // Return the node's value
            }
        }
        return -1; // No loop
    }



    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        LinkedList.Node head = new LinkedList.Node(1);
        head.next = new LinkedList.Node(2);
        head.next.next = new LinkedList.Node(3);
        head.next.next.next = new LinkedList.Node(4);
        head.next.next.next.next = new LinkedList.Node(5);

        // Create loop: node 5 -> node 3
        head.next.next.next.next.next = head.next.next;
        firstnodeofloop sol = new firstnodeofloop();
        int start = sol.cycleStart(head);

        if (start != -1) {
            System.out.println("Cycle starts at node with value: " + start);
        } else {
            System.out.println("No cycle detected");
        }
    }
}

