public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.displayListNode(reverseBetween(list, 2, 4));
        ListNode list2 = new ListNode(5);
        ListNode.displayListNode(reverseBetween(list2, 1, 1));
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ans = head;
        int count = 0;
        if (left >= right) {
            return head;
        }
        ListNode leftNode = null;
        ListNode prevNode = null;

        while (head != null) {
            count += 1;
            if (left > count) {
                prevNode = head;
            }
            if (left == count) {
                leftNode = head;
                break;
            }
            head = head.next;
        }
        head = ans;
        ListNode last = prevNode;
        ListNode newEnd = leftNode;
        ListNode next = leftNode.next;
        for (int i = 0; leftNode != null && i < right - left + 1; i++) {
            leftNode.next = prevNode;
            prevNode = leftNode;
            leftNode = next;
            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = prevNode;
        } else {
            head = prevNode;
        }
        newEnd.next = leftNode;
        return head;
    }
}
