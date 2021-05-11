package cn.sh.lz.cig.C2P10;

import java.util.Optional;

/**
 * Created by Link at 09:40 on 2021/05/11.
 */
public class NumberMain {
    public static void print(NumberLinkedNode head) {
        NumberLinkedNode cur = head;
        while (null != cur) {
            if (head == cur)
                System.out.print(cur.getValue());
            System.out.print("->" + Optional.ofNullable(cur.getNext()).map(NumberLinkedNode::getValue).orElse(null));
            cur = cur.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NumberLinkedNode[] arr1 = new NumberLinkedNode[3];
        for (int i = 0; i < 3; i++) {
            arr1[i] = new NumberLinkedNode(0);
        }
        arr1[0].setValue(9);
        arr1[0].setNext(arr1[1]);
        arr1[1].setValue(3);
        arr1[1].setNext(arr1[2]);
        arr1[2].setValue(7);
        arr1[2].setNext(null);
        NumberLinkedNode head1 = arr1[0];

        NumberLinkedNode[] arr2 = new NumberLinkedNode[2];
        for (int i = 0; i < 2; i++) {
            arr2[i] = new NumberLinkedNode(0);
        }
        arr2[0].setValue(6);
        arr2[0].setNext(arr2[1]);
        arr2[1].setValue(3);
        arr2[1].setNext(null);
        NumberLinkedNode head2 = arr2[0];
        Number number = new Number();
        NumberLinkedNode result1 = number.add2(head1, head2);
        NumberLinkedNode result2 = number.minus(head1, head2);

        print(head1);
        print(head2);
        print(result1);
        print(result2);
    }
}
