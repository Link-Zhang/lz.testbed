package cn.sh.lz.cig.C2P8;

import cn.sh.lz.cig.C2P1.LinkedNode;
import cn.sh.lz.cig.C2P1.Node;

/***
 * @author Link
 * @date 2020/08/26
 * @time 13:48
 */
public class ListMain {
    public static void main(String[] args) {
        int[] l1 = new int[]{9, 0, 4, 5, 1};
        Node node = new Node();
        LinkedNode head = node.build(l1);
        System.out.println("The LinkedList:");
        node.print(head);
        List list = new List();
        head = list.listPartition(head, 3);
        node.print(head);
    }
}
