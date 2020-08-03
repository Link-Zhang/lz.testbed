package cn.sh.lz.cig.C2P2;

import cn.sh.lz.cig.C2P1.LinkedNode;
import cn.sh.lz.cig.C2P1.Node;

/***
 * @author Link
 * @date 2020/07/29
 * @time 17:08
 */
public class RemoveLastKthNodeMain {
    public static void main(String[] args) {
        int[] l1 = new int[]{3, 4, 5};
        Node node = new Node();
        LinkedNode head = node.build(l1);
        RemoveLastKthNode removeLastKthNode = new RemoveLastKthNode();
        head = removeLastKthNode.removeLastKthNode(head, 2);
        node.print(head);

        System.out.println("-------------------------");

        DoubleLinkedNode doubleHead = node.buildDouble(l1);
        doubleHead = removeLastKthNode.removeLastKthNode(doubleHead, 2);
        node.print(doubleHead);
    }
}
