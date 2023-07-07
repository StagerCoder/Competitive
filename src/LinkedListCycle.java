public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode midNode = new ListNode(0);
        ListNode roundNode = new ListNode(2, midNode);
        midNode.next = new ListNode(4, roundNode);
        ListNode list = new ListNode(3, roundNode);
        System.out.println(hasCycle(list));
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
        System.out.println(hasCycle(list1));
        ListNode listNode = new ListNode(1);
        System.out.println(hasCycle(listNode));
    }

    static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode start = head;
        ListNode first = head.next;
        while (first != null && first.next != null) {
            if (start == first) {
                return true;
            } else {
                start = start.next;
                first = first.next.next;
            }
        }
        return false;
    }
}
