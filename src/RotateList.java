public class RotateList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2));
        ListNode.displayListNode(rotateRight(listNode, 2));
    }

    static ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        ListNode eHead = head;
        ListNode copyHead = head;
        ListNode previous = null;
        int length = 0;
        while (head != null) {
            length += 1;
            previous = head;
            head = head.next;
        }
        if (length == k || k % length == 0) {
            return eHead;
        }
        ListNode copyHeadPrevious = copyHead;
        for (int i = 0; i < length - k % length; i++) {
            copyHeadPrevious = copyHead;
            copyHead = copyHead.next;
        }
        copyHeadPrevious.next = null;
        previous.next = eHead;
        eHead = copyHead;
        return eHead;
    }

}
