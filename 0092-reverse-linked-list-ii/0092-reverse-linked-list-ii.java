class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // reach node before left
        for (int i = 1; i < left; i++)
            prev = prev.next;

        ListNode cur = prev.next;

        // reverse right-left+1 nodes
        for (int i = 0; i < right - left; i++) {

            ListNode next = cur.next;

            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}