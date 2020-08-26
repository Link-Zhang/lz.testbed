package cn.sh.lz.cig.C2P7;

import cn.sh.lz.cig.C2P1.LinkedNode;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/08/26
 * @time 10:26
 */
public class Palindrome {
    //    时间复杂度O(n),空间复杂度O(1)
    public boolean isPalindrome(LinkedNode head) {
        if (null == head || null == head.getNext()) {
            return true;
        }
        LinkedNode n1 = head;
        LinkedNode n2 = head;
        while (null != n2.getNext() && null != n2.getNext().getNext()) {
            n1 = n1.getNext();
            n2 = n2.getNext().getNext();
        }
        n2 = n1.getNext();
        n1.setNext(null);
        LinkedNode n3 = null;
        while (null != n2) {
//            右半反转
            n3 = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = n3;
        }
        n3 = n1; //rightHead
        n2 = head; //leftHead
        boolean result = true;
        while (null != n1 && null != n2) {
            if (n1.getData() != n2.getData()) {
                result = false;
                break;
            }
            n1 = n1.getNext();
            n2 = n2.getNext();
        }
//      恢复右半
        n1 = n3.getNext();
        n3.setNext(null);
        while (null != n1) {
            n2 = n1.getNext();
            n1.setNext(n3);
            n3 = n1;
            n1 = n2;
        }
        return true;
    }

    //    时间复杂度O(n),空间复杂度O(n)
    public boolean isPalindrome1(LinkedNode head) {
        Stack<LinkedNode> stack = new Stack<>();
        LinkedNode cur = head;
        while (null != cur) {
            stack.push(cur);
            cur = cur.getNext();
        }
        while (null != head) {
            if (head.getData() != stack.pop().getData()) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }

    //    时间复杂度O(n),空间复杂度O(n)
    public boolean isPalindrome2(LinkedNode head) {
        if (null == head || null == head.getNext()) {
            return true;
        }
        LinkedNode right = head.getNext();
        LinkedNode cur = head;
        while (null != cur.getNext() && null != cur.getNext().getNext()) {
            right = right.getNext();
            cur = cur.getNext().getNext();
        }
        Stack<LinkedNode> stack = new Stack<>();
        while (null != right) {
            stack.push(right);
            right = right.getNext();
        }
        while (!stack.isEmpty()) {
            if (head.getData() != stack.pop().getData()) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }
}
