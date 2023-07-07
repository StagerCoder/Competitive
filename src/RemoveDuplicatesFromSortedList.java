public class RemoveDuplicatesFromSortedList {


    public static void main(String[] args) {
        ListNode a3 = new ListNode(2);
        ListNode a2 = new ListNode(1, a3);
        ListNode a1 = new ListNode(1, a2);
        ListNode.displayListNode(deleteDuplicates(a1));
    }


    static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
