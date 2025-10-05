package Tree;

import java.util.*;

public class VerticalOrderTraversal {

    // BFS + TreeMap
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> row -> min-heap (values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue for BFS: store node + row + col
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0, 0});

        while (!q.isEmpty()) {
            Object[] arr = q.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1], col = (int) arr[2];

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) q.offer(new Object[]{node.left, row + 1, col - 1});
            if (node.right != null) q.offer(new Object[]{node.right, row + 1, col + 1});
        }

        // Build result
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : colMap.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }

    // Example run
    public static void main(String[] args) {
        VerticalOrderTraversal v = new VerticalOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(v.verticalTraversal(root));
        // Expected: [[9],[3,15],[20],[7]]
    }
}
