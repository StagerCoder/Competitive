public class LengthOfLinkedListCycle {

    public static void main(String[] args) {
        ListNode midNode = new ListNode(0);
        ListNode roundNode = new ListNode(2, midNode);
        midNode.next = new ListNode(4, roundNode);
        ListNode list = new ListNode(3, roundNode);
        System.out.println(countCycle(list));
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
        System.out.println(countCycle(list1));
        ListNode listNode = new ListNode(1);
        System.out.println(countCycle(listNode));
        System.out.println(countCycle(null));
    }

    static int countCycle(ListNode node) {
        if (node == null) {
            return 0;
        }
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                int count = 0;
                fast = fast.next;
                while (fast != slow) {
                    count += 1;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }

}
