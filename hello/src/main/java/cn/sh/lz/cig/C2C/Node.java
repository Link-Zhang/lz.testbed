package cn.sh.lz.cig.C2C;

import java.util.LinkedList;
import java.util.Optional;

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

    public RandomLinkedNode buildRandom(int[] array) {
        if (null == array)
            return null;
        RandomLinkedNode head = new RandomLinkedNode(array[0]);
        RandomLinkedNode cur = head;
        LinkedList<RandomLinkedNode> list = new LinkedList<>();
        list.offer(cur);
        for (int i = 1; i < array.length; i++) {
            RandomLinkedNode newNode = new RandomLinkedNode(array[i]);
            cur.setNext(newNode);
            list.offer(newNode);
            cur = cur.getNext();
        }
        cur = head;
        for (int i = 0; i < array.length; i++) {
            int rand = (int) (Math.random() * (array.length + 1));
            if (array.length == rand)
                list.get(i).setRand(null);
            else
                list.get(i).setRand(list.get(rand));
        }
        return head;
    }

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

    public void print(LinkedNode head) {
        while (null != head) {
            System.out.print(head.getData() + " => ");
            head = head.getNext();
        }
        System.out.println("null");
    }

    public void print(LinkedNode head, LinkedNode tail) {
        while (null != head && tail != head) {
            System.out.print(head.getData() + " => ");
            head = head.getNext();
        }
        if (null != head)
            System.out.print(head.getData() + " => ");
        System.out.println("loop");
    }

    public void print(DoubleLinkedNode head) {
        while (null != head) {
            System.out.print(head.getLast() + " <= ");
            System.out.print(head + " : " + head.getData());
            System.out.println(" => " + head.getNext());
            head = head.getNext();
        }
    }

    public void print(RandomLinkedNode head) {
        int i = 0;
        RandomLinkedNode cur = head;
        while (null != cur) {
            System.out.println("Optional[" + ++i + "]:data=" + cur.getData());
            System.out.println("next->" + Optional.ofNullable(cur.getNext()).map(RandomLinkedNode::getData).orElse(null));
            System.out.println("rand->" + Optional.ofNullable(cur.getRand()).map(RandomLinkedNode::getData).orElse(null));
            System.out.println();
            cur = cur.getNext();
        }
    }
}
