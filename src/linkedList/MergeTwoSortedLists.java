package linkedList;

public class MergeTwoSortedLists {

    public LinkedList.Node mergeTwoLists(LinkedList.Node list1, LinkedList.Node list2) {
        // Dummy LinkedList.Node to start merged list
        LinkedList.Node dummy = new LinkedList.Node(0);
        LinkedList.Node tail = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // move tail
        }

        // Attach the remaining LinkedList.Nodes
        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next; // head of merged list
    }

    public class Main {
        // Utility function to print linked list
        public static void printList(LinkedList.Node head) {
            LinkedList.Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // First sorted list: 1 -> 2 -> 4
            LinkedList.Node list1 = new LinkedList.Node(1);
            list1.next = new LinkedList.Node(2);
            list1.next.next = new LinkedList.Node(4);

            // Second sorted list: 1 -> 3 -> 4
            LinkedList.Node list2 = new LinkedList.Node(1);
            list2.next = new LinkedList.Node(3);
            list2.next.next = new LinkedList.Node(4);

            MergeTwoSortedLists sol = new MergeTwoSortedLists();
            LinkedList.Node merged = sol.mergeTwoLists(list1, list2);

            System.out.print("Merged List: ");
            printList(merged);
        }
    }
}