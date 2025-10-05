package linkedList;

public class flattenLinkedListDivideandConquer {

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

    // Merge two bottom-linked sorted lists
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

        result.next = null; // discard "next" after flattening
        return result;
    }

    // Divide & Conquer Flatten
    Node flatten(Node root) {
        // Base case
        if (root == null || root.next == null) return root;

        // Divide: flatten the list starting from next
        Node mid = root.next;
        root.next = null;  // detach for clarity

        // Conquer: flatten both halves
        Node left = flatten(root);
        Node right = flatten(mid);

        // Combine: merge both lists
        return merge(left, right);
    }
}
