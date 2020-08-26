package cn.sh.lz.cig.C2P6;

import cn.sh.lz.cig.C2P1.LinkedNode;
import cn.sh.lz.cig.C2P1.Node;

/***
 * @author Link
 * @date 2020/08/25
 * @time 16:03
 */
public class JosephusMain {
    public static void print(LinkedNode head, LinkedNode tail) {
        while (null != head && tail != head) {
            System.out.print(head.getData() + " => ");
            head = head.getNext();
        }
        if (null != head)
            System.out.print(head.getData() + " => ");
        System.out.println("loop");
    }

    public static void main(String[] args) {
        int[] l1 = new int[41];
        for (int i = 0; i < 41; i++) {
            l1[i] = i + 1;
        }
        Node node = new Node();
        LinkedNode head = node.build(l1);
        LinkedNode cur = head;
        while (null != cur.getNext()) {
            cur = cur.getNext();
        }
        cur.setNext(head);
        LinkedNode tail = cur;
        System.out.println("The Josephus Loop:");
        print(head, tail);

        Josephus josephus = new Josephus();
//        head=josephus.josephus(head,3);
        head = josephus.schemingJosephus(head, 3);
        System.out.println("The Lucky Dog:");
        print(head, head);


    }
}
