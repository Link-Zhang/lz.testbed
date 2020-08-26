package cn.sh.lz.cig.C2P4;

import cn.sh.lz.cig.C2P1.LinkedNode;
import cn.sh.lz.cig.C2P2.DoubleLinkedNode;

/***
 * @author Link
 * @date 2020/08/25
 * @time 10:06
 */
public class Reverse {
    public LinkedNode reverse(LinkedNode head) {
        LinkedNode pre = null;
        LinkedNode next;
        while (null != head) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    public DoubleLinkedNode reverse(DoubleLinkedNode head) {
        DoubleLinkedNode pre = null;
        DoubleLinkedNode next;
        while (null != head) {
            next = head.getNext();
            head.setNext(pre);
            head.setLast(next);
            pre = head;
            head = next;
        }
        return pre;
    }
}
