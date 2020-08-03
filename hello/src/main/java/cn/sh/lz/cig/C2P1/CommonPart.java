package cn.sh.lz.cig.C2P1;

/***
 * @author Link
 * @date 2020/07/30
 * @time 10:43
 */
public class CommonPart {
    //        public void printCommonPart(LinkedNode head1, LinkedNode head2) {
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
}
