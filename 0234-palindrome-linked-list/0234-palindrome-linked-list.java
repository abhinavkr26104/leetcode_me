class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode cur = slow;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode left = head;
        ListNode right = prev;

        while (right != null) {

            if (left.val != right.val)
                return false;

            left = left.next;
            right = right.next;
        }

        return true;
    }
}