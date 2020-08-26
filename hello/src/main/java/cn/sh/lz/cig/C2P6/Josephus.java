package cn.sh.lz.cig.C2P6;

import cn.sh.lz.cig.C2P1.LinkedNode;

/***
 * @author Link
 * @date 2020/08/25
 * @time 11:33
 */
public class Josephus {
    //  时间复杂度 O(n*m)
    public LinkedNode josephus(LinkedNode head, int m) {
        if (null == head || head.getNext() == head || m < 1) {
            return head;
        }
        LinkedNode last = head;
        while (last.getNext() != head) {
            last = last.getNext();
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.setNext(head.getNext());
                count = 0;
            } else {
                last = last.getNext();
            }
            head = last.getNext();
        }
        return head;
    }

    //  时间复杂度 O(n)
    public LinkedNode schemingJosephus(LinkedNode head, int m) {
        if (null == head || head.getNext() == head || m < 1) {
            return head;
        }
        LinkedNode cur = head.getNext();
        int count = 1;
        while (cur != head) {
            count++;
            cur = cur.getNext();
        }
        int number = getLuckyDogNumber(count, m);
        while (--number != 0) {
            head = head.getNext();
        }
        head.setNext(head);
        return head;
    }

    public int getLuckyDogNumber(int i, int m) {
        if (1 == i) {
            return 1;
        }
//        old=(new+m-1)%i+1
        return (getLuckyDogNumber(i - 1, m) + m - 1) % i + 1;
    }
}
