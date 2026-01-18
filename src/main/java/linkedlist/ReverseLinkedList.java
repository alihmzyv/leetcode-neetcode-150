package linkedlist;

public class ReverseLinkedList {

    //time - O(n), space - O(1)
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    //TODO: look at recursive solution
}
