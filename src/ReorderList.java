public class ReorderList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(listNode);
        ListNode.displayListNode(listNode);
    }

    static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = midNode(head);
        ListNode reverseList = reverseLinkList(mid);
        while (head != null && reverseList != null) {
            ListNode temp = head.next;
            head.next = reverseList;
            head = temp;

            temp = reverseList.next;
            reverseList.next = head;
            reverseList = temp;
        }
        if (head != null) {
            head.next = null;
        }
    }

    static ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode reverseLinkList(ListNode head) {
        ListNode previous = null;
        ListNode present = head;
        ListNode next = present.next;
        while (present != null) {
            present.next = previous;
            previous = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return previous;
    }

}
