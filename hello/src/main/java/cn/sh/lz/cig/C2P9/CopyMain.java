package cn.sh.lz.cig.C2P9;

/***
 * @author Link
 * @date 2020/08/26
 * @time 15:09
 */
public class CopyMain {
    public static void main(String[] args) {
        RandomLinkedNode[] arr = new RandomLinkedNode[3];
        arr[0].setData(1);
        arr[0].setNext(arr[1]);
        arr[0].setRand(arr[2]);
        arr[1].setData(2);
        arr[1].setNext(arr[2]);
        arr[1].setRand(null);
        arr[2].setData(3);
        arr[2].setNext(null);
        arr[2].setRand(arr[0]);

    }
}
