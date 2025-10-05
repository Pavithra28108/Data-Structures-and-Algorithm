package linkedList;

public class SplitLinkedListAlternatingly {

    // Function to split the linked list into two alternating lists
    LinkedList.Node[] alternatingSplitList(LinkedList.Node head) {
        if (head == null) return new LinkedList.Node[]{null, null};

        LinkedList.Node head1 = null, tail1 = null; // First sublist
        LinkedList.Node head2 = null, tail2 = null; // Second sublist

        LinkedList.Node curr = head;
        boolean firstListTurn = true; // toggle between lists

        while (curr != null) {
            if (firstListTurn) {
                // append to first list
                if (head1 == null) {
                    head1 = curr;
                    tail1 = curr;
                } else {
                    tail1.next = curr;
                    tail1 = tail1.next;
                }
            } else {
                // append to second list
                if (head2 == null) {
                    head2 = curr;
                    tail2 = curr;
                } else {
                    tail2.next = curr;
                    tail2 = tail2.next;
                }
            }
            firstListTurn = !firstListTurn; // switch turns
            curr = curr.next;
        }

        // break the original connections
        if (tail1 != null) tail1.next = null;
        if (tail2 != null) tail2.next = null;

        return new LinkedList.Node[]{head1, head2};
    }

    public class Main {
        // Utility function to print a linked list
        static void printList(LinkedList.Node head) {
            LinkedList.Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
            LinkedList.Node head = new LinkedList.Node(1);
            head.next = new LinkedList.Node(2);
            head.next.next = new LinkedList.Node(3);
            head.next.next.next = new LinkedList.Node(4);
            head.next.next.next.next = new LinkedList.Node(5);
            head.next.next.next.next.next = new LinkedList.Node(6);

            SplitLinkedListAlternatingly sol = new SplitLinkedListAlternatingly();
            LinkedList.Node[] result = sol.alternatingSplitList(head);

            System.out.print("First List: ");
            printList(result[0]);

            System.out.print("Second List: ");
            printList(result[1]);
        }

    }
}