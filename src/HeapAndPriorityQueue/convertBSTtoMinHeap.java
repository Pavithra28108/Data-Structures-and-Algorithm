package HeapAndPriorityQueue;

import java.util.*;

    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }


    public class convertBSTtoMinHeap {

        // Step 1: Store inorder traversal (sorted)
        private static void inorder(Node root, List<Integer> arr) {
            if (root == null) return;
            inorder(root.left, arr);
            arr.add(root.data);
            inorder(root.right, arr);
        }

        // Step 2: Replace node data in preorder traversal
        private static void preorderFill(Node root, List<Integer> arr, int[] index) {
            if (root == null) return;
            root.data = arr.get(index[0]++);  // fill data and move index
            preorderFill(root.left, arr, index);
            preorderFill(root.right, arr, index);
        }

        // Step 3: Preorder traversal for output
        private static void preorderPrint(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorderPrint(root.left);
            preorderPrint(root.right);
        }

        // Function to convert BST → Min Heap
        public static void convertToMinHeap(Node root) {
            List<Integer> arr = new ArrayList<>();
            inorder(root, arr);             // get sorted values
            int[] index = {0};              // index pointer for preorder filling
            preorderFill(root, arr, index); // fill nodes as Min Heap
        }

        public static void main(String[] args) {
        /*
                4
               / \
              2   6
             / \ / \
            1  3 5  7
        */

            Node root = new Node(4);
            root.left = new Node(2);
            root.right = new Node(6);
            root.left.left = new Node(1);
            root.left.right = new Node(3);
            root.right.left = new Node(5);
            root.right.right = new Node(7);

            convertToMinHeap(root);
            System.out.println("Preorder traversal of Min Heap:");
            preorderPrint(root);
        }
}
