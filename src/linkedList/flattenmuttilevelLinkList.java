package linkedList;

import java.util.Stack;

public class flattenmuttilevelLinkList {

        public TriNode flatten(TriNode head) {
            if (head == null) return head;

            Stack<TriNode> stack = new Stack<>();
            TriNode curr = head;

            while (curr != null) {
                if (curr.child != null) {
                    if (curr.next != null) {
                        stack.push(curr.next);
                    }

                    curr.next = curr.child;
                    curr.child.prev = curr;
                    curr.child = null;
                }

                if (curr.next == null && !stack.isEmpty()) {
                    TriNode TriNode = stack.pop();
                    curr.next = TriNode;
                    TriNode.prev = curr;
                }

                curr = curr.next;
            }

            return head;
        }

    public class Main {
        public static void main(String[] args) {
            // Build list: 1 - 2 - 3 - 4 - 5
            TriNode head = new TriNode(1);
            head.next = new TriNode(2);
            head.next.prev = head;
            head.next.next = new TriNode(3);
            head.next.next.prev = head.next;
            head.next.next.next = new TriNode(4);
            head.next.next.next.prev = head.next.next;
            head.next.next.next.next = new TriNode(5);
            head.next.next.next.next.prev = head.next.next.next;

            // Add child: 3 -> (6 - 7)
            TriNode child1 = new TriNode(6);
            child1.next = new TriNode(7);
            child1.next.prev = child1;
            head.next.next.child = child1; // 3.child = 6

            // Add deeper child: 7 -> (8)
            TriNode child2 = new TriNode(8);
            child1.next.child = child2; // 7.child = 8

            // Flatten
            flattenmuttilevelLinkList sol = new flattenmuttilevelLinkList();
            TriNode flatHead = sol.flatten(head);

            // Print flattened list
            TriNode curr = flatHead;
            System.out.print("Flattened list: ");
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
        }
    }

}


class TriNode {
    public int val;
    public TriNode prev;
    public TriNode next;
    public TriNode child;

    public TriNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}