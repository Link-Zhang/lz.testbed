package cn.sh.lz.cig.C2P10;

import cn.sh.lz.cig.C2C.LinkedNode;
import cn.sh.lz.cig.C2C.Node;

import java.util.Stack;

/**
 * Created by Link at 09:37 on 2021/05/11.
 */
public class Number {
    //    时间复杂度O(n),空间复杂度O(n)
    public LinkedNode add(LinkedNode head1, LinkedNode head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (null != head1) {
            s1.push(head1.getData());
            head1 = head1.getNext();
        }
        while (null != head2) {
            s2.push(head2.getData());
            head2 = head2.getNext();
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        LinkedNode cur = null;
        LinkedNode pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = cur;
            cur = new LinkedNode(n % 10);
            cur.setNext(pre);
            ca = n / 10;
        }
        if (1 == ca) {
            pre = cur;
            cur = new LinkedNode(1);
            cur.setNext(pre);
        }
        return cur;
    }

    //    时间复杂度O(n),空间复杂度O(1)
    public LinkedNode add2(LinkedNode head1, LinkedNode head2) {
        Node node = new Node();
        head1 = node.reverse(head1);
        head2 = node.reverse(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        LinkedNode c1 = head1;
        LinkedNode c2 = head2;
        LinkedNode cur = null;
        LinkedNode pre = null;
        while (null != c1 || null != c2) {
            n1 = null != c1 ? c1.getData() : 0;
            n2 = null != c2 ? c2.getData() : 0;
            n = n1 + n2 + ca;
            cur = new LinkedNode(n % 10);
            cur.setNext(pre);
            pre = cur;
            ca = n / 10;
            c1 = null != c1 ? c1.getNext() : null;
            c2 = null != c2 ? c2.getNext() : null;
        }
        if (1 == ca) {
            pre = cur;
            cur = new LinkedNode(1);
            cur.setNext(pre);
        }
        node.reverse(head1);
        node.reverse(head2);
        return cur;
    }

    //    时间复杂度O(n),空间复杂度O(1)
    //    head1>=head2
    public LinkedNode minus(LinkedNode head1, LinkedNode head2) {
        Node node = new Node();
        head1 = node.reverse(head1);
        head2 = node.reverse(head2);
        int bo = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        LinkedNode c1 = head1;
        LinkedNode c2 = head2;
        LinkedNode cur = null;
        LinkedNode pre = null;
        while (null != c1 || null != c2) {
            n1 = null != c1 ? c1.getData() : 0;
            n2 = null != c2 ? c2.getData() : 0;
            n = n1 - n2 - bo;
            if (n < 0) {
                bo = 1;
                n = n + 10;
            } else {
                bo = 0;
            }
            cur = new LinkedNode(n);
            cur.setNext(pre);
            pre = cur;
            c1 = null != c1 ? c1.getNext() : null;
            c2 = null != c2 ? c2.getNext() : null;
        }
        node.reverse(head1);
        node.reverse(head2);
        return cur;
    }
}
