package com.code.basic.algorithm.node;


/**
 * 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @author FengDuo
 * @date 2023/11/16 14:58
 */
public class AddTwoNodes {

    public static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cur = result;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (l1 != null || l2 != null || sum > 0) {
            ListNode temp = new ListNode();
            cur.next = temp;
            cur = cur.next;
            if (l1 != null) {
                i = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                j = l2.val;
                l2 = l2.next;
            }
            sum += i + j;
            if (sum >= 10) {
                temp.val = sum - 10;
                sum = 1;
            } else {
                temp.val = sum;
                sum = 0;
            }
            i = 0;
            j = 0;
        }
        return result.next;
    }

/*
    // 递归做法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumber(l1, l2, 0);
    }

    public ListNode addNumber(ListNode l1, ListNode l2, Integer extraNum) {
        if (l2 != null || l1 != null || extraNum > 0) {
            ListNode node = new ListNode(0);
            int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            node.val = extraNum + num;
            if (node.val > 9) {
                extraNum = 1;
                node.val -= 10;
            } else {
                extraNum = 0;
            }
            node.next = addNumber(l1 == null ? null : l1.next, l2 == null ? null : l2.next, extraNum);
            return node;
        }
        return null;
    }*/

}
