package linkedList;

public class stackUsingLL {

    class StackNode {
        int data;
        StackNode next;

        StackNode(int d) {
            data = d;
            next = null;
        }
    }
    StackNode top;

    // Push element into stack
    void push(int x) {
        StackNode newNode = new StackNode(x);
        newNode.next = top; // link new node with current top
        top = newNode;      // update top
    }

    // Pop element from stack
    int pop() {
        if (top == null) {
            return -1; // stack is empty
        }
        int val = top.data;
        top = top.next; // move top down
        return val;
    }


    public class Main {
        public static void main(String[] args) {
            stackUsingLL stack = new stackUsingLL();

            int[][] queries = { {1,2}, {1,3}, {2}, {1,4}, {2} };

            for (int[] q : queries) {
                if (q[0] == 1) {
                    stack.push(q[1]);
                } else if (q[0] == 2) {
                    System.out.print(stack.pop() + " ");
                }
            }
            // Output: 3 4
        }
}}
