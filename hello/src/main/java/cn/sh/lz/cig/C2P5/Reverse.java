package cn.sh.lz.cig.C2P5;

import cn.sh.lz.cig.C2P1.LinkedNode;
import cn.sh.lz.cig.C2P2.DoubleLinkedNode;

/***
 * @author Link
 * @date 2020/08/25
 * @time 10:26
 */
public class Reverse {
    //    [head, ... , fPre, from, ... , to, tPos, ... , tail]
    public LinkedNode reversePart(LinkedNode head, int from, int to) {
        int len = 0;
        LinkedNode cur = head;
        LinkedNode fPre = null;
        LinkedNode tPos = null;
        while (null != cur) {
            len++;
            fPre = len == from - 1 ? cur : fPre;
            tPos = len == to + 1 ? cur : tPos;
            cur = cur.getNext();
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
//        [ fPre, node1, node2, next, ... , tPos]
        LinkedNode node1 = null == fPre ? head : fPre.getNext();
        LinkedNode node2 = node1.getNext();
        node1.setNext(tPos);
        LinkedNode next;
        while (tPos != node2) {
            next = node2.getNext();
            node2.setNext(node1);
            node1 = node2;
            node2 = next;

        }
        if (null != fPre) {
            fPre.setNext(node1);
            return head;
        }
        return node1;
    }

    public DoubleLinkedNode reversePart(DoubleLinkedNode head, int from, int to) {
        int len = 0;
        DoubleLinkedNode cur = head;
        DoubleLinkedNode fPre = null;
        DoubleLinkedNode tPos = null;
        while (null != cur) {
            len++;
            tPos = len == to + 1 ? cur : tPos;
            fPre = len == from - 1 ? cur : fPre;
            cur = cur.getNext();
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        DoubleLinkedNode node1 = fPre == null ? head : fPre.getNext();
        DoubleLinkedNode node2 = node1.getNext();
        if (null != tPos) {
            tPos.setLast(node1);
        }
        node1.setNext(tPos);
        node1.setLast(node2);
        DoubleLinkedNode next;
        while (tPos != node2) {
            next = node2.getNext();
            node2.setNext(node1);
            node2.setLast(next);
            node1 = node2;
            node2 = next;
        }
        if (null != fPre) {
            fPre.setNext(node1);
            node1.setLast(fPre);
            return head;
        }
        node1.setLast(null);
        return node1;
    }
}
