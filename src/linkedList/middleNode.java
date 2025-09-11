package linkedList;


//Floyd’s Cycle Detection Algorithm (Tortoise & Hare).

public class middleNode {

    public LinkedList.Node middleNode(LinkedList.Node head) {
        LinkedList.Node slow = head;
        LinkedList.Node fast = head;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now pointing at the middle node
        return slow;
    }
}
