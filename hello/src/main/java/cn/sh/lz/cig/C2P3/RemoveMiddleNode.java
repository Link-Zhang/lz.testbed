package cn.sh.lz.cig.C2P3;

import cn.sh.lz.cig.C2C.LinkedNode;

/***
 * @author Link
 * @date 2020/07/30
 * @time 12:07
 */
public class RemoveMiddleNode {
    public LinkedNode removeMiddleNode(LinkedNode head) {
        if (null == head || null == head.getNext())
            return head;
        if (null == head.getNext().getNext())
            return head.getNext();
        LinkedNode cur = head;
        LinkedNode doubleCur = head.getNext().getNext();
        while (null != doubleCur.getNext() && null != doubleCur.getNext().getNext()) {
            cur = cur.getNext();
            doubleCur = doubleCur.getNext().getNext();
        }
        cur.setNext(cur.getNext().getNext());
        return head;
    }

    public LinkedNode removeByRatio(LinkedNode head, int numerator, int denominator) {
        if (numerator < 1 || numerator > denominator)
            return head;
        int n = 0;
        LinkedNode cur = head;
        while (null != cur) {
            n++;
            cur = cur.getNext();
        }
        n = (int) Math.ceil((double) (numerator * n) / (double) denominator);
        if (1 == n)
            head = head.getNext();
        if (1 < n) {
            cur = head;
            while (--n != 1) {
                cur = cur.getNext();
            }
            cur.setNext(cur.getNext().getNext());
        }
        return head;
    }
}
