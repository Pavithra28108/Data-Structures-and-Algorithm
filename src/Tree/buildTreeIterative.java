package Tree;

import java.util.*;
public class buildTreeIterative {

    private int postIndex;  // points to current root in postorder
    private Map<Integer, Integer> inorderMap;  // value → index in inorder

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        // Build map for quick lookup of root index in inorder
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Last element in postorder is root
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder
        int inIndex = inorderMap.get(rootVal);

        // Important: build **right subtree first**, then left subtree
        root.right = helper(postorder, inIndex + 1, inEnd);
        root.left = helper(postorder, inStart, inIndex - 1);

        return root;
    }

    // Optional: print inorder for testing
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Example run
    public static void main(String[] args) {
        buildTreeIterative s = new buildTreeIterative();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root = s.buildTree(inorder, postorder);
        s.printInorder(root);  // Output: 9 3 15 20 7
    }
}