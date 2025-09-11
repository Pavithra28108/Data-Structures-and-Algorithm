package linkedList;

public class LinkedList {


    // Node definition
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head; // head of list

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at specific position (1-based index)
    public void insertAtPosition(int data, int pos) {
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete a node by key
    public void deleteByKey(int key) {
        Node temp = head, prev = null;

        // If head node holds the key
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // Search for the key
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Key not found!");
            return;
        }

        prev.next = temp.next;
    }

    // Delete node at given position (1-based index)
    public void deleteAtPosition(int pos) {
        if (head == null) return;

        Node temp = head;

        if (pos == 1) {
            head = temp.next;
            return;
        }

        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) return;

        temp.next = temp.next.next;
    }

    // Reverse Linked List
    public void reverse() {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Find k-th node from start (1-based index)
    public void kthFromStart(int k) {
        Node temp = head;
        int count = 1;
        while (temp != null) {
            if (count == k) {
                System.out.println(k + "th node from start: " + temp.data);
                return;
            }
            count++;
            temp = temp.next;
        }
        System.out.println("Less than " + k + " nodes in list.");
    }

    // Find k-th node from end
    public void kthFromEnd(int k) {
        Node first = head, second = head;
        for (int i = 0; i < k; i++) {
            if (first == null) {
                System.out.println("Less than " + k + " nodes in list.");
                return;
            }
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        System.out.println(k + "th node from end: " + second.data);
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        System.out.println("Initial List:");
        list.display();

        list.insertAtBeginning(5);
        list.insertAtPosition(25, 4);
        System.out.println("After Insertions:");
        list.display();

        list.deleteByKey(30);
        list.deleteAtPosition(2);
        System.out.println("After Deletions:");
        list.display();

        list.reverse();
        System.out.println("After Reversing:");
        list.display();

        list.kthFromStart(3);
        list.kthFromEnd(2);
    }
}


