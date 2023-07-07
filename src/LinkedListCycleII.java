public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode midNode = new ListNode(0);
        ListNode roundNode = new ListNode(2, midNode);
        midNode.next = new ListNode(4, roundNode);
        ListNode list = new ListNode(3, roundNode);
        System.out.println(detectCycle(list));
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
        System.out.println(detectCycle(list1));
        ListNode listNode = new ListNode(1);
        System.out.println(detectCycle(listNode));
        System.out.println(detectCycle(null));

    }

    static ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode slow = head;
        ListNode fast = head;
        ListNode s = new ListNode();
        ListNode f = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                int cycleCount = 1;
                ListNode temp = slow.next;
                while (temp != slow) {
                    temp = temp.next;
                    cycleCount += 1;
                }
                length = cycleCount;
                s = slow;
                break;
            }
        }
        if (length == 0) {
            return null;
        }
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}
