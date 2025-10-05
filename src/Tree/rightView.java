package Tree;

import java.util.*;
public class rightView {

    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // number of nodes at this level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // last node of this level → rightmost
                if (i == size - 1) result.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return result;
    }

    // Driver
    public static void main(String[] args) {
        rightView sol = new rightView();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> rightViewList = sol.rightView(root);
        System.out.println(rightViewList); // Output: [1, 3, 4]
    }
}
