package linkedList;

public class addTwoNumbers {

    public LinkedList.Node addTwoNumbers(LinkedList.Node l1, LinkedList.Node l2) {
        LinkedList.Node dummy = new LinkedList.Node(0);
        LinkedList.Node curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            curr.next = new LinkedList.Node(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new LinkedList.Node(carry);
        }

        return dummy.next;
    }

    public class Main {
        // Helper to print list
        public static void printList(LinkedList.Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // l1 = [2,4,3]
            LinkedList.Node l1 = new LinkedList.Node(2);
            l1.next = new LinkedList.Node(4);
            l1.next.next = new LinkedList.Node(3);

            // l2 = [5,6,4]
            LinkedList.Node l2 = new LinkedList.Node(5);
            l2.next = new LinkedList.Node(6);
            l2.next.next = new LinkedList.Node(4);

            addTwoNumbers sol = new addTwoNumbers();
            LinkedList.Node result = sol.addTwoNumbers(l1, l2);

            System.out.print("Result: ");
            printList(result); // Expected: 7 0 8
        }
    }
}