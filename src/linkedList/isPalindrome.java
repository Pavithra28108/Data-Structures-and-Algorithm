package linkedList;

public class isPalindrome {

    public boolean isPalindrome(LinkedList.Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle (slow will be at middle)
        LinkedList.Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        LinkedList.Node secondHalf = reverseList(slow);

        // Step 3: Compare first and second half
        LinkedList.Node p1 = head;
        LinkedList.Node p2 = secondHalf;
        while (p2 != null) { // only need to compare second half
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Helper to reverse a linked list
    private LinkedList.Node reverseList(LinkedList.Node head) {
        LinkedList.Node prev = null;
        LinkedList.Node curr = head;
        while (curr != null) {
            LinkedList.Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }


    // Helper to build linked list from array
    private static LinkedList.Node buildList(int[] arr) {
        if (arr.length == 0) return null;
        LinkedList.Node head = new LinkedList.Node(arr[0]);
        LinkedList.Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new LinkedList.Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        isPalindrome solution = new isPalindrome();

        // Example 1: [1,2,2,1] -> true
        int[] arr1 = {1, 2, 2, 1};
        LinkedList.Node head1 = buildList(arr1);
        System.out.println("Example 1: " + solution.isPalindrome(head1)); // true

        // Example 2: [1,2] -> false
        int[] arr2 = {1, 2};
        LinkedList.Node head2 = buildList(arr2);
        System.out.println("Example 2: " + solution.isPalindrome(head2)); // false

        // Example 3: [1,2,3,2,1] -> true
        int[] arr3 = {1, 2, 3, 2, 1};
       LinkedList.Node head3 = buildList(arr3);
        System.out.println("Example 3: " + solution.isPalindrome(head3)); // true
    }
}
