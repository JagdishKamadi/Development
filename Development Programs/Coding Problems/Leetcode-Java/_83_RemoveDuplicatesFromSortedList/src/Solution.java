/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode travers = head;

        while (travers != null && travers.next != null) {

            if (travers.val == travers.next.val) {
                travers.next = travers.next.next;
            } else {
                travers = travers.next;
            }
        }
        return head;
    }
}

