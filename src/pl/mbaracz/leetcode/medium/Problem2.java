package pl.mbaracz.leetcode.medium;

public class Problem2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode output = new ListNode();

        int l1Val = l1 != null ? l1.val : 0;
        int l2Val = l2 != null ? l2.val : 0;
        output.val = l1Val + l2Val;

        if (output.val > 9) {
            output.val -= 10;

            if (l1 != null && l1.next != null) l1.next.val += 1;
            else if (l2 != null && l2.next != null) l2.next.val += 1;
            else output.next = new ListNode(1);
        }

        if (output.next == null) {
            output.next = addTwoNumbers(
                l1 != null ? l1.next : null,
                l2 != null ? l2.next : null
            );
        }

        return output;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));

        ListNode current = addTwoNumbers(l1, l2);

        while (current.next != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println(current.val);
    }
}
