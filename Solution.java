public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastNodeBeforeReversalSection = head;
        int count = 1;
        while (count++ < left - 1) {
            lastNodeBeforeReversalSection = lastNodeBeforeReversalSection.next;
        }

        /*
        'nodeToStartTheReversal' is also the node that will become the last node
        in the reversed part of the linked list.
        It must be stored so that the reversed part is connected to the part
        of the linked list that follows the reversed section.        
         */
        ListNode nodeToStartTheReversal = left > 1 ? lastNodeBeforeReversalSection.next : lastNodeBeforeReversalSection;
        ListNode current = nodeToStartTheReversal;
        ListNode prev = null;

        count = left;
        while (count++ <= right) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        // Now 'prev' is the first node in the reversed section.
        lastNodeBeforeReversalSection.next = prev;

        // Now 'current' is the first node in the part that follows the reversed section.
        nodeToStartTheReversal.next = current;

        head = left > 1 ? head : prev;

        return head;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
