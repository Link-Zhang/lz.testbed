package cn.sh.lz.cig.C2P2;

import cn.sh.lz.cig.C2C.DoubleLinkedNode;
import cn.sh.lz.cig.C2C.LinkedNode;

/***
 * @author Link
 * @date 2020/07/30
 * @time 10:48
 */
public class RemoveLastKthNode {
    public LinkedNode removeLastKthNode(LinkedNode head, int k) {
        if (null == head || k < 1)
            return head;
        LinkedNode ahead = head;
        LinkedNode pre = null;
        LinkedNode cur = head;
        while (0 < k && null != ahead) {
            k--;
            ahead = ahead.getNext();
        }
        if (0 < k)
            return head;
        while (null != ahead) {
            ahead = ahead.getNext();
            pre = cur;
            cur = cur.getNext();
        }
        if (null == pre)
            return cur.getNext();
        if (null != cur)
            pre.setNext(cur.getNext());
        return head;
    }

    public LinkedNode removeLastKthNode1(LinkedNode head, int k) {
        if (null == head || 1 > k)
            return head;
        LinkedNode cur = head;
        while (null != cur) {
            k--;
            cur = cur.getNext();
        }
        if (0 == k)
            head = head.getNext();
        if (0 > k) {
            cur = head;
            while (++k != 0) {
                cur = cur.getNext();
            }
            cur.setNext(cur.getNext().getNext());
        }
        return head;
    }

    public DoubleLinkedNode removeLastKthNode(DoubleLinkedNode head, int k) {
        if (null == head | 1 > k)
            return head;
        DoubleLinkedNode ahead = head;
        DoubleLinkedNode pre = null;
        DoubleLinkedNode cur = head;
        while (0 < k && null != ahead) {
            k--;
            ahead = ahead.getNext();
        }
        if (0 < k)
            return head;
        while (null != ahead) {
            ahead = ahead.getNext();
            pre = cur;
            cur = cur.getNext();
        }
        if (null == pre) {
            cur.getNext().setLast(null);
            return cur.getNext();
        }
        if (null != cur) {
            if (null != cur.getNext()) {
                cur.getNext().setLast(pre);
                pre.setNext(cur.getNext());
            } else {
                pre.setNext(null);
            }
        }
        return head;
    }

    public DoubleLinkedNode removeLastKthNode1(DoubleLinkedNode head, int k) {
        if (null == head || k < 1)
            return head;
        DoubleLinkedNode cur = head;
        while (null != cur) {
            k--;
            cur = cur.getNext();
        }
        if (0 == k) {
            head = head.getNext();
            head.setLast(null);
        }
        if (0 > k) {
            cur = head;
            while (++k != 0) {
                cur = cur.getNext();
            }
            DoubleLinkedNode newNext = cur.getNext().getNext();
            cur.setNext(newNext);
            if (null != newNext)
                newNext.setLast(cur);
        }
        return head;
    }
}
