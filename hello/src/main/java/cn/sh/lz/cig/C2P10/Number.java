package cn.sh.lz.cig.C2P10;

import java.util.Stack;

/**
 * Created by Link at 09:37 on 2021/05/11.
 */
public class Number {
    //    时间复杂度O(n),空间复杂度O(n)
    public NumberLinkedNode add(NumberLinkedNode head1, NumberLinkedNode head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (null != head1) {
            s1.push(head1.getValue());
            head1 = head1.getNext();
        }
        while (null != head2) {
            s2.push(head2.getValue());
            head2 = head2.getNext();
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        NumberLinkedNode node = null;
        NumberLinkedNode pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new NumberLinkedNode(n % 10);
            node.setNext(pre);
            ca = n / 10;
        }
        if (1 == ca) {
            pre = node;
            node = new NumberLinkedNode(1);
            node.setNext(pre);
        }
        return node;
    }

    public NumberLinkedNode reverseLinkedList(NumberLinkedNode head) {
        NumberLinkedNode pre = null;
        NumberLinkedNode next = null;
        NumberLinkedNode cur = head;
        while (null != cur) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //    时间复杂度O(n),空间复杂度O(1)
    public NumberLinkedNode add2(NumberLinkedNode head1, NumberLinkedNode head2) {
        head1 = reverseLinkedList(head1);
        head2 = reverseLinkedList(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        NumberLinkedNode c1 = head1;
        NumberLinkedNode c2 = head2;
        NumberLinkedNode node = null;
        NumberLinkedNode pre = null;
        while (null != c1 || null != c2) {
            n1 = null != c1 ? c1.getValue() : 0;
            n2 = null != c2 ? c2.getValue() : 0;
            n = n1 + n2 + ca;
            node = new NumberLinkedNode(n % 10);
            node.setNext(pre);
            pre = node;
            ca = n / 10;
            c1 = null != c1 ? c1.getNext() : null;
            c2 = null != c2 ? c2.getNext() : null;
        }
        if (1 == ca) {
            pre = node;
            node = new NumberLinkedNode(1);
            node.setNext(pre);
        }
        reverseLinkedList(head1);
        reverseLinkedList(head2);
        return node;
    }

    //    时间复杂度O(n),空间复杂度O(1)
    //    head1>head2
    public NumberLinkedNode minus(NumberLinkedNode head1, NumberLinkedNode head2) {
        head1 = reverseLinkedList(head1);
        head2 = reverseLinkedList(head2);
        int bo = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        NumberLinkedNode c1 = head1;
        NumberLinkedNode c2 = head2;
        NumberLinkedNode node = null;
        NumberLinkedNode pre = null;
        while (null != c2) {
            n1 = null != c1 ? c1.getValue() : 0;
            n2 = c2.getValue();
            n = n1 - n2 + bo;
            if (n < 0) {
                bo--;
                n = n + 10;
            }
            node = new NumberLinkedNode(n);
            node.setNext(pre);
            pre = node;
            c1 = null != c1 ? c1.getNext() : null;
            c2 = c2.getNext();
        }
        reverseLinkedList(head1);
        reverseLinkedList(head2);
        return node;
    }
}
