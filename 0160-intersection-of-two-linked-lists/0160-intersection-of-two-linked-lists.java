class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {

            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }

        return p;
    }
}