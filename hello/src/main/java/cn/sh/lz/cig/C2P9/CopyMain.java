package cn.sh.lz.cig.C2P9;

import java.util.Optional;

/***
 * @author Link
 * @date 2020/08/26
 * @time 15:09
 */
public class CopyMain {
    public static void print(RandomLinkedNode head) {
        int i = 0;
        RandomLinkedNode cur = head;
        while (null != cur) {
            System.out.println("Optional[" + ++i + "]:data=" + cur.getData());
            System.out.println("next->" + Optional.ofNullable(cur.getNext()).map(RandomLinkedNode::getData).orElse(null));
            System.out.println("rand->" + Optional.ofNullable(cur.getRand()).map(RandomLinkedNode::getData).orElse(null));
            System.out.println();
            cur = cur.getNext();
        }
    }

    public static void main(String[] args) {
        RandomLinkedNode[] arr = new RandomLinkedNode[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = new RandomLinkedNode(i + 1);
        }
        arr[0].setNext(arr[1]);
        arr[0].setRand(arr[2]);
        arr[1].setNext(arr[2]);
        arr[1].setRand(null);
        arr[2].setNext(null);
        arr[2].setRand(arr[0]);
        print(arr[0]);
        Copy copy = new Copy();
        RandomLinkedNode arr1 = copy.copy(arr[0]);
        print(arr1);
        RandomLinkedNode arr2 = copy.copy2(arr[0]);
        print(arr2);
    }
}
