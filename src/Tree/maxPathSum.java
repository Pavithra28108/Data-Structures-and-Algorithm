package Tree;

public class maxPathSum {

    // Global variable to store the max path sum
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    // Returns the max path sum that can be extended upwards
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Compute max path on left and right
        // If negative, we don't include it (so take max with 0)
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Max path that passes through this node (could be the answer)
        int currentPath = node.val + left + right;

        // Update global max
        maxSum = Math.max(maxSum, currentPath);

        // Return max path starting at this node going up
        return node.val + Math.max(left, right);
    }
}
