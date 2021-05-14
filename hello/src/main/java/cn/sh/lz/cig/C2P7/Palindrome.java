package cn.sh.lz.cig.C2P7;

import cn.sh.lz.cig.C2C.LinkedNode;
import cn.sh.lz.cig.C2C.Node;

import java.util.Stack;

/***
 * @author Link
 * @date 2020/08/26
 * @time 10:26
 */
public class Palindrome {
    //    时间复杂度O(n),空间复杂度O(n)
    public boolean isPalindrome(LinkedNode head) {
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

    //    时间复杂度O(n),空间复杂度O(1)
    public boolean isPalindrome3(LinkedNode head) {
        if (null == head || null == head.getNext()) {
            return true;
        }
        LinkedNode leftNode = head;
        LinkedNode middleLeftNode = head;
        LinkedNode rightNode = head;
        while (null != rightNode.getNext() && null != rightNode.getNext().getNext()) {
            middleLeftNode = middleLeftNode.getNext();
            rightNode = rightNode.getNext().getNext();
        }
        LinkedNode middleRightNode = middleLeftNode.getNext();
        middleLeftNode.setNext(null);
        Node node = new Node();
        LinkedNode reversedRightHead = node.reverse(middleRightNode);
        boolean result = true;
        while (null != leftNode && null != rightNode) {
            if (leftNode.getData() != rightNode.getData()) {
                result = false;
                break;
            }
            leftNode = leftNode.getNext();
            rightNode = rightNode.getNext();
        }
        middleRightNode = node.reverse(reversedRightHead);
        middleLeftNode.setNext(middleRightNode);
        return result;
    }
}
