package cn.sh.lz.cig.C1P7;

import java.util.LinkedList;

/***
 * @author Link
 * @date 2020/07/23
 * @time 09:53
 */
public class SlidingWindow {
    public int[] getMax(int[] arr, int w) {
        if (null == arr || w < 1 || arr.length < w) {
            return null;
        }
//        双端队列:队尾插入、删除；队头删除
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
//                双头队列不为空，且队尾小，则队列尾部删除
                qMax.pollLast();
            }
//            队列尾部插入
            qMax.addLast(i);
            if (qMax.peekFirst() == i - w) {
//                队列头部删除
                qMax.pollFirst();
            }
            if (i >= w - 1) {
//                窗口已满，可以取值
                result[index++] = arr[qMax.peekFirst()];
            }
        }
        return result;
    }

    public int[] getMin(int[] arr, int w) {
        if (null == arr || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qMin = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[i]) {
                qMin.pollLast();
            }
            qMin.addLast(i);
            if (qMin.peekFirst() == i - w) {
                qMin.pollFirst();
            }
            if (i >= w - 1) {
                result[index++] = arr[qMin.peekFirst()];
            }
        }
        return result;
    }
}
