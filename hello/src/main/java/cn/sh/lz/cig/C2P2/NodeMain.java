package cn.sh.lz.cig.C2P2;

import cn.sh.lz.cig.C2P1.LinkedNode;
import cn.sh.lz.cig.C2P1.Node;

/***
 * @author Link
 * @date 2020/07/29
 * @time 17:08
 */
public class NodeMain {
    public static void main(String[] args) {
        int[] l1 = new int[]{ 3, 4, 5};
        cn.sh.lz.cig.C2P1.Node commonNode = new Node();
        LinkedNode head = commonNode.build(l1);
        cn.sh.lz.cig.C2P2.Node node = new cn.sh.lz.cig.C2P2.Node();
        head = node.removeLastKthNode(head, 4);
        commonNode.print(head);

    }
}
