class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head to simplify code
        ListNode current = dummyHead; // Pointer to build the new list
        int carry = 0; // Initialize carry to 0

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int sum = carry; // Start with carry
            if (l1 != null) {
                sum += l1.val; // Add value from l1 if present
                l1 = l1.next; // Move to next node in l1
            }
            if (l2 != null) {
                sum += l2.val; // Add value from l2 if present
                l2 = l2.next; // Move to next node in l2
            }

            carry = sum / 10; // Calculate new carry
            current.next = new ListNode(sum % 10); // Create a new node with the digit
            current = current.next; // Move to the newly created node
        }

        // If carry is still left, add a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // Return the next of dummy head, which is the actual result
    }
}
