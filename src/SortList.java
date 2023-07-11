
public class SortList {

    public static void main(String[] args) {
        ListNode list = new ListNode(7, new ListNode(1, new ListNode(18, new ListNode(2, new ListNode(4)))));
        ListNode.displayListNode(sortList(list));
    }

    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = midElement(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return sortMergeLinkList(left, right);
    }

    static ListNode midElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = new ListNode();
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = null;
        return slow;
    }

    static ListNode sortMergeLinkList(ListNode list1, ListNode list2) {
        ListNode firstNodeOfAns = new ListNode();
        ListNode ans = firstNodeOfAns;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                ans.next = list2;
                list2 = list2.next;
            } else {
                ans.next = list1;
                list1 = list1.next;
            }
            ans = ans.next;
        }
        while (list1 != null) {
            ans.next = list1;
            list1 = list1.next;
            ans = ans.next;
        }
        while (list2 != null) {
            ans.next = list2;
            list2 = list2.next;
            ans = ans.next;
        }
        return firstNodeOfAns.next;
    }
}
