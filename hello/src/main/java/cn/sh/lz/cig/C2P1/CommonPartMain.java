package cn.sh.lz.cig.C2P1;

/***
 * @author Link
 * @date 2020/07/29
 * @time 15:17
 */
public class CommonPartMain {
    public static void main(String[] args) {
        int[] l1 = new int[]{2, 4, 5, 6, 7, 8};
        int[] l2 = new int[]{1, 3, 4, 5, 6, 8, 9};
        Node node = new Node();
        LinkedNode head1 = node.build(l1);
        LinkedNode head2 = node.build(l2);
        node.print(head1);
        node.print(head2);
        new CommonPart().printCommonPart(head1, head2);
    }
}
