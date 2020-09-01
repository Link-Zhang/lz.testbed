package cn.sh.lz.cig.C2P8;

import cn.sh.lz.cig.C2P1.LinkedNode;

/***
 * @author Link
 * @date 2020/08/26
 * @time 13:10
 */
public class List {
    //    时间复杂度O(n)，空间复杂度O(1)
    public LinkedNode listPartition(LinkedNode head, int pivot) {
        LinkedNode smallHead = null;
        LinkedNode smallTail = null;
        LinkedNode equalHead = null;
        LinkedNode equalTail = null;
        LinkedNode bigHead = null;
        LinkedNode bigTail = null;
        LinkedNode next;
        while (null != head) {
            next = head.getNext();
            head.setNext(null);
            if (head.getData() < pivot) {
                if (null == smallHead) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.setNext(head);
                    smallTail = head;
                }
            } else if (head.getData() == pivot) {
                if (null == equalHead) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.setNext(head);
                    equalTail = head;
                }
            } else {
                if (null == bigHead) {
                    bigHead = head;
                    bigTail = head;
                } else {
                    bigTail.setNext(head);
                    bigTail = head;
                }
            }
            head = next;
        }
        if (null != smallTail) {
            smallTail.setNext(equalHead);
            equalTail = null == equalTail ? smallTail : equalTail; //此为神来之笔
        }
        if (null != equalTail) {
            equalTail.setNext(bigHead);
        }

        return null != smallHead ? smallHead : null != equalHead ? equalHead : bigHead;
    }

    //    时间复杂度O(n)，空间复杂度O(n)
    public LinkedNode listPartitionWithoutOrder(LinkedNode head, int pivot) {
        if (null == head) {
            return head;
        }
        LinkedNode cur = head;
        int i = 0;
        while (null != cur) {
            i++;
            cur = cur.getNext();
        }
        LinkedNode[] nodeArr = new LinkedNode[i];
        cur = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.getNext();
        }
        arrPartitionWithoutOrder(nodeArr, pivot);
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].setNext(nodeArr[i]);
        }
        nodeArr[i - 1].setNext(null);
        return nodeArr[0];
    }

    private void arrPartitionWithoutOrder(LinkedNode[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
//            算法有点绕
            if (nodeArr[index].getData() < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].getData() == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    private void swap(LinkedNode[] nodeArr, int a, int b) {
        LinkedNode temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }
}
