package HeapAndPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
public class MergeKSortedLL {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to get the smallest node at each step
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(ln -> ln.val));

        // Add the first node of each list to the heap
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode head = null, curr = null;

        while (!pq.isEmpty()) {
            // Extract the node with the smallest value
            ListNode topNode = pq.poll();

            // Add its next node to the heap (if exists)
            if (topNode.next != null) pq.add(topNode.next);

            // Build the merged linked list
            if (head == null) {
                head = topNode;
            } else {
                curr.next = topNode;
            }

            curr = topNode;
        }

        return head;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        // Create sample lists
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        // Merge lists
        ListNode mergedHead = mergeKLists(lists);

        // Print merged list
        System.out.println("Merged K Sorted Lists:");
        printList(mergedHead);
    }
}

   // Metric	Complexity
  //  Time	O(N log k) — N = total nodes, k = number of lists
   //     Space	O(k) — heap stores at most k nodes at a time
