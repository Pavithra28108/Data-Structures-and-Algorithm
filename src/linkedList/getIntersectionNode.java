package linkedList;

public class getIntersectionNode {

    // Function to get intersection node
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

       Node pA = headA;
        Node pB = headB;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA; // Either intersection node or null
    }

    public static void main(String[] args) {
        /*
         Example:
         listA = [4,1,8,4,5]
         listB = [5,6,1,8,4,5]
         They intersect at node with value = 8
        */

        // Creating shared part [8 -> 4 -> 5]
        Node intersect = new Node(8);
        intersect.next = new Node(4);
        intersect.next.next = new Node(5);

        // Creating listA [4 -> 1 -> (intersect)]
        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = intersect;

        // Creating listB [5 -> 6 -> 1 -> (intersect)]
        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(1);
        headB.next.next.next = intersect;

        // Find intersection
        Node result = getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersected at '" + result.data + "'");
        } else {
            System.out.println("No intersection");
        }
    }
}
