package cn.sh.lz.cig.C2P4;

import cn.sh.lz.cig.C2P1.LinkedNode;
import cn.sh.lz.cig.C2P1.Node;
import cn.sh.lz.cig.C2P2.DoubleLinkedNode;

/***
 * @author Link
 * @date 2020/08/25
 * @time 10:10
 */
public class ReverseMain {
    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 3, 4, 5};
        Node node = new Node();
        LinkedNode head = node.build(l1);
        System.out.println("The Original LinkedList:");
        node.print(head);

        Reverse reverse = new Reverse();
        head = reverse.reverse(head);
        System.out.println("Reversed LinkedList:");
        node.print(head);

        DoubleLinkedNode doubleHead = node.buildDouble(l1);
        System.out.println("The Original DoubleLinkedList:");
        node.print(doubleHead);

        doubleHead = reverse.reverse(doubleHead);
        System.out.println("Reversed DoubleLinkedList:");
        node.print(doubleHead);

    }
}
