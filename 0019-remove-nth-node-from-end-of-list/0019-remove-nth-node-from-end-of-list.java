class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;
        int c = 0;

        while (cur != null) {
            c++;
            cur = cur.next;
        }

        n = c - n;

        if (n == 0)
            return head.next;

        c = 0;
        cur = head;

        while (cur.next != null) {

            if (c == n - 1) {
                cur.next = cur.next.next;
                break;
            }

            c++;
            cur = cur.next;
        }

        return head;
    }
}