package cn.sh.lz.cig.C2P1;

/***
 * @author Link
 * @date 2020/07/29
 * @time 13:56
 */
public class Node {
//    public void printCommonPart(LinkedNode head1, LinkedNode head2) {
//        while (null != head1 && null != head2) {
//            if (head1.getData() < head2.getData()) {
//                head1 = head1.getNext();
//            } else if (head1.getData() > head2.getData()) {
//                head2 = head2.getNext();
//            } else {
//                System.out.print(head1.getData() + " -> ");
//                head1 = head1.getNext();
//                head2 = head2.getNext();
//            }
//        }
//        System.out.println("null");
//    }

    public void printCommonPart(LinkedNode head1, LinkedNode head2) {
        while (null != head1 && null != head2 && head1.getData() != head2.getData()) {
            if (head1.getData() < head2.getData()) {
                head1 = head1.getNext();
            } else if (head1.getData() > head2.getData()) {
                head2 = head2.getNext();
            }
        }
        while (null != head1 && null != head2 && head1.getData() == head2.getData()) {
            System.out.print(head1.getData() + " -> ");
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        System.out.println("null");
    }

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

    public void print(LinkedNode head) {
        while (null != head) {
            System.out.print(head.getData() + " => ");
            head = head.getNext();
        }
        System.out.println("null");
    }
}
