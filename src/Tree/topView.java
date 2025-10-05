package Tree;


import java.util.*;
public class topView {

    static class Pair {
        TreeNode node;
        int hd; // horizontal distance
        Pair(TreeNode n, int h) {
            node = n;
            hd = h;
        }
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new HashMap<>(); // hd -> node value
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));
        int minHd = 0, maxHd = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int hd = p.hd;
            TreeNode node = p.node;

            // only put if hd not already filled (top-most node)
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            minHd = Math.min(minHd, hd);
            maxHd = Math.max(maxHd, hd);

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // Collect results from leftmost to rightmost hd
        for (int i = minHd; i <= maxHd; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    // Driver
    public static void main(String[] args) {
        topView sol = new topView();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        List<Integer> topViewList = sol.topView(root);
        System.out.println(topViewList); // Output: [2, 1, 3, 6]
    }
}
