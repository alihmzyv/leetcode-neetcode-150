package linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode next = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                next.next = list1;
                next = next.next;
                list1 = list1.next;
            } else {
                next.next = list2;
                next = next.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            while (list1 != null) {
                next.next = list1;
                next = next.next;
                list1 = list1.next;
            }
        } else if (list2 != null) {
            while (list2 != null) {
                next.next = list2;
                next = next.next;
                list2 = list2.next;
            }
        }

        return dummy.next;
    }

    //TODO: look at other solutions
}
