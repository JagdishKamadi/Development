class _203_RemoveLinkedListElements
{
	public static void main(String[] args) {
		
	}

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }

        ListNode firstNode = new ListNode();
        firstNode.next = head;
        ListNode curr = ListNode;

        while(curr.next!=null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }

        return firstNode.next;
    }
}