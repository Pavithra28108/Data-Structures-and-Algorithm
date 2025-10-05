package linkedList;

public class rotateRight {

    public LinkedList.Node rotateRight(LinkedList.Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        LinkedList.Node tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Effective rotations
        k = k % length;
        if (k == 0) return head;

        // Step 3: Find new tail (length - k - 1) and new head (length - k)
        int stepsToNewHead = length - k;
        LinkedList.Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        LinkedList.Node newHead = newTail.next;

        // Step 4: Break and connect
        newTail.next = null;
        tail.next = head;

        return newHead;
    }


    public class Main {
        // Helper: Print list
        public static void printList(LinkedList.Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Input: [1,2,3,4,5], k=2
            LinkedList.Node head = new LinkedList.Node(1);
            head.next = new LinkedList.Node(2);
            head.next.next = new LinkedList.Node(3);
            head.next.next.next = new LinkedList.Node(4);
            head.next.next.next.next = new LinkedList.Node(5);

            rotateRight sol = new rotateRight();
            LinkedList.Node rotated = sol.rotateRight(head, 2);

            System.out.print("Rotated List: ");
            printList(rotated); // Expected: 4 5 1 2 3
        }
    }
}