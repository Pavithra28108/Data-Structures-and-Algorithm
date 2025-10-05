package Tree;

    public class FlattenBinaryTree {
        public void flatten(TreeNode root) {
            if (root == null) return;

            java.util.Stack<TreeNode> stack = new java.util.Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();

                // If right child exists, push it first (so left is processed first)
                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }

                // If stack still has nodes, set current.right to next
                if (!stack.isEmpty()) {
                    current.right = stack.peek();
                }

                // Set left to null (because linked list should use only right pointers)
                current.left = null;
            }
        }

        // Helper method to print the flattened list
        public void printFlattened(TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.right;
            }
            System.out.println("null");
        }

        // Example run
        public static void main(String[] args) {
            FlattenBinaryTree fb = new FlattenBinaryTree();

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(4);
            root.right.right = new TreeNode(6);

            fb.flatten(root);
            fb.printFlattened(root);
            // Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        }
}
