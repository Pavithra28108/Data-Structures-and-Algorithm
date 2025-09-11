package linkedList;

public class LinkedListCycle {

    // Function to detect cycle
    public boolean hasCycle(LinkedList.Node head) {
        if (head == null || head.next == null) {
            return false; // empty or single node list can't form cycle
        }

        LinkedList.Node slow = head;
        LinkedList.Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) {         // pointers meet → cycle
                return true;
            }
        }

        return false; // no cycle
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Example 1: head = [3,2,0,-4], pos = 1
        LinkedList.Node head1 = new LinkedList.Node(3);
        head1.next = new LinkedList.Node(2);
        head1.next.next = new LinkedList.Node(0);
        head1.next.next.next = new LinkedList.Node(-4);
        head1.next.next.next.next = head1.next; // cycle at node with value 2

        System.out.println("Example 1: " + solution.hasCycle(head1)); // true

        // Example 2: head = [1,2], pos = 0
        LinkedList.Node head2 = new LinkedList.Node(1);
        head2.next = new LinkedList.Node(2);
        head2.next.next = head2; // cycle at node with value 1

        System.out.println("Example 2: " + solution.hasCycle(head2)); // true

        // Example 3: head = [1], pos = -1 (no cycle)
        LinkedList.Node head3 = new LinkedList.Node(1);

        System.out.println("Example 3: " + solution.hasCycle(head3)); // false
    }
}
