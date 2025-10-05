package linkedList;

public class reverseKGroup {

    public LinkedList.Node reverseKGroup(LinkedList.Node head, int k) {
        if (head == null || k == 1) return head;

        // Step 1: Count total LinkedList.Nodes
        int length = 0;
        LinkedList.Node curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Step 2: Dummy LinkedList.Node
        LinkedList.Node dummy = new LinkedList.Node(0);
        dummy.next = head;
        LinkedList.Node prevGroupEnd = dummy;

        // Step 3: Process groups of k
        while (length >= k) {
            curr = prevGroupEnd.next;
            LinkedList.Node next = curr.next;

            // Reverse k-1 links
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prevGroupEnd.next;
                prevGroupEnd.next = next;
                next = curr.next;
            }

            // Move prevGroupEnd for next round
            prevGroupEnd = curr;
            length -= k;
        }

        return dummy.next;
    }


    public class Main {
        // Utility: print linked list
        public static void printList(LinkedList.Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Input: [1,2,3,4,5], k = 2
            LinkedList.Node head = new LinkedList.Node(1);
            head.next = new LinkedList.Node(2);
            head.next.next = new LinkedList.Node(3);
            head.next.next.next = new LinkedList.Node(4);
            head.next.next.next.next = new LinkedList.Node(5);

            reverseKGroup sol = new reverseKGroup();
            LinkedList.Node result = sol.reverseKGroup(head, 2);

            System.out.print("Reversed in groups of 2: ");
            printList(result); // Expected: 2 1 4 3 5
        }
    }
}