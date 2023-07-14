public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode.displayListNode(reverseKGroup(listNode, 4));
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode present = head;
        while (true) {
            ListNode last = previous;
            ListNode newEnd = present;
            ListNode next = present.next;
            if (checking(present, k)) {
                for (int i = 0; i < k && present != null; i++) {
                    present.next = previous;
                    previous = present;
                    present = next;
                    if (next != null) {
                        next = next.next;
                    }
                }
                if (last != null) {
                    last.next = previous;
                } else {
                    head = previous;
                }
                newEnd.next = present;
            } else {
                while (present != null) {
                    present = present.next;
                }
            }
            if (present == null) {
                break;
            }
            previous = newEnd;
        }
        return head;
    }

    static boolean checking(ListNode node, int k) {
        if (k == 1 && node != null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return checking(node.next, k - 1);
    }

}
