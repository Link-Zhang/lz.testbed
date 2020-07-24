package cn.sh.lz.cig.C1P10;

import java.util.LinkedList;

/***
 * @author Link
 * @date 2020/07/24
 * @time 14:40
 */
public class SubArray {
    public int getNumber(int[] array, int num) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < array.length) {
            while (j < array.length) {
                while (!qMin.isEmpty() && array[qMin.peekLast()] >= array[j]) {
                    qMin.pollLast();
                }
                qMin.addLast(j);
                while (!qMax.isEmpty() && array[qMax.peekLast()] <= array[j]) {
                    qMax.pollLast();
                }
                qMax.addLast(j);
                if (array[qMax.getFirst()] - array[qMin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qMin.peekFirst() == i)
                qMin.pollFirst();
            if (qMax.peekFirst() == i)
                qMax.pollFirst();
            result += j - i;
            i++;
        }
        return result;
    }
}
