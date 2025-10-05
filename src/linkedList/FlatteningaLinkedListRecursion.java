package linkedList;

public class FlatteningaLinkedListRecursion {


    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }
    private Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null; // important: remove next links
        return result;
    }

    // Function to flatten the linked list
    Node flatten(Node root) {
        if (root == null || root.next == null) return root;

        // Flatten the rest of the list
        root.next = flatten(root.next);

        // Merge current list with flattened right part
        root = merge(root, root.next);

        return root;
    }
}
