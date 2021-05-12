package cn.sh.lz.cig.C2P9;

import cn.sh.lz.cig.C2C.Node;
import cn.sh.lz.cig.C2C.RandomLinkedNode;

/***
 * @author Link
 * @date 2020/08/26
 * @time 15:09
 */
public class CopyMain {
    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3};
        Node node = new Node();
        RandomLinkedNode head = node.buildRandom(list);
        node.print(head);
        System.out.println("-------------------------");
        Copy copy = new Copy();
        RandomLinkedNode result = copy.copy2(head);
        node.print(result);
    }
}
