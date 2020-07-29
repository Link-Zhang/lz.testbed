package cn.sh.lz.cig.C2P2;

import cn.sh.lz.cig.C2P1.LinkedNode;

/***
 * @author Link
 * @date 2020/07/29
 * @time 16:52
 */
public class Node {
    public LinkedNode removeLastKthNode(LinkedNode head, int k) {
        if (null == head || k < 1)
            return head;
        LinkedNode ahead = head;
        LinkedNode pre = null;
        LinkedNode cur = head;
        while (k > 0 && null != ahead) {
            k--;
            ahead = ahead.getNext();
        }
        if (k > 0) {
            return head;
        }
        while (null != ahead) {
            ahead = ahead.getNext();
            pre = cur;
            cur = cur.getNext();
        }
        if (null == pre)
            return null;
        if (null != cur)
            pre.setNext(cur.getNext());
        return head;
    }

}
