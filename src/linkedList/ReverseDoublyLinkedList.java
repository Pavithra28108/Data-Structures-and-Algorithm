//package linkedList;
//
//
//class Node {
//    int data;
//    Node next;
//    TriNode prev;
//
//    Node(int data) {
//        this.data = data;
//        this.next = null;
//        this.prev = null;
//    }
//}
//
//public class ReverseDoublyLinkedList {
//
//
//    // Function to reverse the doubly linked list
//    public Node reverseDLL(Node head) {
//        if (head == null || head.next == null) {
//            return head; // empty list or single node doesn't need reversing
//        }
//
//        Node curr = head;
//        Node temp = null;
//
//        // Traverse the list and swap prev and next for each node
//        while (curr != null) {
//            temp = curr.prev;      // store prev
//            curr.prev = curr.next; // swap prev and next
//            curr.next = temp;
//
//            // move to next node (which is curr.prev after swapping)
//            curr = curr.prev;
//        }
//
//        // At the end, temp points to the new head's prev
//        if (temp != null) {
//            head = temp.prev; // new head after reversal
//        }
//
//        return head;
//    }
//
//    // Helper function to print list
//    public void printList(Node head) {
//        Node curr = head;
//        while (curr != null) {
//            System.out.print(curr.data);
//            if (curr.next != null) {
//                System.out.print(" <-> ");
//            }
//            curr = curr.next;
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        ReverseDoublyLinkedList solution = new ReverseDoublyLinkedList();
//
//        // Create doubly linked list: 3 <-> 4 <-> 5
//        Node head = new Node(3);
//        Node node2 = new Node(4);
//        Node node3 = new Node(5);
//
//        head.next = node2;
//        node2.prev = head;
//        node2.next = node3;
//        node3.prev = node2;
//
//        System.out.print("Original List: ");
//        solution.printList(head);
//
//        // Reverse
//        head = solution.reverseDLL(head);
//
//        System.out.print("Reversed List: ");
//        solution.printList(head);
//    }
//
//}