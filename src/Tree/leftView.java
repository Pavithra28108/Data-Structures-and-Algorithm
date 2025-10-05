package Tree;

import java.util.*;
public class leftView {

    public List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // number of nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // first node of this level
                if (i == 0) result.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return result;
    }

    // Driver
    public static void main(String[] args) {
        leftView  sol = new leftView ();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        List<Integer> leftViewList = sol.leftView(root);
        System.out.println(leftViewList); // Output: [1, 2, 4, 5, 6]
    }

}
