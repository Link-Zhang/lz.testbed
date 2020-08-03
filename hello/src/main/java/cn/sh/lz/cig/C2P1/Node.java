package cn.sh.lz.cig.C2P1;

import cn.sh.lz.cig.C2P2.DoubleLinkedNode;

/***
 * @author Link
 * @date 2020/07/29
 * @time 13:56
 */
public class Node {
    public LinkedNode build(int[] array) {
        if (null == array)
            return null;
        LinkedNode head = new LinkedNode(array[0]);
        LinkedNode temp = head;
        for (int i = 1; i < array.length; i++) {
            LinkedNode newNode = new LinkedNode(array[i]);
            temp.setNext(newNode);
            temp = temp.getNext();
        }
        return head;
    }

    public void print(LinkedNode head) {
        while (null != head) {
            System.out.print(head.getData() + " => ");
            head = head.getNext();
        }
        System.out.println("null");
    }

    public DoubleLinkedNode buildDouble(int[] array) {
        if (null == array)
            return null;
        DoubleLinkedNode head = new DoubleLinkedNode(array[0]);
        head.setLast(null);
        head.setNext(null);
        DoubleLinkedNode temp = head;
        for (int i = 1; i < array.length; i++) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(array[i]);
            newNode.setLast(temp);
            temp.setNext(newNode);
            temp = newNode;
        }
        temp.setNext(null);
        return head;
    }

    public void print(DoubleLinkedNode head) {
        while (null != head) {
            System.out.print(head.getLast() + " <= ");
            System.out.print(head + " : " + head.getData());
            System.out.println(" => " + head.getNext());
            head = head.getNext();
        }
    }
}
