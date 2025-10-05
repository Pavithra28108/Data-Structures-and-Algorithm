package linkedList;

import java.util.Queue;

public class stackUsingQueue {

    Queue<Integer> q;

    public stackUsingQueue() {
        q = (Queue<Integer>) new LinkedList();
    }

    public void push(int x) {
        q.offer(x);
        int size = q.size();
        // rotate the queue: move all older elements behind the new one
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.isEmpty() ? -1 : q.poll();
    }

    public int top() {
        return q.isEmpty() ? -1 : q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}