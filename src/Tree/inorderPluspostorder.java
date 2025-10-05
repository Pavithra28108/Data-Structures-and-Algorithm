package Tree;

import java.util.*;
public class inorderPluspostorder {

    int preIndex = 0; // global pointer for preorder
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // build map for inorder index lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // pick current root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // find root index in inorder
        int inIndex = inorderMap.get(rootVal);

        // build left and right subtree
        root.left = helper(preorder, inStart, inIndex - 1);
        root.right = helper(preorder, inIndex + 1, inEnd);

        return root;
    }

    // inorder print for testing
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        inorderPluspostorder s = new inorderPluspostorder();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};

        TreeNode root = s.buildTree(preorder, inorder);
        s.printInorder(root);  // Output: 9 3 15 20 7
    }
}
