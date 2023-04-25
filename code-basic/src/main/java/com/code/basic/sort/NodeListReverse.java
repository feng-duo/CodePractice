package com.code.basic.sort;


/**
 * @author FengDuo
 * @date 2023/3/13 10:53
 */
public class NodeListReverse {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode current = node;
        ListNode next = null;
        while (null != current) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        System.out.println("Original linked list: ");
        printLinkedList(a);
        System.out.println("Reversed linked list: ");
        ListNode reversed = reverse(a);
        printLinkedList(reversed);
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");
    }
}
