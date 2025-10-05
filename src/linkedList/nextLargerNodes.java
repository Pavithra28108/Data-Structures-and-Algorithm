package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class nextLargerNodes {

    public int[] nextLargerNodes(LinkedList.Node head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.data);
            head = head.next;
        }

        int n = values.size();
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
                result[stack.pop()] = values.get(i);
            }
            stack.push(i);
        }

        // Remaining indices in stack have no greater element, so remain 0
        return result;
    }


    public class Main {
        // Utility function to print array
        public static void printArray(int[] arr) {
            for (int x : arr) System.out.print(x + " ");
            System.out.println();
        }

        public static void main(String[] args) {
            // Example: 2 -> 1 -> 5
            LinkedList.Node head = new LinkedList.Node(2);
            head.next = new LinkedList.Node(1);
            head.next.next = new LinkedList.Node(5);

            nextLargerNodes sol = new nextLargerNodes();
            int[] ans = sol.nextLargerNodes(head);

            System.out.print("Next Greater Nodes: ");
            printArray(ans);  // Output: 5 5 0
        }
    }
}