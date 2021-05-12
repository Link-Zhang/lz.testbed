package cn.sh.lz.cig.C2P3;

import cn.sh.lz.cig.C2C.LinkedNode;
import cn.sh.lz.cig.C2C.Node;

/***
 * @author Link
 * @date 2020/07/30
 * @time 12:08
 */
public class RemoveMiddleNodeMain {
    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 3, 4, 5};
        Node node = new Node();
        LinkedNode head = node.build(l1);
        RemoveMiddleNode removeMiddleNode = new RemoveMiddleNode();
        head = removeMiddleNode.removeByRatio(head, 2, 5);
        node.print(head);
        head = removeMiddleNode.removeMiddleNode(head);
        node.print(head);
    }
}
