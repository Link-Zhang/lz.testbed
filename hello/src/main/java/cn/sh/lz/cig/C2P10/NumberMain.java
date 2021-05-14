package cn.sh.lz.cig.C2P10;

import cn.sh.lz.cig.C2C.LinkedNode;
import cn.sh.lz.cig.C2C.Node;

/**
 * Created by Link at 09:40 on 2021/05/11.
 */
public class NumberMain {
    public static void main(String[] args) {
        int[] l1 = new int[]{9, 3, 7};
        int[] l2 = new int[]{6, 3};
        Node node = new Node();
        LinkedNode head1 = node.build(l1);
        LinkedNode head2 = node.build(l2);
        Number number = new Number();
        LinkedNode result1 = number.add2(head1, head2);
        LinkedNode result2 = number.minus(head1, head2);
        node.print(head1);
        node.print(head2);
        node.print(result1);
        node.print(result2);
    }
}
