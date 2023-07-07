public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode.displayListNode(mergeTwoLists(list1, list2));
        ListNode.displayListNode(mergeTwoLists(null, new ListNode()));
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
